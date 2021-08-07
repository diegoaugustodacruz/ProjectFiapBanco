package br.com.tds.fiap.view;

import javax.swing.JOptionPane;

import br.com.tds.fiap.bean.Animal;
import br.com.tds.fiap.bean.Cliente;
import br.com.tds.fiap.bean.Consulta;
import br.com.tds.fiap.bean.Veterinario;

public class TesteUsuario {
	
	public static void main(String[] args) {
		
		String nomeCliente = JOptionPane.showInputDialog("Digite o nome do cliente: ");
		String formaDePagamento = JOptionPane.showInputDialog("Digite a forma de pagamento: ");
		
		float tamanho = Float.parseFloat(JOptionPane.showInputDialog("Digite o comprimento do animal em metros: "));		
		float peso = Float.parseFloat(JOptionPane.showInputDialog("Digite o peso do animal em quilos: "));
		int idadeAnimal = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do animal: "));		
		String cor = JOptionPane.showInputDialog("Digite a cor do animal: ");		
		String nomeAnimal = JOptionPane.showInputDialog("Digite o nome do animal: ");		
		String doenca = JOptionPane.showInputDialog("Digite a comorbidade a ser tratada: ");		
		String tipo = JOptionPane.showInputDialog("Digite o tipo de animal: ");			
		String raca = JOptionPane.showInputDialog("Digite a raca do animal: ");		

		
		int numeroConsulta= Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da consulta: "));
		String dataConsulta = JOptionPane.showInputDialog("Digite a data da consulta: ");
		String horaConsulta = JOptionPane.showInputDialog("Digite a hora da consulta: ");
		String salaConsulta = JOptionPane.showInputDialog("Digite a sala da consulta: ");
		
		String nomeVet = JOptionPane.showInputDialog("Digite o nome do veterinario: ");		
		double salario = Double.parseDouble(JOptionPane.showInputDialog("Digite o salario do veterinario: "));

		Consulta consulta = new Consulta(numeroConsulta, dataConsulta, horaConsulta, salaConsulta, "Diporona");
		
		Veterinario veterinario = new Veterinario(nomeVet, "8h", "17h", 123, 30, salario, 5050, "Cachorro", consulta);
		
		Animal animal = new Animal(tamanho, peso, idadeAnimal, cor, nomeAnimal, doenca, tipo, raca );
		
		Cliente cliente = new Cliente(nomeCliente, formaDePagamento, consulta, animal);
		
		
		JOptionPane.showMessageDialog(null, "CONSULTA: " + 				
				"\nNumero da Consulta: " + consulta.getNumeroConsulta() + 
				"\nData consulta: " + consulta.getDataConsulta()+
				"\nHora Consulta: " + consulta.getHoraConsulta()+
				"\nSala Consulta: " + consulta.getSalaConsulta());
		
		JOptionPane.showMessageDialog(null, "CLIENTE: " + 
				"\nCliente: " + cliente.getNome() +				
				"\nForma de Pagamento" + cliente.getFormaDePagamento() +				
				"\nAnimal: " + animal.getTipo()+
				"\nRaca: " + animal.getRaca()+
				"\nPeso: " + animal.getPeso() + " kg" +
				"\nIdade Animal: " + animal.getIdade()+
				"\nCor: " + animal.getCor()+
				"\nNome Animal: " + animal.getNome()+
				"\nDoenca: " + animal.getDoenca());
				
								
		JOptionPane.showMessageDialog(null, "VETERINARIO: " +
				"\nNome Veterinario: Dr(a) " + veterinario.getNome()+
				"\nSalario atual: R$" + veterinario.getSalario()+
				"\nEspecialidade: " + veterinario.getEspecialidade());
		
		
		double novoSalario = veterinario.reajusteSalarioAnual(salario);
		
		
		
		JOptionPane.showMessageDialog(null, "INFORMACAO SALARIO VETERINARIO:" +
				"\nSALARIO ATUAL: R$" + veterinario.getSalario()+ 
				"\nSALÁRIO PARA O ANO SEGUINTE: R$" + veterinario.reajusteSalarioAnual(salario) + 
				"\n DIFERENÇA DE: R$" + (veterinario.reajusteSalarioAnual(salario)-veterinario.getSalario())+
		  "\n AUMENTO DE 20%");
		 
		
		
		
		
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
