package es.ua.dlsi.prog3.p3.highlevel;
import es.ua.dlsi.prog3.p3.lowlevel.OutputDevice;
import java.nio.BufferUnderflowException;
import es.ua.dlsi.prog3.p3.highlevel.exceptions.*;
import es.ua.dlsi.prog3.p3.lowlevel.Channel;

public class LinePrinter extends OutputDevice {
	private static final int MAX_LINE_LENGTH = 80;

	public LinePrinter() {
		super(LinePrinter.MAX_LINE_LENGTH + 1);
	}

	public String printLine() throws NoLineForPrintingException {

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
	}
}
