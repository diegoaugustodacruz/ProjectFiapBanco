package br.com.fiap.tdss.view;

import javax.swing.JOptionPane;

import br.com.fiap.tdss.bean.Aluno;

public class Ex03 {
	
	public static void main(String[] args) {
		
		
		int n = Integer.parseInt(JOptionPane.showInputDialog("Digite a numero de alunos: "));
		
		
		Aluno[] vetor = new Aluno[n];
		
		
		for(int i = 0; i<vetor.length; i++) {
			
			String nome = JOptionPane.showInputDialog("Digite o nome do aluno: ");
			
			float[] grupoNotas = new float[3];
			for(int p = 0; p <3; p++) {
				float nota = Float.parseFloat(JOptionPane.showInputDialog("Digite a nota: "));
				grupoNotas[p] = nota;
				
			}
			
			vetor[i] = new Aluno(nome, grupoNotas);			
			
			
		}
		
		//declarar um aluno para receber a maior nota
		Aluno alunoMaiorNota = vetor[0];
		
		for(int i = 1; i<vetor.length; i++) {
			if(alunoMaiorNota.getMaiorNota() < vetor[i].getMaiorNota()) {
				alunoMaiorNota = vetor[i];
				
			}
			
		}
		
		//variavel auxiliar para controlar o index do vetor com os alunos com as maiores notas
		
		int index = 0;
		//declarar um vetor para armazenar todos os alunos com a maior nota
		Aluno[] alunosMaioresNotas = new Aluno[n];
		
		//percorrer o vetor novamente para encontrar todos os alunos que possui a nota igual a maior
		for(Aluno aluno: vetor) {
			if(aluno.getMaiorNota() == alunoMaiorNota.getMaiorNota()){
				alunosMaioresNotas[index] = aluno;
				index++;
			}
		}		
		
		//exibir todos os alunos e suas notas		
		for(Aluno aluno: vetor) {
			System.out.println(aluno.getNome());
			for(float nota : aluno.getNotas()) {
				System.out.println(" " + nota);
			}
			System.out.println("\n");
		}
		
		for(int i = 0; i<index; i++) {
			System.out.println(alunosMaioresNotas[i].getNome() + " " + alunosMaioresNotas[i].getMaiorNota());
		}
		
		
		
		
		

		
		
	}

}
