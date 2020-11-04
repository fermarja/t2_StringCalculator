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
			int suma = 0;
			for (String numero: numeros) {
				suma += Integer.parseInt(numero);
			}
			return suma;
		}
		else {
			return Integer.parseInt(numbers);
		}
	}

}
