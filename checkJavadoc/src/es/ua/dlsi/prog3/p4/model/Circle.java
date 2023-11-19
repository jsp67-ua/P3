package es.ua.dlsi.prog3.p4.model;

import java.util.Objects;

/**
 * Clase que representa un círculo, viene extendida de Form2D
 * @autor Javier Sala Pérez
 * @version 12.11.2023
 */
public class Circle extends Form2D {
    /**
     * Radio del círculo
     */
    private double radius;

    //+ Circle() - crea un círculo de radio cero y sin centro definido
    /**
     * Constructor por defecto, radio 0
     */
    public Circle() {
        super();
        this.radius = 0;
    }
    //+ Circle(Coordinate, double) - crea un círculo con el centro y radio dados como argumentos. 
    //Lanza IllegalArgumentException si el radio indicado es negativo
    /**
     * Constructor con parámetros
     * @param pos posición
     * @param rad radio
     * @throws IllegalArgumentException si el radio es negativo
     */
    public Circle(Coordinate pos, double rad) {
        super(pos);
        if(rad<0) {
        	throw new IllegalArgumentException();
        }
        this.radius = rad;
    }
    //+ Circle(Circle) - constructor de copia
    /**
     * Constructor de copia
     * @param circle círculo
     */
    public Circle(Circle circle) {
        super(circle);
        this.radius = circle.radius;
    }
    //+ getRadius() : double -getter radio
    /**
     * Devuelve el radio (getter)
     * @return radius
     */
    public double getRadius() {
        return radius;
    }
    //+ scale(double) : void - decuelve cadena (<x>,<y>),radius=<r>
    /**
     * Escala el radio del círculo radio = radio * (porcentaje/100)
     * @param porcentaje porcentaje
     */
    public void scale(double porcentaje) {
    	radius = radius * (porcentaje/100);
    }
    //+ clone() : Circle - return copia
    /**
     * Devuelve una copia del círculo
     * @return cClon
     */
    public Circle clone() {
    	Circle cClon= new Circle(this);
        return cClon;        
    }
    /**
     * Devuelve un String con su posición y radio
     * @return String
     */
    public String toString() {
    	return super.toString() + ",radius=" + radius;
    }
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(radius);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Circle other = (Circle) obj;
		return Double.doubleToLongBits(radius) == Double.doubleToLongBits(other.radius);
	}
    
    
    
    

}
