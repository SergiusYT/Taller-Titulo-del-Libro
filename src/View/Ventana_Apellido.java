package View;

import java.awt.*;
import javax.swing.*;


// PASAR DE DECIMAL A BINARIO 


public class Ventana_Apellido extends JFrame {


	private static final long serialVersionUID = 1L;

	private JLabel apellido , inicial, enunciado;
	private JButton volver, validar, siguiente;
	private JTextField entrada;
	
	private Fondo fondo, componentes;
	
	public Ventana_Apellido () {

		
		setSize(1200, 700); 
		setLocationRelativeTo(null); 
		setTitle("Ejercicio2");
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
		
		apellido = new JLabel();
		apellido.setBounds(130,240, 800, 500);
		apellido.setForeground(Color.white);
		apellido.setFont(new Font("windows command prompt", Font.PLAIN, 45));
		
		inicial = new JLabel();
		inicial.setBounds(680,240, 800, 500);
		inicial.setForeground(Color.white);
		inicial.setFont(new Font("windows command prompt", Font.PLAIN, 45));
		
		enunciado = new JLabel("<html><body style='text-align:justify;'>Ingrese su primer apellido y presione validar para seguir.</body></html>");
		enunciado.setBounds(140, 0, 900, 250);
		enunciado.setForeground(Color.white);
		enunciado.setFont(new Font("windows command prompt", Font.PLAIN, 65));	
		
		
		
		entrada = new JTextField();
		entrada.setBounds(350,280,250,50);
		entrada.setFont(new Font("windows command prompt", Font.PLAIN, 35));	
		

		validar = new JButton("Validar");
		validar.setBounds(620, 280, 190, 50);
		validar.setForeground(Color.white);
		validar.setBackground(Color.BLACK);
		validar.setFont(new Font("windows command prompt", Font.BOLD,40));
		validar.setFocusPainted(false);
		validar.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
		
		siguiente = new JButton("Siguiente");
		siguiente.setBounds(980, 620, 190, 50);
		siguiente.setForeground(Color.white);
		siguiente.setBackground(Color.BLACK);
		siguiente.setFont(new Font("windows command prompt", Font.BOLD,40));
		siguiente.setFocusPainted(false);
		siguiente.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
		
	
		
	    componentes = new Fondo();	
		                                          //agregacion de componentes en el panel del fondo
	    componentes.add(volver);
	    componentes.add(apellido );
	    componentes.add(inicial);
	    componentes.add(enunciado);
	    componentes.add(entrada);
	    componentes.add(validar);
	    componentes.add(siguiente);
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
	      
	   public boolean esTextoValido(String texto) {
	          return texto.matches("[a-zA-Z]+"); 
	        //[a-zA-Z]: Es una clase de caracteres que representa cualquier letra en minúscula (a a z) o en mayúscula (A a Z).
	          // y el + que aparece tambien indica que de aparecer al menos una vez una letra
	  }
	  	
	  public void validarEntrada(String entrada) {
	  		
	  		if(entrada.isEmpty()) {  // si esta vacio el string se iniciara la condicion
	  			throw new IllegalArgumentException(); /*el thorow "no negare que es algo nuevo que experimente" se utiliza para indicar que ha 
	  			ocurrido un problema y lanze una excepcion especifica , donde cabe recalcar que esto es una instancia de la clase Throwable*/
	          } else if (!esTextoValido(entrada)) 
	              throw new IllegalArgumentException();
	  }    
	      
	  
	  public void mostrarNombre(String apell) {

			apellido.setText("Nombre Ingresado: "+apell);
	  }    
	  
	  public void mostrarInicial(char caracter) {
	       inicial.setText("Inicial: "+ caracter);
	  }    
	      
	      
	  public void mostrar_Error() {
		  JOptionPane.showMessageDialog(null, "Por favor ingrese un nombre (recuerde no ingresar ningun caracter especial o numero)", "ERROR", JOptionPane.ERROR_MESSAGE);
	  }
	  
	  
	 
	      
	    public JButton getSiguiente() {
	    	return siguiente;
	    }
	    
	    public void setSiguiente(JButton siguiente) {
	    	this.siguiente= siguiente;
	    }
	      
	    public JButton getValidar() {
				return validar;
		}

		public void setValidar(JButton validar) {
				this.validar = validar ;
		}
			

		public JButton getVolver() {
			return volver;
		}

		public void setVolver(JButton volver) {
			this.volver = volver;
		}
		
		public String getNombreIngresado() {
			return entrada.getText();
		}
	      
		public void setNombreIngresado(JTextField entrada) {
			this.entrada = entrada;
		}
	      
	
}
