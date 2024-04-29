package View;

import java.awt.*;
import javax.swing.*;


// PASAR DE DECIMAL A BINARIO 


public class Ventana_Titulo extends JFrame {


	private static final long serialVersionUID = 1L;

	private JLabel enunciado,opcion;
	private JButton volver;

	private Fondo fondo, componentes;
	
	public Ventana_Titulo () {

		
		setSize(1200, 700); 
		setLocationRelativeTo(null); 
		setTitle("Ejercicio2");
		setResizable(false);
		setLayout(null);
		setUndecorated(true); 
	
		
		fondo = new Fondo(); //creacion de nueva instancia 		
		setContentPane(fondo); // agregamos el contenido que lleva este Jpanel a la ventana 
		
		
		
		volver = new JButton("Volver al menu");
		volver.setBounds(20, 620, 350, 50);
		volver.setForeground(Color.white);
		volver.setBackground(Color.BLACK);
		volver.setFont(new Font("windows command prompt", Font.BOLD,40));
		volver.setFocusPainted(false);
		volver.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
		
		enunciado = new JLabel("El titulo del libro de tu vida es: ");
		enunciado.setBounds(80, 20, 800, 100);
		enunciado.setForeground(Color.white);
		enunciado.setFont(new Font("windows command prompt", Font.PLAIN, 55));	

		
		opcion = new JLabel();
		opcion.setBounds(120, 100, 950, 500);
		opcion.setForeground(Color.white);
		opcion.setFont(new Font("windows command prompt", Font.ITALIC, 75));	
	
		
	    componentes = new Fondo();	
		                                          //agregacion de componentes en el panel del fondo
	    componentes.add(volver);
	    componentes.add(enunciado);
	    componentes.add(opcion);
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
	      
 	      
	  
	   public void mostrarOpcion(String texto ,String texto2, String texto3) {
		        // Supongamos que 'nombreLabel' es tu JLabel donde deseas mostrar el texto
		    String texto_html = "<html><body style='text-align: center;'> '' "+texto + texto2 + texto3+ " ''</body></html>";
            		   
	        opcion.setText(texto_html);
        }
			

		public JButton getVolver() {
			return volver;
		}

		public void setVolver(JButton volver) {
			this.volver = volver;
		}
		
	
     
	      
	
}
