package View;

import java.awt.*;
import java.text.DateFormatSymbols;

import javax.swing.*;
import com.toedter.calendar.JCalendar;// clase exportada que servira para la realizacion de un calendario



// PASAR DE DECIMAL A BINARIO 


public class Ventana_Fecha extends JFrame {


	private static final long serialVersionUID = 1L;

	private JLabel texto,seleccion, mes;
	private JButton volver,siguiente;
	private JCalendar calendario;
	
	private Fondo fondo, componentes;
	
	public Ventana_Fecha() {

		
		setSize(1200, 700); 
		setLocationRelativeTo(null); 
		setTitle("Ejercicio3");
		setResizable(false);
		setLayout(null);
		setUndecorated(true); 

	
		
		fondo = new Fondo(); //creacion de nueva instancia 		
		setContentPane(fondo); // agregamos el contenido que lleva este Jpanel a la ventana 
		
	
		
		volver = new JButton("Volver");
		volver.setBounds(20, 620, 190, 50);
		volver.setForeground(Color.white);
		volver.setBackground(Color.BLACK);
		volver.setFont(new Font("windows command prompt", Font.BOLD,40));
		volver.setFocusPainted(false);
		volver.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
		
		siguiente = new JButton("Siguiente");
		siguiente.setBounds(980, 620, 190, 50);
		siguiente.setForeground(Color.white);
		siguiente.setBackground(Color.BLACK);
		siguiente.setFont(new Font("windows command prompt", Font.BOLD,40));
		siguiente.setFocusPainted(false);
		siguiente.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
		
		
		
		calendario = new JCalendar();
        calendario.setBounds(40, 150, 500, 400); 
        

		texto = new JLabel("Escoja su fecha de nacimiento :)");
		texto.setBounds(150,40,1150,100);
		texto.setForeground(Color.white);
		texto.setFont(new Font("windows command prompt", Font.BOLD, 65));
		
		seleccion = new JLabel();
		seleccion.setBounds(600,150,500,100);
		seleccion.setForeground(Color.CYAN);
		seleccion.setFont(new Font("windows command prompt", Font.BOLD, 35));
		
		mes = new JLabel();
		mes.setBounds(600,290,500,100);
		mes.setForeground(Color.CYAN);
		mes.setFont(new Font("windows command prompt", Font.BOLD, 35));
		
		
		
		
	      componentes = new Fondo();	
		                                          //agregacion de componentes en el panel del fondo
		  componentes.add(volver);
		  componentes.add(calendario);
		  componentes.add(texto);
		  componentes.add(seleccion);
		  componentes.add(siguiente);
		  componentes.add(mes);
	      componentes.setLayout(null);  
		  setContentPane(componentes); 
		
	}
	
	

	
	
	
	
	//------------------------------------------------------------------------------------------------------------------------------
	            /* CREACION DE UN JPanel QUE TENDRA EL FONDO DE LA VENTANA DE INICIO*/


	      public class Fondo extends JPanel {

	         private static final long serialVersionUID = 1L;



	       @Override
	       public void paintComponent(Graphics img)	{ 


	       Image fondo = new ImageIcon("Resources/Fondo_Inicio.gif").getImage(); 


	  img.drawImage(fondo, 0, 0, getWidth(),getHeight(), this);



	          setOpaque(false);
	         super.paintComponent(img); 

	     }   
	 
	 
	       
	       
	  }

	    public void visualizacion_fecha_seleccionada(int dia, int mes, int año) {
	  		
	          seleccion.setText("Fecha seleccionada: " + dia + "/" + mes + "/" + año);

	  	} 
	    
	    public void visualizacion_mes_seleccionado(int mes_seleccionado) {
			
	    	 DateFormatSymbols numero_mes = new DateFormatSymbols();
	         String[] meses = numero_mes.getMonths();
	         
	         if (mes_seleccionado >= 1 && mes_seleccionado <= 12) {
	             String nombreMes = meses[mes_seleccionado - 1]; // Los meses en DateFormatSymbols comienzan desde 0
	             mes.setText("Mes de nacimiento: " + nombreMes);
	         }

		}
	      
		public JButton getVolver() {
			return volver;
		}

		public void setVolver(JButton volver) {
			this.volver = volver;
		}
		
		public JButton getSiguiente() {
			return siguiente;
		}

		public void setSiguiente(JButton siguiente) {
			this.siguiente = siguiente;
		}
		
		
		public JCalendar getCalendario() {
			return calendario;
		}

		public void setVolver(JCalendar calendario) {
			this.calendario = calendario;
		}
	      
     
	      
	
}
