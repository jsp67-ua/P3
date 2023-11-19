package es.ua.dlsi.prog3.p3.highlevel;

import es.ua.dlsi.prog3.p3.lowlevel.OutputDevice;
import java.nio.BufferUnderflowException;
import es.ua.dlsi.prog3.p3.highlevel.exceptions.*;
import es.ua.dlsi.prog3.p3.lowlevel.Channel;

/**
 * Clase Display
 * extends OutputDevice
 * disopositivo de salida que representa una pantalla
 * Consejo testear solo una pantalla usar xeyes & si no pilla raton
 * @author Javier Sala Pérez
 * @version 01/11/2023
 */
public class Display extends OutputDevice {
    private int pixel_rows;
    private byte[][] display;

    /**
     * Constructor de la clase Display
     * @param dis tamaño de la pantalla
     */
    /*public Display(int dis) {
        super(dis * dis * 2);
        pixel_rows = dis;
        display = new byte[pixel_rows][pixel_rows];
        for (int i = 0; i < pixel_rows; i++) {
            for (int j = 0; j < pixel_rows; j++) {
                display[i][j] = 0;
            }
        }
    }

    /**
     * Metodo que devuelve el tamaño de la pantalla
     * @return tamaño de la pantalla
     */
    /*public int getDisplaySize() {
        return pixel_rows;
    }

    /**
     * Metodo que refresca la pantalla, mientas lee los datos imprimibles  los pone en la variable y luego en la pantalla
     * @return pantalla
     * @throws IllegalStateException si no hay canal asociado
     * @throws IndexOutOfBoundsException si las coordenadas de la pantalla son invalidas
     * @throws BufferUnderflowException si no hay suficientes bytes para leer
     */
    /*public byte[][] refresh() {
        Channel channel = getChannel();

        if (channel == null) {
            throw new IllegalStateException();
        }

        while (channel.hasData()) {
            try {
                int x = receiveFromChannel();
                int y = receiveFromChannel();

                if (x < 0 || x >= pixel_rows || y < 0 || y >= pixel_rows) {
                    throw new IndexOutOfBoundsException();
                }

                display[x][y] = 1;
            } catch (BufferUnderflowException e) {
                throw e;
            }
        }

        return display;
    }
    /**
     * Limpia pixeles de la pantalla los pone a 0
     */
    /*public void clear() {
        display = new byte[pixel_rows][pixel_rows];
        for (int i = 0; i < pixel_rows; i++) {
            for (int j = 0; j < pixel_rows; j++) {
                display[i][j] = 0;
            }
        }
    }*/
    public Display(int dis) {
    	super(dis * dis * 2);
    	pixel_rows=dis;
    	display= new byte[pixel_rows][pixel_rows];
    	
    	
    	
    }
    public int getDisplaySize() {
    	return pixel_rows; 	
    	
    }
    public byte[][] refresh() {
    	Channel channel=getChannel();
    	if (channel==null) {
    		throw new IllegalStateException();
    	}
    	while(channel.hasData()) {
    		try {
    			int x =receiveFromChannel();
    			int y = receiveFromChannel();
    			if(0>x || x>=pixel_rows || 0>y || y>=pixel_rows) {
    				throw new IndexOutOfBoundsException();
    			}
    			display[x][y] = 1;
    			
    		}catch(BufferUnderflowException e) {
    			throw new BufferUnderflowException();
    		}
    	}
    	return display;	
    	
    }
    
    public void clear() {
    	display= new byte[pixel_rows][pixel_rows];
    	for (int i=0;i<pixel_rows;i++){
    		for (int j=0;j<pixel_rows;j++){
    			display[i][j]=0;
    		}
    	}
    }
    
    
    
}
