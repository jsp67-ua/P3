package es.ua.dlsi.prog3.p3.highlevel;
import java.nio.BufferOverflowException; 
import es.ua.dlsi.prog3.p3.lowlevel.InputDevice;

public class Mouse extends InputDevice{
	
	public Mouse() {
		super();
	}
	
	
	public void put(byte x, byte y) {
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
	}
}
