package es.ua.dlsi.prog3.p3.highlevel;
import java.nio.BufferOverflowException;
import es.ua.dlsi.prog3.p3.lowlevel.InputDevice;
import es.ua.dlsi.prog3.p3.lowlevel.Channel;


public class Keyboard extends InputDevice{
	
	public Keyboard() {
		//create a new keyboard
		super();
	}
	
	public void put(char c) {
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
		
	}
}
