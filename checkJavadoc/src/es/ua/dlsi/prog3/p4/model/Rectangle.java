package es.ua.dlsi.prog3.p4.model;

import java.util.Objects;

/**
 * Clase que representa un rectángulo, viene extendida de AbstractPolygon
 * @extends AbstractPolygon
 * @autor Javier Sala Pérez
 * @version 12.11.2023
 */

public class Rectangle extends AbstractPolygon{
	
	/**
	 * Atributos de la clase
	 * length : double
	 * width : double
	 */
	//- length : double
	private double length;
	//- width : double
	private double width;
	//+ Rectangle()

	/**
	 * Constructor por defecto, length y width son 0.0
	 */
	public Rectangle() {
		super();
		this.length= 0.0;
		this.width = 0.0;
		
	}
	//+ Rectangle(Rectangle)
	/**
	 * Constructor de copia
	 * @param rec rectángulo
	 */
	public Rectangle(Rectangle rec) {
		super(rec);
		this.length= rec.length;
		this.width = rec.width;
		
	}
	//+ Rectangle(Coordinate, double, double, double)
	/**
	 * Constructor con parámetros
	 * @param cord coordenada
	 * @param ang ángulo
	 * @param base base
	 * @param alt altura
	 * @throws IllegalArgumentException si base o alt son negativos
	 */
	public Rectangle(Coordinate cord , double ang , double base, double alt) {
		super(cord,ang);
		if(base<0.0 || alt<0.0){
				throw new IllegalArgumentException();
		}
		this.length=base;
		this.width=alt;
	}
	
	//+ getLength() : double
	/**
	 * getter length 
	 * @return length
	 */
	public double getLength() {
		return length;
	}
	//+ getWidth() : double
	/**
	 * getter width
	 * @return width
	 */
	public double getWidth() {
		return width;
	}
	//+ scale(double) : void
	@Override
	public void scale(double porcentaje) throws IllegalArgumentException {
		this.length= this.length*(porcentaje/100);
		this.width=this.width*(porcentaje/100);
	}
	//+ clone() : Rectangle
	/**
	 * Devuelve una copia del rectángulo	
	 * @return rclon
	 */
	public Rectangle clone() {
		Rectangle rclon= new Rectangle(this);
        return rclon;  
	}
	//+ toString() : String
	/**
	 * Devuelve un String con su posición, ángulo, length y width
	 * @return String
	 */
	public String toString() {
		return super.toString() + ",length="+ length + ",width="+ width;
	}
	//+ equals(Object) : boolean
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(length, width);
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
		Rectangle other = (Rectangle) obj;
		return Double.doubleToLongBits(length) == Double.doubleToLongBits(other.length)
				&& Double.doubleToLongBits(width) == Double.doubleToLongBits(other.width);
	}
	
	
	
	
	

	

}
