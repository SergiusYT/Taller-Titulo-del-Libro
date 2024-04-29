package View;

import java.awt.*;
import javax.swing.*;

public class Ventana_Principal extends JFrame{  // se crea una clase que tendra la exrencion Jframe para el uso de una ventana emergente

	private static final long serialVersionUID = 0;  // ID  " DUDA QUE ES UNA SERIALIZACION Y EL OBJETIVO PRINCIPAL DE ESTA PRACTICA CON ESTA LINEA DE CODIGO
	
	private JLabel nombre,titulo,img1,img2,texto;
	private JButton salir,comenzar;
	
	
	private Fondo_Inicio fondo; //declaro un atributo para la instancia
	
	
//--------------------------------------------------------------------------------------------------------------------------------------
	
	             /* CONSTRUCTOR */
//	Color azulito_claro= new Color(49, 161, 198);
	
	
	public Ventana_Principal()  { // se llama la clase anterior mente creada para establecer las caracteristicas de la ventana (contructor)
	
		
		setSize(1200, 700); // aca declara el tamaño de la ventana
		setLocationRelativeTo(null); // al no tener una ubicacion, este se ubicara de manera predeterminada en el centro de cualquier pantalla  
		setTitle("Inicio");
		setResizable(false);
		setLayout(null);
		setUndecorated(true); //no saldra la linea de arriba
		
		fondo = new Fondo_Inicio(); //creacion de nueva instancia 		
		setContentPane(fondo); // agregamos el contenido que lleva este Jpanel a la ventana 
		
		
	//JLabels 	
		
		nombre = new JLabel("Sergio Andrés Lozano Bueno");
		nombre.setBounds(40,0,500, 80);
		nombre.setForeground(Color.CYAN);
		nombre.setFont(new Font("windows command prompt" , Font.ITALIC,32));
		
		texto = new JLabel("<html><body style='text-align:center;'>''¿Cómo se llamaría el libro de tu vida?''</body></html>");
		texto.setBounds(240,210,700, 300);
		texto.setForeground(Color.white);
		texto.setFont(new Font("windows command prompt" , Font.ITALIC,78));
		
		titulo = new JLabel("<html><body style='text-align:center;'>Quieres saber...<p> </p> </body></html>");
		titulo.setBounds(90,90,800,120);
		titulo.setForeground(Color.white);
		titulo.setFont(new Font("windows command prompt", Font.BOLD, 80));
		
		
		
		
		img1 = new JLabel();
		img1.setBounds(970,20,180,150);
		Image img = new ImageIcon("Resources/logo_de_la_mejor_universidad_del_mundo.png").getImage(); // creacion de un objeto llamando la imagen 
		ImageIcon dimenciones =new ImageIcon(img.getScaledInstance(img1.getWidth(), img1.getHeight(), Image.SCALE_SMOOTH)); 
		// el scale_smooth es para ajustar la imagen y que tenga en cuenta el ancho y el alto en la escala de la imagen
		img1.setIcon(dimenciones);	
		
		
		img2 = new JLabel();
		img2.setBounds(850,360,300,290);
		Image img_2 = new ImageIcon("Resources/Animacion.gif").getImage(); 
		ImageIcon dimenciones2 =new ImageIcon(img_2.getScaledInstance(img2.getWidth(), img2.getHeight(), Image.SCALE_FAST)); 
		// se deja scale default para que el gif reprodusca de manera nativa
		img2.setIcon(dimenciones2);	
		
		
		
     //botones
		
		salir= new JButton("Salir");
		salir.setBounds(20, 600, 190, 80);
		salir.setForeground(Color.white);
		salir.setBackground(Color.BLACK);
		salir.setFont(new Font("windows command prompt", Font.BOLD,45));
		salir.setFocusPainted(false);
		salir.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));// es para poner el grosor del deliniado y un color a este
		
		
		comenzar= new JButton("<html><body style='text-align:center;'>Quiero descubrirlo :D</body></html>");
		comenzar.setBounds(880, 590, 290, 90);
		comenzar.setForeground(Color.white);
		comenzar.setBackground(Color.BLACK);
		comenzar.setFont(new Font("windows command prompt", Font.BOLD,40));
		comenzar.setFocusPainted(false);
		comenzar.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));// es para poner el grosor del deliniado y un color a este
		
	
		
		
		
		
		
		
		Fondo_Inicio componentes = new Fondo_Inicio();
		
		componentes.add(nombre);
		componentes.add(titulo);
		componentes.add(texto);
		componentes.add(salir);
		componentes.add(img1);
	//	componentes.add(img2);
    	componentes.add(comenzar);
	 
		componentes.setLayout(null);  //esto se refiere para que uno ubico por su cuenta los  componentes
		setContentPane(componentes); // se agregan todo el contenido de los  componentes que estaran ubicados dentro del panel
        
   }
	
	
	
//------------------------------------------------------------------------------------------------------------------------------
            /* CREACION DE UN JPanel QUE TENDRA EL FONDO DE LA VENTANA DE INICIO*/


      public class Fondo_Inicio extends JPanel {

         private static final long serialVersionUID = 1L;



       @Override
       public void paintComponent(Graphics img)	{ // se hace un metodo no retornable donde se le asigna que es tipo graphics y tiene como nombre img



       Image fondo = new ImageIcon("Resources/Fondo_Inicio.gif").getImage(); //se crea un objeto de fondo tipo imagen para el llamado del gif


  img.drawImage(fondo, 0, 0, getWidth(),getHeight(), this/* el this es obligatorio para este caso ya que indicamos que es esta clase para que se ver la animacion del gif */ ); 


// el drawaImage es de la parte Graphics que se llama con img que fue el nombre asigando para esta, donde ayudara para asignarle las dimensiones 


          setOpaque(false); // para que sea tranparente y se pueda vizualisar la imagen

         super.paintComponent(img); // pintara con los parametros que le dimos

     }   
 
 
       
       
  }
      
//------------------------------------------------------------------------------------------------------------------------------
      /* CREACION DE METODOS QUE AYUDARAN A LLAMARLO AL CONTROLADOR PARA IMPLEMENTARLE EVENTOS A CADA UNO*/


public String digitar() {
	 
	return JOptionPane.showInputDialog(null,"Ingrese un numero decimal","",JOptionPane.QUESTION_MESSAGE);
    
}


public void cerrar() {
	JOptionPane.showMessageDialog(null, "Nos vemos en otra ocasión, ¡Adios! :D ","Despedida", JOptionPane.PLAIN_MESSAGE);   
	System.exit(0); // con esto se cerrara el programa al entrar a este methodo no retornable
}


public JButton getSalir() {
	
  return salir;
}


public void setSalir(JButton salir) {
  this.salir = salir;
}      


public JButton getComenzar() {
	  return comenzar;
}

public void setComenzar(JButton comenzar) {
  this.comenzar = comenzar;
}      

      
}
