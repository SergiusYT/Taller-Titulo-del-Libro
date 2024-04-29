package Controller;

import Model.*;
import View.*;  // importo el paquete vista y con los signos " .*; " indico que traiga todos los archivos de ese paquete 

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;  // esta libreria sirve para ubicar un elemento local 

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.sound.sampled.*; // esto es para agragar musica 








public class Controller implements ActionListener{
	 
	  private Ventana_Principal inicio; //declaro un atributo para la instancia
	  private Ventana_Celular celular;
	  private Ventana_Apellido apellido;
	  private Ventana_Fecha fecha;
	  private Ventana_Titulo titulo;
	  

	  private Apellido letra;
	  private Fecha cumpleaños;
	  private Celular digito;
	  
	  private GregorianCalendar cal ;
	  
	  private File archivo;
	  private Clip audio;
		
	  
  public Controller(){
	  
	  inicio= new Ventana_Principal();   //creacion de nueva instancia 
      apellido= new Ventana_Apellido();
      fecha= new Ventana_Fecha(); 
      celular= new Ventana_Celular();
      titulo= new Ventana_Titulo();
	  
	
	  letra= new Apellido();
	  digito=new Celular();
	 
	

	  add_Componentes();  
  }
	  
	  

  public void ejecutar() {
		
	  inicio.setVisible(true);
	  Activacion_nuevo_Audio();	
	 }
  
  
  
  public void add_Componentes() {                  /* funcion que agragamos para que adjunte los componentes de la ventana de inicio
      para darle un alias a cada uno*/
	  
	  
	  
     inicio.getSalir().addActionListener(this);
     inicio.getSalir().setActionCommand("boton_salida");
     inicio.getComenzar().addActionListener(this);
     inicio.getComenzar().setActionCommand("boton_comenzar");
     
     
     apellido.getValidar().addActionListener(this);
     apellido.getValidar().setActionCommand("boton_validar");
     celular.getValidar().addActionListener(this);
     celular.getValidar().setActionCommand("boton_validar2");
     
     apellido.getSiguiente().addActionListener(this);
     apellido.getSiguiente().setActionCommand("boton_siguiente");
     fecha.getSiguiente().addActionListener(this);
     fecha.getSiguiente().setActionCommand("boton_siguiente2");
     celular.getSiguiente().addActionListener(this);
     celular.getSiguiente().setActionCommand("boton_siguiente3");
    
   
     apellido.getVolver().addActionListener(this);
     apellido.getVolver().setActionCommand("boton_volver");
     fecha.getVolver().addActionListener(this);
     fecha.getVolver().setActionCommand("boton_volver2");
     celular.getVolver().addActionListener(this);
     celular.getVolver().setActionCommand("boton_volver3");
     titulo.getVolver().addActionListener(this);
     titulo.getVolver().setActionCommand("boton_volver4");
     
   
   }
//-------------------------------------------------------------------------------------------------------------------------




			
					/* AGREGAR MUSICA */	
		 
