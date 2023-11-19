package es.ua.dlsi.prog3.p3.lowlevel;

import java.nio.BufferOverflowException;

/**
 * Clase InputDevice
 * extends IODevice
 * clase encargada de los dispositivo de entrada
 * @author Javier Sala Pérez
 * @version 01/11/2023
 */
public class InputDevice extends IODevice{
	
	/**
	 * Constructor de la clase InputDevice
	 * crea un nuevo dispositivo de entrada
	 */
	/*protected InputDevice() {
		super();
	}
	
	/**
	 * Metodo que pone un array de bytes en el canal
	 * @param b array de bytes a poner en el canal
	 * @throws IllegalStateException si no hay canal asociado
	 * @throws BufferOverflowException si el canal ya está lleno
	 */
	/*protected void put(byte[] b) {
		Channel channel = getChannel();
		if(channel==null) {
			throw new IllegalStateException();
		}
		//Paso byte a byte (bucle for tamaño etc...)
		for(int i=0; i<b.length;i++) {
		//Canal lleno o se estallenando y se llena
		try {
		channel.input(b[i]);
		}catch (BufferOverflowException ex)
		{
			throw new BufferOverflowException();
		}
		}	
		
		//channel.input(b);
	}
	/**
	 * Metodo que pone un byte en el canal
	 * @param b byte a poner en el canal
	 * @throws IllegalStateException si no hay canal asociado
	 * @throws BufferOverflowException si el canal ya está lleno
	 */
	/*protected void sendToChannel(byte b) {
		Channel channel = getChannel();
		//No hay canal
		if(channel==null) {
			throw new IllegalStateException();
		}
		//Igual pero sin el bucle for (1 solo byte)
		//Canal lleno o se estallenando y se llena
		try {
		channel.input(b);
		}catch (BufferOverflowException ex)
		{
			throw new BufferOverflowException();
		}
		
	}*/
	protected InputDevice() {
		super();
	}
	
	
	protected void sendToChannel(byte b) {
		Channel channel=getChannel();
		
		if (channel==null)
			throw new IllegalStateException(); 
		
		try {
			channel.input(b);
		}catch(BufferOverflowException e){
			throw new BufferOverflowException();
		}
	}
	
	
	protected void put(byte[] b) {
		Channel channel=getChannel();
		
		if (channel==null)
			throw new IllegalStateException(); 
		
		try {
			for(int i=0;i<b.length;i++)
			channel.input(b[i]);
		}catch(BufferOverflowException e){
			throw new BufferOverflowException();
		}
	
	}
}
