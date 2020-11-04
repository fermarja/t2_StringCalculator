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
			if (numero <= 1000) {
				suma += numero;
			}
		}
		return suma;
	}

	private int[] extraerNumeros(String numbers) {
		String[] separadores = new String[]{",", "\n"};
		String parteDeNumeros = numbers;
		if (numbers.startsWith("//[")) {
			separadores = new String[] {numbers.substring(3, numbers.indexOf('\n')-1)};
			parteDeNumeros = numbers.substring(numbers.indexOf('\n')+1);
		}
		else if (numbers.startsWith("//")) {
			String separadoresTmp = numbers.substring(2, numbers.indexOf('\n'));
			if (StringUtils.isBlank(separadoresTmp)) {
				separadores = new String[] {";"};
			}
			else {
				separadores = new String[] {separadoresTmp};
			}
			parteDeNumeros = numbers.substring(numbers.indexOf('\n')+1);
		}
		return extraerNumeros(parteDeNumeros, separadores);
	}

	private int[] extraerNumeros(String parteDeNumeros, String[] separadores) {
		String separadorDefecto = ",";
		String tmp = parteDeNumeros;
		for (String sep : separadores) {
			tmp = StringUtils.replace(tmp, sep, separadorDefecto);
		}
		String[] numeros = StringUtils.split(tmp, separadorDefecto);		
		int[] resultado = new int[numeros.length];
		
		for(int i = 0; i < numeros.length; i++) {
			resultado[i] = Integer.parseInt(numeros[i]);
		}
		comprobarPresenciaNegativos(resultado);
		
		return resultado;
	}
	
	private void comprobarPresenciaNegativos(int[] numeros) {
		List<Integer> negativos = new ArrayList<Integer>();
		for(int i = 0; i < numeros.length; i++) {
			if (numeros[i] < 0) {
				negativos.add(numeros[i]);
			}
		}
		if (!negativos.isEmpty()) {
			throw new IllegalArgumentException("negativos no soportados: " + negativos);
		}
	}

}
