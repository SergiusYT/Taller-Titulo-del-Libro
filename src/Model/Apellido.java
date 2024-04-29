package Model;

import java.util.*;

public class Apellido {

	private ArrayList<Opcion> opciones;

    public Apellido() {
        opciones = new ArrayList<>();
        opciones.add(new Opcion('A', "La verdadera"));
        opciones.add(new Opcion('B', "La exitante"));
        opciones.add(new Opcion('C', "La horripilante"));
        opciones.add(new Opcion('D', "La alegre"));
        opciones.add(new Opcion('E', "La fatal"));
        opciones.add(new Opcion('F', "La apasioante"));
        opciones.add(new Opcion('G', "La tragica"));
        opciones.add(new Opcion('H', "La sangrienta"));
        opciones.add(new Opcion('I', "La famosa"));
        opciones.add(new Opcion('J', "La gran"));
        opciones.add(new Opcion('K', "La penosa"));
        opciones.add(new Opcion('J', "La triste"));
        opciones.add(new Opcion('L', "La desastrosa"));
        opciones.add(new Opcion('M', "La hermosa"));
        opciones.add(new Opcion('O', "La oscura"));
        opciones.add(new Opcion('P', "La gloriosa"));
        opciones.add(new Opcion('Q', "La infeliz"));
        opciones.add(new Opcion('R', "La emocionante"));
        opciones.add(new Opcion('S', "La fanatastica"));
        opciones.add(new Opcion('T', "La terrorifica"));
        opciones.add(new Opcion('U', "La aburrida"));
        opciones.add(new Opcion('V', "La increible"));
        opciones.add(new Opcion('W', "La desgraciada"));
        opciones.add(new Opcion('X', "La lamentable"));
        opciones.add(new Opcion('Y', "La comica"));
        opciones.add(new Opcion('Z', "La miserable"));




    }

    public String obtenerTextoPorCaracter(char caracter) {
        char letraMayuscula = Character.toUpperCase(caracter); // Convierte la letra ingresada a mayúscula
        for (Opcion opcion : opciones) {
            if (opcion.getLetra() == letraMayuscula) {
                return opcion.getTexto();
            }
        }
        return "";
    }
	
	
	public char obtenerPrimeraletra(String entrada) {
	        
		if(!entrada.isEmpty()) { //como esto negando indico que la condicion se cumplira si el parametro del metodo no esta vacio 
		   
			return entrada.charAt(0); //se devuelve el caracter de dicho string en la posicion 0 
			
		}else {
		  
			return '\0'; //valor nulo o vacio 
		}
		
         
	}  
	
	
    }

