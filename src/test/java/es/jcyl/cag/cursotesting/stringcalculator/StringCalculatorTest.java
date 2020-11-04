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
	
	
	
	private int add(String numbers) {
		return new StringCalculator().add(numbers);
	}

}