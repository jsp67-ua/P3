package es.ua.dlsi.prog3.p4.model;

import java.util.Objects;

/**
 * Clase que representa un cuadrado, viene extendida de AbstractPolygon
 * @extends AbstractPolygon
 * @autor Javier Sala Pérez
 * @version 12.11.2023
 */
public class Square extends AbstractPolygon{
	
	//- side : double
	/**
	 * Atributo de la clase
	 * side : double
	 */
	private double side;
	
	//+ Square()
	/**
	 * Constructor por defecto, side es 0.0
	 */
	public Square() {
		super();
		this.side=0.0;
	}

	//+ Square(Square)
	/**
	 * Constructor de copia
	 * @param squ cuadrado
	 */
	public Square(Square squ) {
		super(squ);
		this.side=squ.side;
	}
	//+ Square(Coordinate, double, double)
	/**
	 * Constructor con parámetros
	 * @param cord coordenada
	 * @param ang ángulo
	 * @param lado lado
	 * @throws IllegalArgumentException si lado es negativo
	 */
	public Square(Coordinate cord, double ang, double lado) {
		super(cord,ang);
		if(lado<0) {
			throw new IllegalArgumentException();
		}
		this.side=lado;
	}
	
	//+ getSide() : double
	/**
	 * Devuelve el lado (getter)
	 * @return side
	 */
	public double getSide() {
		return side;
	}
	//+ scale(double) : void
	/**
	 * Escala el lado del cuadrado
	 * @param cuadrado
	 * side = side * (cuadrado/100)
	 */
	public void scale(double cuadrado) {
		this.side=this.side*(cuadrado/100);
	}
	//+ clone() : Square
	/**
	 * Devuelve una copia del cuadrado
	 * @return sclon
	 */
	public Square clone() {
		Square sclon= new Square(this);
        return sclon; 
	}
	//+ toString() : String
	/**
	 * Devuelve un String con su posición y lado
	 * @return String
	 */
	public String toString() {
		return super.toString() + ",side="+ side;
	}
	//+ equals(Object) : boolean
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(side);
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
		Square other = (Square) obj;
		return Double.doubleToLongBits(side) == Double.doubleToLongBits(other.side);
	}
	
}
