package Model;

import java.util.ArrayList;

public class Celular {

	private ArrayList<Opcion> opciones;

    public Celular() {
        opciones = new ArrayList<>();
        opciones.add(new Opcion('0', " de un bipolar"));
        opciones.add(new Opcion('1', " de un asesino/a"));
        opciones.add(new Opcion('2', " de un loco/a"));
        opciones.add(new Opcion('3', " de un adictoo/a a los memes"));
        opciones.add(new Opcion('4', " de un soñador/a"));
        opciones.add(new Opcion('5', " de un genio/a"));
        opciones.add(new Opcion('6', " de un simbolo sexual"));
        opciones.add(new Opcion('7', " de un alcoholico/a"));
        opciones.add(new Opcion('8', " de un guerrero/a"));
        opciones.add(new Opcion('9', " de un aventurero/a"));
        
	
    }
    
    
    public String obtenerTextoPorDigito(char digito) {
        char ultimo_digito = Character.toUpperCase(digito);;
        for (Opcion opcion : opciones) {
            if (opcion.getDigito() == ultimo_digito) {
                System.out.println(opcion.getDigito());
            	return opcion.getTexto();
            }
        }
        return "";
    }
    
    
    
    
	public char obtenerUltimoDigito(String entrada) {
	        
		if(!entrada.isEmpty()) { //como esto negando indico que la condicion se cumplira si el parametro del metodo no esta vacio 
		   
			return entrada.charAt(9); //se devuelve el caracter de dicho string en la posicion 9 
			
		}else {
		  
			return '\0'; //valor nulo o vacio 
		}
		
         
	}  
	
	
    }

