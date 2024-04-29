package Model;

public class Opcion {
    
	    private char caracter, digito;
	    private int mes;
	    private String texto;

	    public Opcion(char caracter, String texto) {
	        this.caracter = Character.toUpperCase(caracter); // Almacena la letra en mayúsculas
	        this.texto = texto;
	        this.digito = Character.toUpperCase(caracter); 
	    }
	    
	    
	    
	    public Opcion(int mes, String texto) {
	        this.mes = mes;
	        this.texto = texto;
	    }


	    public char getLetra() {
	        return caracter;
	    }
	    
	    public int getMes() {
	    	return mes;
	    }
	    
	    public char getDigito() {
	    	return digito;
	    }

	    public String getTexto() {
	        return texto;
	    }
}
