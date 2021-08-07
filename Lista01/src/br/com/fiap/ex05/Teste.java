package br.com.fiap.ex05;

public class Teste {
	public static void main(String[] args) {
		
		Circulo dados1 = new Circulo();
		Quadrado dados2 = new Quadrado();
		
		double area = dados2.calcularArea(10) - dados1.calcularArea(5);
		
		System.out.println("Área cinza = " + area);
		
		
		
		
		
	}
	
	
}
