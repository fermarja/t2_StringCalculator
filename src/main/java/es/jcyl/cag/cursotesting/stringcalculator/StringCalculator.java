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
		int[] numeros = extraerNumeros(numbers);
		return sumar(numeros);
		
	}

	private int sumar(int[] numeros) {
		int suma = 0;
		for (int numero : numeros) {
			suma += numero;
		}
		return suma;
	}

	private int[] extraerNumeros(String numbers) {
		String separadores = ",\n";
		String parteDeNumeros = numbers;
		if (numbers.startsWith("//")) {
			separadores = numbers.substring(2, numbers.indexOf('\n'));
			parteDeNumeros = numbers.substring(numbers.indexOf('\n')+1);
		}
		String[] numeros = StringUtils.split(parteDeNumeros, separadores);
		int[] resultado = new int[numeros.length];
		for(int i = 0; i < numeros.length; i++) {
			resultado[i] = Integer.parseInt(numeros[i]);
		}
		return resultado;
	}

}
