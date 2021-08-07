package br.com.fiap.ex03;
import java.lang.Math;

public class CalculadoraFinanceira {


	double capital, taxa_de_juros;
	int periodo;
		
	
	double calcularJuroSimples() {
		double montante = capital*(1+taxa_de_juros*periodo);
		return montante;
				
	}
	
	double calcularJurosCompostos() {
		double montante = capital*Math.pow(1+ taxa_de_juros, periodo);
		return montante;
		
	}
	
	
}
