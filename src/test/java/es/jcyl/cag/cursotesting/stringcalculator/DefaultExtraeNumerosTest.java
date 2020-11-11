package es.jcyl.cag.cursotesting.stringcalculator;

import org.junit.Assert;
import org.junit.Test;

public class DefaultExtraeNumerosTest {

	public DefaultExtraeNumerosTest() {
		super();
	}
	
	@Test
	public void devuelveArrayVacioParaNull() {
		Assert.assertArrayEquals(new int[0], extraer(null));
	}
	
	@Test
	public void devuelveArrayVacioParaCadenaVacia() {
		Assert.assertArrayEquals(new int[0], extraer(""));
	}
	
	@Test
	public void devuelveArrayVacioParaCadenaConBlancos() {
		Assert.assertArrayEquals(new int[0], extraer(" "));
	}
	
	@Test
	public void delimitadorSaltoDeLinea() {
		Assert.assertArrayEquals(new int[] {1,2,3},  extraer("1\n2,3"));
	}
	
	@Test
	public void delimitadorPersonalizado() {
		Assert.assertArrayEquals(new int[] {1,2}, extraer("//;\n1;2"));
	}
	
	@Test
	public void delimitadorPersonalizadoPeroVacio() {
		Assert.assertArrayEquals(new int[] {1,2}, extraer("//\n1;2"));
	}
	
	@Test
	public void separadorMultiplesCaracteres() {
		Assert.assertArrayEquals(new int[] {1,2,3}, extraer("//[***]\n1***2***3"));
	}
	
	@Test
	public void variosSeparadoresDeMultiplesCaracteresUnCaracterCadaUno() {
		Assert.assertArrayEquals(new int[] {1,2,3}, extraer("//[*][%]\n1*2%3"));
	}
	
	@Test
	public void variosSeparadoresDeMultiplesCaracteresDinstintaLongitud() {
		Assert.assertArrayEquals(new int[] {1,2,3}, extraer("//[*****][%%%]\n1*****2%%%3"));
	}
		
		
	private int[] extraer(String numeros) {
		return new DefaultExtraeNumeros().extraerNumeros(numeros);
	}
	
}
	
	
