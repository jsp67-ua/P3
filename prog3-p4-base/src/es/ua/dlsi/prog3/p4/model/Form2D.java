package es.ua.dlsi.prog3.p4.model;

import java.text.Normalizer.Form;
import java.util.Objects;

/**
 * Clase abstracta que representa una figura 2D
 * @autor Javier Sala Pérez
 * @version 12.11.2023
 */
public abstract class Form2D {
    /*
    /**
     * Posición de la figura
     */
	/*
    private Coordinate position;

    //# Form2D() - Constrictor
    /**
     * Constructor por defecto
     */
	/*
    protected Form2D() {
        this.position = new Coordinate();
    }

    //# Form2D(Coordinate) - crear con posicion
    /**
     * Constructor con parámetros
     * @param position posición
     */
	/*
    protected Form2D(Coordinate position) {
        this.position = position;
    }

    //# Form2D(Form2D) - Cobstructor de copia
    /**
     * Constructor de copia
     * @param form figura
     */
	/*
    protected Form2D(Form2D form) {
        this.position = new Coordinate(form.position);
    }

    //+ getPosition() : Coordinate - getter posicion
    /**
     * Devuelve la posición (getter)
     * @return position
     */
	/*
    public Coordinate getPosition() {
        return position;
    }
    //+ move(Coordinate) : Coordinate - translada una figura a posicion argumento, devuelve la posicion anterior, si armumento == null devuleve actual
    /**
     * Mueve la figura a una nueva posición, si position == null no mueve y devuelve la posición actual
     * @param position posición
     * @return posAnt 
     */
	/*
    public Coordinate move(Coordinate position) {
        if (position != null) {
            Coordinate posAnt = this.position;
            this.position = position;
            return posAnt;
        }else{
            return this.position;
        }
    }

    @Override
	public int hashCode() {
		return Objects.hash(position);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Form2D other = (Form2D) obj;
		return Objects.equals(position, other.position);
	}

    //+ toString() : String  devuelve una representación en forma de cadena de la figura, con este formato: (<x>,<y>) -> sin los <>
    /**
     * Devuelve un String con su posición
     * @return String
     */
	/*
    public String toString() {
        return "(" + position.getX() + "," + position.getY() + ")";
    }

    //+ <<abstract>> clone() : Form2D  deben implementar las subclases de Form2D y que devuelve una copia de la figura.
    /**
     * Devuelve una copia de la figura
     * @return clon
     */
	/*
    public abstract Form2D clone();


	//+ clone(Coordinate) : Form2D - devuelve copia de figura,  trasladada a la posición especificada por el argumento.
    /**
     * Crean un clon de la figura y la coloca en la posición indicada por parámetro
     * @param pos posición
     * @return clon
     */
	/*
    public Form2D clone(Coordinate pos){
        Form2D clon = this.clone();
        clon.position = pos;
        return clon;
    }
    
    //+ <<abstract>> scale(double) : Form2D 
    /*método abstracto que deben implementar las subclases de Form2D para escalar las dimensiones de una figura. 
    *El porcentaje de escalado se especifica mediante el argumento, 
    *con respecto a las dimensiones actuales de la figura y puede tener cualquier valor positivo mayor que cero. 
    *Por ejemplo, un valor 100 indica mantener inalteradas las dimensiones de la figura. 
    *Un valor 50 indicaría escalar a la mitad las dimensiones y un valor 200 indicaría multiplicar por dos las dimensiones de la figura. 
    *Esta operación no altera la posición de una figura. Lanza la excepción IllegalArgumentException si el porcentaje indicado es negativo o cero.
     */

    /**
     * Escala las dimensiones de la figura
     * @param porcentaje porcentaje
     * @throws IllegalArgumentException si el porcentaje es negativo o cero
     */
	/*
    public abstract void scale(double porcentaje) throws IllegalArgumentException;
    */
	private Coordinate position;
	protected Form2D() {
		this.position= new Coordinate();
	}
	protected Form2D(Coordinate pos) {
		this.position=pos;
	}
	protected Form2D(Form2D form) {
		this.position= new Coordinate(form.position);
	}
	
	public Coordinate getPosition() {
		return position;
	}
	
	public Coordinate move(Coordinate pos) {
		if(pos==null) {
			return position;
		}
		
		Coordinate posAnt= position; 
		position=pos;
		return posAnt;
		
	}
	@Override
	public int hashCode() {
		return Objects.hash(position);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Form2D other = (Form2D) obj;
		return Objects.equals(position, other.position);
	}
	
	public String toString() {
		String cadena;
		cadena= "("+position.getX()+","+position.getY()+")";
		return cadena;
	}
	
    public abstract Form2D clone();
	
	public Form2D clone(Coordinate pos) {
		Form2D clon = clone();
		clon.position=pos;
		return clon;
	}
	
	public abstract void scale (double percent);
	
	
	
	
	
	
	
	

}
