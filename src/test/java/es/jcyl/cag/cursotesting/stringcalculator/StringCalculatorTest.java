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
	
	
	private int add(String numbers) {
		return new StringCalculator().add(numbers);
	}

}
