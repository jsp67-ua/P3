package es.ua.dlsi.prog3.p3.highlevel;
import java.nio.BufferOverflowException;
import es.ua.dlsi.prog3.p3.lowlevel.InputDevice;
import es.ua.dlsi.prog3.p3.lowlevel.Channel;

/**
 * Clase Keyboard
 * extends InputDevice
 * dispositivo de entrada que representa un teclado
 * @author Javier Sala Pérez
 * @version 01/11/2023
 */
public class Keyboard extends InputDevice{
	/**
	 * Constructor de la clase Keyboard
	 * crea un nuevo teclado
	 */
	/*public Keyboard() {
		//create a new keyboard
		super();
	}
	/**
	 * Pone un char pasado por parametro en el canal asociado
	 * @param c char a poner en el canal asociado
	 * @throws IllegalStateException si no hay canal asociado
	 * @throws BufferOverflowException si el canal ya está lleno
	 */
	/*public void put(char c) {
		//envía un caracter al canal asociado. Lanza las excepciones estándar 
		//IllegalStateException si el dispositivo no tiene canal asociado y 
		//BufferOverflowException si el canal ya está lleno.
		Channel channel = getChannel();
		if (channel == null) {
			throw new IllegalStateException();
		}
		try {
			sendToChannel((byte) c);
		} catch (BufferOverflowException e) {
			throw new BufferOverflowException();
		}
		
	}*/
	
	public Keyboard() {
		super();
	}
	
	public void put(char c) {
		Channel channel=getChannel();
		if(channel==null) {
			throw new IllegalStateException();
		}
		
		try {
			sendToChannel((byte)c);
		}catch(BufferOverflowException e) {
			throw new BufferOverflowException();
		}
	}
	
}
