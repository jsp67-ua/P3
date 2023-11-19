package es.ua.dlsi.prog3.p4.model;

import java.util.Objects;

/**
 * Clase abstracta que representa un polígono viene extendida de Form2D
 * @author Javier Sala Pérez
 * @version 12.11.2023
 * 
 */
public abstract class AbstractPolygon extends Form2D{
	//- angle : double
	/**
	 * Ángulo rango 0.0-360.0
	 */
	private double angle; //rango 0.0-360.0
	
	//# AbstractPolygon()
	/**
	 * Constructor por defecto, ángulo 0.0
	 */
	protected AbstractPolygon() {
		super();
		this.angle=0.0;
	}
	//# AbstractPolygon(Coordinate, double)
	/**
	 * Constructor con parámetros
	 * @param cord coordenada
	 * @param ang ángulo
	 * @throws IllegalArgumentException si el ángulo no está en el rango 0.0-360.0
	 * 
	 */
	protected AbstractPolygon(Coordinate cord, double ang) {
		super(cord);
		if (ang<0.0 || ang>360.0) {
			throw new IllegalArgumentException();
		}
		this.angle=ang;
	}
	//# AbstractPolygon(AbstractPolygon)
	/**
	 * Constructor de copia
	 * @param absPol polígono
	 */
	protected AbstractPolygon(AbstractPolygon absPol) {
		super(absPol);
		this.angle=absPol.angle;
	}
	//+ getAngle() : double
	/**
	 * Devuelve el ángulo (getter)
	 * @return angle
	 */
	public double getAngle() {
		return angle;
	}
	//+ toString() : String
	/**
	 * Devuelve un String con su posición y ángulo
	 * @return String
	 */
	public String toString() {
		return super.toString() + ",angle=" + angle;
	}
	//+ equals(Object) : boolean
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(angle);
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
		AbstractPolygon other = (AbstractPolygon) obj;
		return Double.doubleToLongBits(angle) == Double.doubleToLongBits(other.angle);
	}
	
	//+ rotate(double) : void
	/**
	 * Rota el polígono
	 * @param grad ángulo
	 * @throws IllegalArgumentException si el ángulo pasasdo por parámetro no está en el rango -360.0 y 360.0
	 */
	public void rotate(double grad) {
		
		if(grad>=360.0 || grad<=-360.0) {
			throw new IllegalArgumentException();
		}
		//esto da fallo no entiendo xq si rota bien
		angle=angle+grad;
		if(angle>360.0) {
			angle=angle-360.0;
		}else if(angle<0.0) {
			angle = angle+360.0;
		}
		
				
	}
}
