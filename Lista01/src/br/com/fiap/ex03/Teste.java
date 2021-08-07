package br.com.fiap.ex03;

public class Teste {
	
	public static void main(String[] args) {
		
		CalculadoraFinanceira dados = new CalculadoraFinanceira();
		
		double c = 1000, t = 0.1 ;
		int p = 2;
		
				
		dados.capital = c;
		dados.taxa_de_juros = t;
		dados.periodo = p;
		
		double js = dados.calcularJuroSimples();
		
		double jc = dados.calcularJurosCompostos();
		
		System.out.println("Montande de Juro Simples: " + js);
		
		System.out.println("Montande de Juro Composto: " + jc);

		
		
		
	}

}
