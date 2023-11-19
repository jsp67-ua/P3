package es.ua.dlsi.prog3.p3.lowlevel;

import java.nio.BufferOverflowException;

public class InputDevice extends IODevice{
	
	protected InputDevice() {
		super();
	}
	
	protected void put(byte[] b) {
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
	
	protected void sendToChannel(byte b) {
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
		
	}

}