			public void Activacion_nuevo_Audio() {	
			
			try {  // tiene que aver una execpcion para que indicar que el audio se pueda ejercutar de la manera mas adecuada y siga su curso hasta que termine
	 
			archivo = new File("Resources/Soundtrack.wav");
			AudioInputStream musica = AudioSystem.getAudioInputStream(archivo);
			audio = AudioSystem.getClip();
		    audio.open(musica);
		    audio.start();
		    audio.loop(Clip.LOOP_CONTINUOUSLY); // esto servira para que el audio se repita como un bucle y parara hasta que se cierre el programa
		} catch (Exception e) {
	        e.printStackTrace();		
		}

				
		  	      
}


//---------------------------------------------------------------------------------------------------------------------------
  
  
  public void Eventos(ActionEvent Eventos_Inicio) {
		
		
		switch(Eventos_Inicio.getActionCommand()) {
		
		case "boton_salida":
			
			 inicio.cerrar();
			 
		break;	
		
		case "boton_comenzar":
			
			inicio.dispose();
			 apellido.setVisible(true);
	
		break;	
		
		
		case "boton_validar":
			
			// MANERA MAS ADECUADA PARA IMPLEMENTAR ESTO EN UN CONTROLADOR
			
	        try {	
	        	 apellido.validarEntrada( apellido.getNombreIngresado()); // Llamo un metodo de modelo para comprobar si el texto ingresado no contiene caracteres especiales o numeros			
                letra.obtenerPrimeraletra( apellido.getNombreIngresado()); //llamo un metodo del modelo que me leera la primera letra de ese nombre
                apellido.mostrarNombre( apellido.getNombreIngresado());
                apellido.mostrarInicial(letra.obtenerPrimeraletra(apellido.getNombreIngresado())); 
	        
	        }catch(IllegalArgumentException e) {
	        	 apellido.mostrar_Error();
	        }
               
	      
                
		break;
		
		case "boton_siguiente":
			
			apellido.dispose();
			fecha.setVisible(true);
			 
			 fecha.getCalendario().addPropertyChangeListener("calendar", new PropertyChangeListener() {
				 
	//Un PropertyChangeListener es un oyente que se activa cuando una propiedad de un objeto cambia. 			 
				 
			        @Override
			        public void propertyChange(PropertyChangeEvent e) {
			            if (e.getNewValue() instanceof GregorianCalendar) {
			                cal = (GregorianCalendar) e.getNewValue();
			                
			 /*se verifica si el nuevo valor de la propiedad (obtenido a través de e.getNewValue())
			  es una instancia de GregorianCalendar, que es el tipo de dato que representa una fecha en el calendario. 
			  Si es así, se extraen el día, el mes y el año de ese GregorianCalendar.               
		            
			   */             
			              //  int dia = cal.get(Calendar.DAY_OF_MONTH);
			              //  int mes = cal.get(Calendar.MONTH) + 1; // se agrega 1 porque Enero comienza desde 0
			              //  int año = cal.get(Calendar.YEAR);
			                
			                cumpleaños= new Fecha(cal.get(Calendar.DAY_OF_MONTH),  cal.get(Calendar.MONTH) + 1, cal.get(Calendar.YEAR));// se le agrega los valores seleccionados al modelo y por eso la inicializo aca porque tengo que tomar esos valores
			                fecha.visualizacion_mes_seleccionado(cal.get(Calendar.MONTH) + 1);
			                fecha.visualizacion_fecha_seleccionada(cal.get(Calendar.DAY_OF_MONTH),cal.get(Calendar.MONTH) + 1 , cal.get(Calendar.YEAR)); //se vizualisan los valores que seleccione el usuario
			            }
			        }
			    });	 


		break;
		
		case "boton_siguiente2":
			 
			
			fecha.dispose();
			celular.setVisible(true);
					
		break;	
		
		
		case "boton_validar2":
			
            
			
	        try {	
                celular.validarEntrada(celular.getCelularIngresado()); // Llamo un metodo de modelo para comprobar si el texto ingresado no contiene caracteres especiales o numeros			
                digito.obtenerUltimoDigito(celular.getCelularIngresado()); //llamo un metodo del modelo que me leera la primera letra de ese nombre
                celular.mostrarCelular(celular.getCelularIngresado());
                celular.mostrarUltimoDigito(digito.obtenerUltimoDigito(celular.getCelularIngresado()));; 
	        
	        }catch(IllegalArgumentException e) {
	        	celular.mostrar_Error();
	        }
	        
		break;	
		
		case "boton_siguiente3":
			
			celular.dispose();
			titulo.setVisible(true);
			
			
			//	letra.obtenerTextoPorCaracter(letra.obtenerPrimeraletra( apellido.getNombreIngresado()));
				
				//int mesSeleccionado = cal.get(Calendar.MONTH) + 1;
				ArrayList<Opcion> opcionesDelMes = cumpleaños.obtenerOpcionesPorMes(cal.get(Calendar.MONTH) + 1);
				
				String opcionesMes = ""; // proceso el cual tomare todo el arraylist y lo pasare a cadena para evitar problemas estructurales en la vista
				
				for (Opcion opcion : opcionesDelMes) { // recorrer todos los elementos de opcionesDelMes donde opcion tomara cada elemento
					
				    opcionesMes += opcion.getTexto() + "  ";// agregamos el texto que contenga el mes a la cadena que contiene dos espacios esto es para evitar que el programa me mande un erro que este vacio la cadena
				
				}

				if (opcionesMes.length() > 0) {  // verificar si la cadena esta vacia
				    opcionesMes = opcionesMes.substring(0, opcionesMes.length() - 2); // Eliminar los ultimos dos espacio para un orden
				}
				
				titulo.mostrarOpcion(letra.obtenerTextoPorCaracter(letra.obtenerPrimeraletra( apellido.getNombreIngresado())) , opcionesMes, digito.obtenerTextoPorDigito(digito.obtenerUltimoDigito(celular.getCelularIngresado())));
			
		break;	
	    
        case "boton_volver":
			
        	 apellido.dispose();
			inicio.setVisible(true);
						
		break;	
		
       case "boton_volver2":
			
			fecha.dispose();
			 apellido.setVisible(true);
						
		break;	
		
       case "boton_volver3":
			
			celular.dispose();
			fecha.setVisible(true);
			
		break;	
		
       case "boton_volver4":
			
			titulo.dispose();
			inicio.setVisible(true);
			
		break;	
		
		
		}
		
  }
  
  
//-----------------------------------------------------------------------------------------------------------------------------  
  
  @Override
  public void actionPerformed(ActionEvent e) {
	  
	// Activacion de los eventos 
               Eventos(e);
  	
  }
	
 }
