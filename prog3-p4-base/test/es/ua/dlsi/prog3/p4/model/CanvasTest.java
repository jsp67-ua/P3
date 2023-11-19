package es.ua.dlsi.prog3.p4.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import es.ua.dlsi.prog3.p4.util.Util;

public class CanvasTest {

	class NewForm2D extends Form2D {
		NewForm2D() {
		}

		NewForm2D(Coordinate pos) {
			super(pos);
		}
		
		NewForm2D(NewForm2D other) { 
			super(other);
		}
		
		@Override
		public void scale(double porcentaje)  {
		}
		
		@Override
		public NewForm2D clone() {
			return new NewForm2D(this);
		}
	}

	Canvas lienzo;
	
	@Before
	public void setUp() throws Exception {
		lienzo = new Canvas();
		lienzo.addForm(new NewForm2D());
		lienzo.addForm(new NewForm2D());
	}

	@Test
	public final void testDefaultCtor()  {
		Canvas l = new Canvas();
		//System.out.println(l.getHeight());
		assertEquals("Alto por defecto", Canvas.DEFAULT_SIZE, l.getHeight(), 0.001);
		assertEquals("Ancho por defecto", Canvas.DEFAULT_SIZE, l.getWidth(), 0.001);
		assertEquals("No figures in new Canvas",0,l.getNumForms());
	}

	@Test
	public final void testCanvasStringFloatFloat()  {
		
		Canvas l = new Canvas("Prueba", 10, 20);
		assertEquals("Height 20", 20, l.getHeight(), 0.001);
		assertEquals("Width 10", 10, l.getWidth(), 0.001);
		assertEquals("No figures in new Canvas",0,l.getNumForms());
	}	
	
	@Test(expected=IllegalArgumentException.class)
	public final void testBadCanvas() {
		new Canvas("Bad Canvas dimensions", -10, -20);
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public final void testLienzoGetMalCero() {
		lienzo.getForm(0);
	}

	@Test
	public final void testLienzoGetFormOK() throws Exception {
		Form2D c = new NewForm2D();
		assertEquals(c, lienzo.getForm(2));
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public final void testLienzoRemoveMalCero() {
		lienzo.removeForm(0);
	}

	@Test
	public  final void testCloneIsDefined() {
		lienzo.clone();
	}

	@Test
	public final void testGetNumFormsIsDefined() {
		lienzo.getNumForms();
	}

	@Test
	public  final void testToString() {
		String s = "default canvas (1000.0,1000.0) with 2 forms";
		assertEquals("Canvas.toString()",s,lienzo.toString());
	}

}
