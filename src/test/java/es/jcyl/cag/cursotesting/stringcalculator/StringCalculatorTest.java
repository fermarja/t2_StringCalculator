package es.jcyl.cag.cursotesting.stringcalculator;

import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTest {
	
	public StringCalculatorTest () {
		super();
	}
	
	@Test
	public void devolverCeroSiElParametroEsNull() {
		Assert.assertEquals(0, add(null));
	}
	@Test
	public void devolverCeroSiElParametroEsVacio() {
		Assert.assertEquals(0, add(""));
	}
	@Test
	public void devolverCeroSiElParametroEsBlancos() {
		Assert.assertEquals(0, add("   "));
	}
	
	@Test
	public void sumaDeUnUnicoNumeroEsElMismo() {
		Assert.assertEquals(2, add("2"));
	}
	
	@Test
	public void sumaDosNumeros() {
		Assert.assertEquals(5, add("3,2"));
	}
	
	@Test
	public void sumaMasDeDosNumeros() {
		Assert.assertEquals(16, add("1,2,3,10"));
	}
	
	@Test
	public void delimitadorSaltoDeLinea() {
		Assert.assertEquals(6,  add("1\n2,3"));
	}
	
	@Test
	public void delimitadorPersonalizado() {
		Assert.assertEquals(3, add("//;\n1;2"));
	}
	
	@Test
	public void delimitadorPersonalizadoPeroVacio() {
		Assert.assertEquals(3, add("//\n1;2"));
	}
	
	@Test
	public void noSePermitenNumerosNegativos() {
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
	public void noSePermitenNumerosMayoresDeMil() {
		Assert.assertEquals(2, add("2,1002"));
	}
	
	@Test
	public void separadorMultiplesCaracteres() {
		Assert.assertEquals(6, add("//[***]\n1***2***3"));
	}
	
	@Test
	public void variosSeparadoresDeMultiplesCaracteresUnCaracterCadaUno() {
		Assert.assertEquals(6, add("//[*][%]\n1*2%3"));
	}
	
	@Test
	public void variosSeparadoresDeMultiplesCaracteresDinstintaLongitud() {
		Assert.assertEquals(6, add("//[*****][%%%]\n1*****2%%%3"));
	}
	
	private int add(String numbers) {
		return new StringCalculator().add(numbers);
	}

}
