package es.ua.dlsi.prog3.p3.highlevel;
import java.nio.BufferOverflowException;

import es.ua.dlsi.prog3.p3.lowlevel.Channel;
import es.ua.dlsi.prog3.p3.lowlevel.InputDevice;

/** 
 * Clase Mouse dispositivo de entrada que representa un raton
 * extends InputDevice
 * @author Javier Sala Pérez
 * @version 01/11/2023
 */
public class Mouse extends InputDevice{
	
	/**
	 * Constructor de la clase Mouse
	 */
	/*public Mouse() {
		super();
	}
	
	/**
	 * Metodo que pone 2 bytes en el canal con sendToChannel
	 * @param x coordenada x
	 * @param y coordenada y
	 * @throws IllegalStateException si no hay canal asociado
	 * @throws BufferOverflowException si el canal ya está lleno
	 */
	/*public void put(byte x, byte y) {
		//Channel channel = getChannel();
		if (getChannel() == null) {
			throw new IllegalStateException();
		}
		try {
			sendToChannel((byte) x);
			sendToChannel((byte) y);
		} catch (BufferOverflowException e) {
			throw new BufferOverflowException();
		}
	}*/
	
	public Mouse() {
		super();		
	}
	
	public void put(byte x, byte y) {
		Channel channel=getChannel();
		if(channel==null) {
			throw new IllegalStateException();
		}
		
		try {
			sendToChannel(x);
			sendToChannel(y);
		}catch(BufferOverflowException e) {
			throw new BufferOverflowException();
		}
		
	}
	
	
	
	
}
