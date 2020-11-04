package es.jcyl.cag.cursotesting.stringcalculator;

import org.apache.commons.lang3.StringUtils;

public class StringCalculator {
	
	public StringCalculator() {
		super();
	}
	
	public int add(String numbers) {
		if (StringUtils.isBlank(numbers)) {
			return 0;
		}
		if (numbers.contains(",")) {
			String[] numeros = numbers.split(",");
			return Integer.parseInt(numeros[0]) + Integer.parseInt(numeros[1]);
		}
		else {
			return Integer.parseInt(numbers);
		}
	}

}
