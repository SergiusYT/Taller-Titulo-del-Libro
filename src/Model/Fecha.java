package Model;

import java.util.ArrayList;

public class Fecha {

	 private int dia, mes, año;
	 private ArrayList<Opcion> opciones;
	 
	 public Fecha(int dia, int mes, int año) {
		 this.dia = dia;
		 this.mes = mes;
		 this.año = año;
		 
		 
		 opciones = new ArrayList<>();
         opciones.add(new Opcion(1, " hazaña"));
         opciones.add(new Opcion(2, " reencarnacion"));
         opciones.add(new Opcion(3, " batalla"));
         opciones.add(new Opcion(4, " existencia"));
         opciones.add(new Opcion(5, " muerte"));
         opciones.add(new Opcion(6, " mision"));
         opciones.add(new Opcion(7, " venganza"));
         opciones.add(new Opcion(8, " anecdota"));
         opciones.add(new Opcion(9, " vida"));
         opciones.add(new Opcion(10, " leyenda"));
         opciones.add(new Opcion(11, " historia"));
         opciones.add(new Opcion(12, " biografia"));

		 
	 }
	 
	 public ArrayList<Opcion> obtenerOpcionesPorMes(int mes) {
	        ArrayList<Opcion> opcionesPorMes = new ArrayList<>();
	        for (Opcion opcion : opciones) { // recorro todos los elementos de opciones donde toma los valores la variable opcion 
	            if (opcion.getMes() == mes) {
	                opcionesPorMes.add(opcion);
	            }
	        }
	        return opcionesPorMes;
	    }
 
	 public int getDia() {
		 return dia;
	 }
	 
	 
	 public int getMes() {
		 return mes;
	 }
	 
	 
	 public int getAño() {
		 return año;
	 }
}
