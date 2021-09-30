package br.com.fiap.tds.view;

public class ExemploRegExp {

	public static void main(String[] args) {
		
		String texto = "a";

		//validar se o texto segue um padrao de acordo com a express
		boolean ok = texto.matches("");
		
		System.out.println("Segue o padrão: " + ok);
	}
	
	
}
