package br.com.tds.fiap.view;

import javax.swing.JOptionPane;

import br.com.tds.fiap.bean.DicasUteis;
import br.com.tds.fiap.bean.DocumentosNecessarios;
import br.com.tds.fiap.bean.Pais;

public class TestePais {	
	
	public static void main(String[] args) {
					
		//Documentos necessarios
		String documentos = JOptionPane.showInputDialog("Digite o documentos para entrar no pais");
		
		boolean rg = Boolean.parseBoolean(JOptionPane.showInputDialog("Precisa de RG (boolean): "));
		
		boolean cpf = Boolean.parseBoolean(JOptionPane.showInputDialog("Precisa de CPF (boolean): "));

		boolean cnh = Boolean.parseBoolean(JOptionPane.showInputDialog("Precisa de CNH (boolean): "));

		boolean passaporte = Boolean.parseBoolean(JOptionPane.showInputDialog("Precisa de Passaporte (boolean): "));

		
		DocumentosNecessarios documentosNecessarios = new DocumentosNecessarios(documentos, rg, cpf, cnh, passaporte);
		
		
		
		
		//DicasUteis
		String quandoIr = JOptionPane.showInputDialog("Digite a melhor epoca para ir: ");
		
		String fusoHorario = JOptionPane.showInputDialog("Digite o fuso horario do pais: ");
		
		String idioma = JOptionPane.showInputDialog("Digite o idioma oficial do pais: ");

		String tipoTomada = JOptionPane.showInputDialog("Digite o tipo de tomada do pais: ");
		
		String moeda = JOptionPane.showInputDialog("Digite a moeda oficial do pais: ");
		
		String bagagem = JOptionPane.showInputDialog("Digite informacoes da bagagem: ");
		
		String comoSeLocomover = JOptionPane.showInputDialog("Digite como se locomover no pais");

		double temperaturaMediaAnual = Double.parseDouble(JOptionPane.showInputDialog("Digite a temperatura media do pais em graus celcios: "));

		double moedaReais = Double.parseDouble(JOptionPane.showInputDialog("Digite quanto de reais deseja trocar: "));
		
		String moedaLocal = JOptionPane.showInputDialog("Para qual moeda você deseja trocar: ");
		
		int tempoMedioPermanencia = Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo que deseja ficar em dias: "));
		
		int voltagem = Integer.parseInt(JOptionPane.showInputDialog("Digite a voltagem em V: "));

		DicasUteis dicasUteisPais = new DicasUteis(quandoIr, fusoHorario, idioma, tipoTomada, moeda,
				bagagem, comoSeLocomover, temperaturaMediaAnual, tempoMedioPermanencia,
				voltagem, documentosNecessarios, moedaReais);
		
		double conversor = dicasUteisPais.conversorMoeda(moedaLocal);
		
		
		//Pais		
		String nome = JOptionPane.showInputDialog("Digite o nome do pais: ");
				
		double area = Double.parseDouble(JOptionPane.showInputDialog("Digite a area do pais em km²: "));
				
		double habitantes = Double.parseDouble(JOptionPane.showInputDialog("Digite a quantidade de habitantantes do pais: "));
				
		String corBandeira = JOptionPane.showInputDialog("Digite as cores da bandeira do pais: ");
				
		String siglaPais = JOptionPane.showInputDialog("Digite a sigla do pais");				
				
		String capitalPais = JOptionPane.showInputDialog("Digite a capital do do pais: ");
		
		Pais pais = new Pais(nome,  area,  habitantes, corBandeira, capitalPais, siglaPais,
				dicasUteisPais);
		
		
		JOptionPane.showMessageDialog(null, pais);
		
		
		JOptionPane.showMessageDialog(null, "Para trocar " + moedaReais + " reais para " + moedaLocal + ", voce tera: " + conversor + " " + moedaLocal);

		
		
		
		
		
	}
	
	
	
	
	



	
	
	
}
