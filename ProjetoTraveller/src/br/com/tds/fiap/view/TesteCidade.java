package br.com.tds.fiap.view;

import javax.swing.JOptionPane;

import br.com.tds.fiap.bean.Cidade;
import br.com.tds.fiap.bean.DicasUteis;
import br.com.tds.fiap.bean.DocumentosNecessarios;

public class TesteCidade {
	
	
	public static void main(String[] args) {
		
		//Documentos necessarios
		String documentos = JOptionPane.showInputDialog("Digite o documentos para entrar na cidade");
		
		boolean rg = Boolean.parseBoolean(JOptionPane.showInputDialog("Precisa de RG (boolean): "));
		
		boolean cpf = Boolean.parseBoolean(JOptionPane.showInputDialog("Precisa de CPF (boolean): "));

		boolean cnh = Boolean.parseBoolean(JOptionPane.showInputDialog("Precisa de CNH (boolean): "));

		boolean passaporte = Boolean.parseBoolean(JOptionPane.showInputDialog("Precisa de Passaporte (boolean): "));

		
		DocumentosNecessarios documentosNecessarios = new DocumentosNecessarios(documentos, rg, cpf, cnh, passaporte);
		
		
		
		
		//DicasUteis
		String quandoIr = JOptionPane.showInputDialog("Digite a melhor epoca para visitar a cidade: ");
		
		String fusoHorario = JOptionPane.showInputDialog("Digite o fuso horario da cidade: ");
		
		String idioma = JOptionPane.showInputDialog("Digite o idioma oficial da cidade: ");

		String tipoTomada = JOptionPane.showInputDialog("Digite o tipo de tomada da cidade: ");
		
		String moeda = JOptionPane.showInputDialog("Digite a moeda oficial da cidade: ");
		
		String bagagem = JOptionPane.showInputDialog("Digite informacoes da bagagem: ");
		
		String comoSeLocomover = JOptionPane.showInputDialog("Digite como se locomover na cidade");

		double temperaturaMediaAnual = Double.parseDouble(JOptionPane.showInputDialog("Digite a temperatura media da cidade em graus celcios: "));

		double moedaReais = Double.parseDouble(JOptionPane.showInputDialog("Digite quanto de reais deseja trocar: "));
		
		String moedaLocal = JOptionPane.showInputDialog("Para qual moeda você deseja trocar: ");
		
		int tempoMedioPermanencia = Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo que deseja ficar em dias: "));
		
		int voltagem = Integer.parseInt(JOptionPane.showInputDialog("Digite a voltagem em V: "));

		DicasUteis dicasUteisCidade = new DicasUteis(quandoIr, fusoHorario, idioma, tipoTomada, moeda,
				bagagem, comoSeLocomover, temperaturaMediaAnual, tempoMedioPermanencia,
				voltagem, documentosNecessarios, moedaReais);
		
		double conversor = dicasUteisCidade.conversorMoeda(moedaLocal, moedaReais);
		
		
		//Cidade	
		String nome = JOptionPane.showInputDialog("Digite o nome da cidade: ");
				
		double area = Double.parseDouble(JOptionPane.showInputDialog("Digite a area da cidade em km²: "));
				
		double habitantes = Double.parseDouble(JOptionPane.showInputDialog("Digite a quantidade de habitantantes da cidade: "));
				
		double latitude = Double.parseDouble(JOptionPane.showInputDialog("Digite a latitude do marco zero da cidade: "));

		double longitude = Double.parseDouble(JOptionPane.showInputDialog("Digite a longitude do marco zero da cidade: "));

		double densidadeCidade = Double.parseDouble(JOptionPane.showInputDialog("Digite a densidade da cidade: "));

		
		Cidade cidade = new Cidade(nome, area, habitantes, densidadeCidade, latitude,
				 longitude, dicasUteisCidade);
		
		
		
		JOptionPane.showMessageDialog(null, cidade);
		
		
		JOptionPane.showMessageDialog(null, "Para trocar " + moedaReais + " reais para " + moedaLocal + ", voce tera: " + conversor + " " + moedaLocal);

		
		
		
		
		
	}
	
	
	

}
