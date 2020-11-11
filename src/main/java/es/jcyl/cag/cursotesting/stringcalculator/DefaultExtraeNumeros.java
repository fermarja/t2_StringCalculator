package es.jcyl.cag.cursotesting.stringcalculator;

import org.apache.commons.lang3.StringUtils;

public class DefaultExtraeNumeros implements ExtraeNumeros {

	public DefaultExtraeNumeros() {
		super();
	}
	
	public int[] extraerNumeros(String numbers) {
		if (StringUtils.isBlank(numbers)) {
			return new int[0];
		}
		String parteDeNumeros = numbers;
		 if (numbers.startsWith("//")) {
			 parteDeNumeros = numbers.substring(numbers.indexOf('\n')+1);
		 }
		String[] separadores = extraerSeparadores(numbers);
		return extraerNumeros(parteDeNumeros, separadores);
	}
	
	private String[] extraerSeparadores(String numbers) {
		String[] separadores = new String[]{",", "\n"};
		
		if (numbers.startsWith("//[")) {
			String tmp = numbers.substring(3, numbers.indexOf('\n')- 1);
			separadores = StringUtils.splitByWholeSeparator(tmp, "][");
		}
		else if (numbers.startsWith("//")) {
			String separadoresTmp = numbers.substring(2, numbers.indexOf('\n'));
			if (StringUtils.isBlank(separadoresTmp)) {
				separadores = new String[] {";"};
			}
			else {
				separadores = new String[] {separadoresTmp};
			}
		}
		return separadores;
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
		
		
		return resultado;
	}

}
