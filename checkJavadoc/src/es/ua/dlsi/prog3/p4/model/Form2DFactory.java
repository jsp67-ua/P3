package es.ua.dlsi.prog3.p4.model;

/**
 * Clase factoría cuya responsabilidad es la de crear figuras de la jerarquía Form2D
 * @autor Javier Sala Pérez
 * @version 12.11.2023
 */
public class Form2DFactory {
	/**
	 * Crea una figura de la jerarquía Form2D
	 * @param tipo tipo de figura
	 * @return Form2D
	 * @throws IllegalArgumentException si el tipo no es correcto
	 */
	public static Form2D createForm2D(String tipo) {
	    
	    if(tipo == "Circle") {
	      return new Circle();

	    } else if(tipo == "rectangle") {
	      return new Rectangle();

	    } else if(tipo == "square") {
	      return new Square();

	    } else {
	      throw new IllegalArgumentException();
	    }

	  }

}
