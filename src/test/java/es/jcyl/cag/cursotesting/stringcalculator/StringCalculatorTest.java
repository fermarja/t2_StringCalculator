package es.jcyl.cag.cursotesting.stringcalculator;

import org.junit.Assert;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StringCalculatorTest {
	
	public StringCalculatorTest () {
		super();
	}
	
	
	@Test
	public void sumaDeNingunValorEsCero() {
		Assert.assertEquals(0, add(new int[0]));
	}
	
	@Test
	public void sumaDeUnNumeroEsElMismo() {
		Assert.assertEquals(2, add(2));
	}
	
	@Test
	public void sumaDeTresYDosEsCinco() {
		Assert.assertEquals(5, add(3,2));
	}
	
	@Test
	public void sumaDeMasDeTresNumeros() {
		Assert.assertEquals(16, add(1,2,3,10));
	}

	
	@Test
	public void noSePermitenNegativos() {
		try {
			add(1,-1,-5,10,-20);
			Assert.fail("Debe lanzarse la excepcion");
		}
		catch (IllegalArgumentException e) {
			String msg = e.getMessage();
			Assert.assertTrue(msg.contains("negativos no soportados"));
			Assert.assertTrue(msg.contains("-1, -5, -20"));
		}
	}

	
	@Test
	public void seIgnoranEnLaSumaNumerosMayoresDeMil() {
		Assert.assertEquals(2, add(2, 1002));
	}

	
	private int add(int... numeros) {
		ExtraeNumeros extractor = mock(ExtraeNumeros.class);
		when(extractor.extraerNumeros(any(String.class))).thenReturn(numeros);
		StringCalculator ec = new StringCalculator(extractor);
		return ec.add("");
	}

}
