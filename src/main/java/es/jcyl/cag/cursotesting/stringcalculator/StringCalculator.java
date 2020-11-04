package es.jcyl.cag.cursotesting.stringcalculator;

import java.util.ArrayList;
import java.util.List;

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
			if (StringUtils.isBlank(separadores)) {
				separadores = ";";
			}
			parteDeNumeros = numbers.substring(numbers.indexOf('\n')+1);
		}
		String[] numeros = StringUtils.split(parteDeNumeros, separadores);		
		int[] resultado = new int[numeros.length];
		List<Integer> negativos = new ArrayList<Integer>();
		for(int i = 0; i < numeros.length; i++) {
			resultado[i] = Integer.parseInt(numeros[i]);
			if (resultado[i] < 0) {
				negativos.add(resultado[i]);
			}
		}
		if (!negativos.isEmpty()) {
			throw new IllegalArgumentException("negativos no soportados: " + negativos);
		}
		
		return resultado;
	}

}
