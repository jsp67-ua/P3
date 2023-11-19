package es.ua.dlsi.prog3.p3.highlevel;
import es.ua.dlsi.prog3.p3.lowlevel.OutputDevice;
import java.nio.BufferUnderflowException;
import es.ua.dlsi.prog3.p3.highlevel.exceptions.*;
import es.ua.dlsi.prog3.p3.lowlevel.Channel;

/**
 * Clase LinePrinter
 * extends OutputDevice
 * dispositivo de salida que representa una impresora de lineas
 * @author Javier Sala Pérez
 * @version 01/11/2023
 */
public class LinePrinter extends OutputDevice {
	private static final int MAX_LINE_LENGTH = 80;

	/**
	 * Constructor de la clase LinePrinter
	 * crea una nueva impresora de lineas
	 * el tamaño del buffer es MAX_LINE_LENGTH + 1
	 */
	/*public LinePrinter() {
		super(LinePrinter.MAX_LINE_LENGTH + 1);
	}

	/**
	 * Metodo que imprime una linea
	 * @return linea a imprimir
	 * @throws NoLineForPrintingException si no hay lineas para imprimir
	 * @throws IllegalStateException si no hay canal asociado
	 * @throws BufferUnderflowException si se vacia el buffer
	 */
	/*public String printLine() throws NoLineForPrintingException {

		Channel channel = getChannel();
		if (channel == null) {
			throw new IllegalStateException();
		}
		// if (channel.getBufferSize() == 0) {
		// throw new NoLineForPrintingException();
		//HasData son todo lo del buffer qie se puede leer, get puede dar cosas q no se leen
		if (channel.hasData() == false) {
			throw new NoLineForPrintingException();
		}
		try {
			String line = readStoredString();
			//if (channel.hasData() == false) {
			//	throw new NoLineForPrintingException();
			//}
			return line;
		} catch (BufferUnderflowException e) {
			throw new NoLineForPrintingException();
		}
	}*/
	public LinePrinter() {
		super(MAX_LINE_LENGTH+1);
	}
	public String printLine() throws NoLineForPrintingException {
		Channel channel=getChannel();
		if(channel==null) {
			throw new IllegalStateException();
		}
		
		if(channel.hasData()==false) {
			throw new NoLineForPrintingException();
		}
		
		try {
			String cadena = readStoredString();
			return cadena;
		}catch(BufferUnderflowException e) {
			throw new BufferUnderflowException();
		}
		
		
	}
}
