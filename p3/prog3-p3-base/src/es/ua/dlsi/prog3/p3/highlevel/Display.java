package es.ua.dlsi.prog3.p3.highlevel;

import es.ua.dlsi.prog3.p3.lowlevel.OutputDevice;
import java.nio.BufferUnderflowException;
import es.ua.dlsi.prog3.p3.highlevel.exceptions.*;
import es.ua.dlsi.prog3.p3.lowlevel.Channel;

public class Display extends OutputDevice {
    private int pixel_rows;
    private byte[][] display;

    public Display(int dis) {
        super(dis * dis * 2);
        pixel_rows = dis;
        display = new byte[pixel_rows][pixel_rows];
    }

    public int getDisplaySize() {
        return pixel_rows;
    }

    public byte[][] refresh() {
        Channel channel = getChannel();

        if (channel == null) {
            throw new IllegalStateException("No channel associated with Display");
        }

        while (channel.hasData()) {
            try {
                int x = receiveFromChannel();
                int y = receiveFromChannel();

                if (x < 0 || x >= pixel_rows || y < 0 || y >= pixel_rows) {
                    throw new IndexOutOfBoundsException("Invalid pixel coordinates");
                }

                display[x][y] = 1;
            } catch (BufferUnderflowException e) {
                // Handle if there are not enough bytes to read
                break;
            }
        }

        return display;
    }

    public void clear() {
        display = new byte[pixel_rows][pixel_rows];
    }
}
