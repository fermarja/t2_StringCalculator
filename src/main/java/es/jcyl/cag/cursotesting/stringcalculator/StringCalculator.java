package es.jcyl.cag.cursotesting.stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
	
	private ExtraeNumeros extractor = new DefaultExtraeNumeros();
	
	public StringCalculator() {
		super();
	}
	
	public StringCalculator(ExtraeNumeros extractor) {
		super();
		this.extractor = extractor;
	}
	
	public int add(String numbers) {		
		int[] numeros = extractor.extraerNumeros(numbers);
		comprobarPresenciaNegativos(numeros);
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
