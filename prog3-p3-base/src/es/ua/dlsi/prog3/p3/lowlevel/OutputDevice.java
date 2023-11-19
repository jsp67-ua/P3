
package es.ua.dlsi.prog3.p3.lowlevel;
import java.nio.BufferUnderflowException;
//import java.nio.channels.Channel;

/**
 * Clase OutputDevice
 * extends IODevice
 * dispositivo de salida
 * @author Javier Sala Pérez
 * @version 01/11/2023
 */
public class OutputDevice extends IODevice {


	/**
	 * DON'T TOUCH THIS METHOD!!! The earth will collapse on itself if you ever think of doing it!
	 * 
	 * Reads a string from the channel. 
	 * 
	 * The channel MUST contain a string of characteres encoded as
	 * 
	 * 
	 * [length][A-Ba-b0-9]+
	 * 
	 * which means that the first byte is the string length, and the rest of bytes are the actual string 
	 * 
	 * 
	 * @return the string read, as an String object, or an empty if there is no data in the channel 
	 * @throws BufferUnderflowException if the channel becomes empty before the whole string is read, i.e. the data in the channel is corrupted
	 * @throws IllegalStateException if there is no channel associated to this device 
	 */
	protected String readStoredString() {
		
		byte[] data = null;
		char[] string = null;
		data = get(1);
		if (data.length != 1) 
			return "";
		int string_length = data[0];		
		data = get(string_length);
		if (data.length != string_length)
			throw new BufferUnderflowException();
		string = new char[string_length];
		for (int i=0; i < string_length; i++)
			string[i] = (char) data[i];
		return String.valueOf(string);
	}
	/**
	 * Constructor de la clase OutputDevice
	 * crea un nuevo dispositivo de salida
	 * @param out tamaño del buffer
	 */
	/*protected OutputDevice(int out) {
		super(out);

	}
	/**
	 * Metodo que devuelve un array de bytes del canal
	 * @param num_bytes numero de bytes a devolver
	 * @return array de bytes del canal
	 * @throws IllegalStateException si no hay canal asociado
	 * @throws IllegalArgumentException si el numero de bytes es negativo o mayor que el tamaño del buffer
	 * @throws BufferUnderflowException si no hay suficientes bytes para leer
	 */
	/*protected byte[] get(int num_bytes) {
		Channel channel = getChannel();
		if(channel==null) {
			 //return new byte[0];
			throw new IllegalStateException();
			//return new byte[0];
						
		}
		if(num_bytes<0 || num_bytes>channel.getBufferSize()) {
			//return new byte[0];
			throw new IllegalArgumentException();
			//return new byte[0];
		}
		byte[] data = new byte[num_bytes];
		for(int i=0; i<num_bytes; i++) {
			try {
				data[i] = channel.output();
			}catch(BufferUnderflowException e) {
				//return new byte[0]; esto pasa el test pero 0 sentido (solo xq el test pide array vacio)

				//Tenemos que devolver solo los leidos, no todo el array
				byte[] read = new byte[i];
				//System.arraycopy(data, 0, data, 0,i); //funciona pero no hay xq cargarse lo no leido
				System.arraycopy(data, 0, read, 0,i);
				return read;
			}	
		}
		return data;
	}
	/**
	 * Metodo que devuelve un byte del canal
	 * @return byte del canal
	 * @throws IllegalStateException si no hay canal asociado
	 * @throws BufferUnderflowException si no hay suficientes bytes para leer
	 */
	/*protected byte receiveFromChannel() {
		Channel channel = getChannel();
		
		if(channel==null) {
			throw new IllegalStateException();
		}
		/* Esto no funciona (no devuleve canal vacio)
		if(!channel.isFull()) {
			throw new BufferUnderflowException();
		}
		return channel.output();*/

		//le como máximo num_bytes del canal asociado
		/*try {
			return channel.output();
		}catch(BufferUnderflowException e) {
			throw new BufferUnderflowException();
		}
		
	}*/
	
	protected OutputDevice(int salida) {
		super(salida);
	}
	
	
	protected byte[] get(int b) {
		Channel channel = getChannel();
		byte[] data = new byte[b];
		
		if(channel==null) {
			throw new IllegalStateException();
		}
		
		if(b<0 || b>channel.getBufferSize()) {
			throw new IllegalArgumentException();
		}
		for(int i=0;i<b;i++) {
			try {
				data[i]=channel.output();
			}catch(BufferUnderflowException e) {
				byte[] leido =new byte[i];
				System.arraycopy(data, 0, leido, 0, i);
				//throw new BufferUnderflowException();	
				return leido;
			}
			
		}
		return data;
	}
	
	
	protected byte receiveFromChannel(){
		Channel channel = getChannel();
		
		if(channel==null) {
			throw new IllegalStateException();
		}
		
		try {
			return channel.output();
		}catch(BufferUnderflowException e) {
			throw new BufferUnderflowException();			
		}
	
	}
	

}
