package es.jcyl.cag.cursotesting.stringcalculator;

import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTest {
	
	public StringCalculatorTest () {
		super();
	}
	
	@Test
	public void testNull() {
		Assert.assertEquals(0, add(null));
	}
	@Test
	public void testCadenaVacia() {
		Assert.assertEquals(0, add(""));
	}
	@Test
	public void testCadenaBlank() {
		Assert.assertEquals(0, add("   "));
	}
	
	@Test
	public void testSumaUnNumero() {
		Assert.assertEquals(2, add("2"));
	}
	
	@Test
	public void testSumaDosNumeros() {
		Assert.assertEquals(5, add("3,2"));
	}
	
	@Test
	public void testSumaVariosNumeros() {
		Assert.assertEquals(16, add("1,2,3,10"));
	}
	
	@Test
	public void testDelimitadorSaltoDeLinea() {
		Assert.assertEquals(6,  add("1\n2,3"));
	}
	
	@Test
	public void testDelimitadorPersonalizado() {
		Assert.assertEquals(3, add("//;\n1;2"));
	}
	
	@Test
	public void testDelimitadorPersonalizadoPeroVacio() {
		Assert.assertEquals(3, add("//\n1;2"));
	}
	
	@Test
	public void testErrorNegativos() {
		try {
			add("1,-1,-5,10,-20");
			Assert.fail("Debe lanzarse la excepcion");
		}
		catch (IllegalArgumentException e) {
			String msg = e.getMessage();
			Assert.assertTrue(msg.contains("negativos no soportados"));
			Assert.assertTrue(msg.contains("-1, -5, -20"));
		}
	}
	
	
	@Test
	public void testIgnorarMayoresQueMil() {
		Assert.assertEquals(2, add("2,1002"));
	}
	
	@Test
	public void testSeparadorMultiplesCaracteres() {
		Assert.assertEquals(6, add("//[***]\n1***2***3"));
	}
	
	@Test
	public void testSeparadoresMultiples() {
		Assert.assertEquals(6, add("//[*][%]\\n1*2%3"));
	}
	
	@Test
	public void testSeparadoresMultipesMultiplesCaracteres() {
		Assert.assertEquals(6, add("//[*****][%%%]\\n1*****2%%%3"));
	}
	
	private int add(String numbers) {
		return new StringCalculator().add(numbers);
	}

}
