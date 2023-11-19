package es.ua.dlsi.prog3.p4.model;

import java.util.List;
import java.util.ArrayList;

/**
 * Clase que representa un lienzo, contiene una lista de formas que viene dada por Form2D
 * @autor Javier Sala Pérez
 * @version 12.11.2023
 */
public class Canvas {
	/**
	 * Tamano por defecto
	 */
	  public static final float DEFAULT_SIZE = 1000;
	  
	  /**
	   * Atributos de la clase
	   * title : String
	   * width : double
	   * height : double
	   */
	  private String title;
	  private double width;
	  private double height;
	  
	  /**
	   * Lista de formas
	   */
	  private List<Form2D> forms;

	  /**
	   * Constructor por defecto
	   * titles = "default canvas"
	   * widths = DEFAULT_SIZE
	   * heights = DEFAULT_SIZE
	   */
	  public Canvas() {
	    this("default canvas", DEFAULT_SIZE, DEFAULT_SIZE);
	  }

	  /**
	   * constructor con parámetros
	   * @param titles título
	   * @param widths ancho
	   * @param heights alto
	   * @throws IllegalArgumentException si widths o heights son negativos
	   */
	  public Canvas(String titles, double widths, double heights) {
	    if(widths < 0 || heights < 0) {
	      throw new IllegalArgumentException();
	    }
	    
	    this.title = titles;
	    this.width = widths;
	    this.height = heights;
	    this.forms = new ArrayList<>();

	  }
	  /**
	   * Constructor de copia
	   * @param lienzo lienzo
	   */
	  public Canvas(Canvas lienzo) {
	    // inicializar atributos copiando de other
		this.title = lienzo.title;
		this.width = lienzo.width;
		this.height = lienzo.height;
		this.forms = new ArrayList<>();
		for (Form2D form : lienzo.forms) {
			this.forms.add(form);
		}
	  }

	  // getters y setters
	  
	  /**
	   * Devuelve el título
	   * @return new Canvas(this)
	   */
	  public Canvas clone() {
	        return new Canvas(this);
	    }
	  /**
	   * Devuelve Width
	   * @return width
	   */
	  public double getWidth() {
	        return width;
	  }
	  /**
	   * Devuelve Height
	   * @return height
	   */
	  public double getHeight() {
	        return height;
	  }

	  /**
	   *Añade una forma a la lista 
	   * @param form forma
	   */
	  public void addForm(Form2D form) {
	    forms.add(form);
	  }

	  /**
	   * Devuelve la posición en la lista
	   * @param index posición
	   * @return forms.get(index - 1)
	   * @throws IndexOutOfBoundsException si index es menor que 1 o mayor que el tamaño de la lista
	   */
	  public Form2D getForm(int index) {
	    if (index < 1 || index > forms.size()) {
            throw new IndexOutOfBoundsException("");
        }
        return forms.get(index - 1); 
	  }

	  /**
	   * Devuelve el número de formas
	   * @return forms.size()
	   */
	  public int getNumForms() {
	    return forms.size();
	  }

	  /**
	   * Elimina una forma de la lista
	   * @param index indice
	   * @throws IndexOutOfBoundsException si index es menor que 1 o mayor que el tamaño de la lista
	   */
	  public void removeForm(int index) {
	    if (index < 1 || index > forms.size()) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        forms.remove(index - 1);
	  }

	  @Override
	  public String toString() {
		//System.out.println(title+" ("+width+"x"+height+")" + " with "+ forms.size() + " forms");
	    return title+" ("+width+","+height+")" + " with "+ forms.size() + " forms";
	  }
	   
	}
