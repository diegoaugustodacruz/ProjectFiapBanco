package br.com.fiap.ex1.view;

import javax.swing.JOptionPane;

public class Anagrama {

	public static void main(String[] args) {

		String palavra = Digite_a_palavra();
		char vetor[];

		/**
		 * metodo que retira todos os espaços do inicio, meio e fim das palavras
		 * digitadas
		 */
		palavra = Retira_Espaco(palavra);

		vetor = new char[palavra.length()];

		/**
		 * metodo que armazena a palavra em vetor
		 */
		Quebra_Palavra(palavra, vetor);

		/**
		 * metodo que cria o anagrama
		 */
		Calcula_Anagrama(vetor, 0);

		/**
		 * finaliza programa
		 */
		System.exit(0);
	}// fim main()

	/**
	 * Este metodo pede ao usuario para entrar com uma palavra
	 * 
	 * @return palavra
	 */
	private static String Digite_a_palavra() {
		String palavra = "";
		while (palavra.length() <= 2) {
			palavra = JOptionPane.showInputDialog(null,
					"Digite uma palavra de no minimo 3 caracteres",
					"Calculando Anagrama", JOptionPane.INFORMATION_MESSAGE);
		}
		return palavra;
	}// fim metodo Digite_a_palavra()

	/**
	 * Este metodo mostra a palavra. A palavra é armazenada em um vetor para
	 * ficar mais facil o manuseio
	 * 
	 * @param vetor
	 */
	private static void Mostra(char[] vetor) {
		for (int i = 0; i < vetor.length; i++) {
			System.out.print(vetor[i] + " ");
		}// for
		System.out.println("");
	}// fim metodo Mostra()

	/**
	 * Este metodo recebe uma palavra e remove todos os espaços entre, durante e
	 * no final de qualquer palavra.
	 * 
	 * @param palavra
	 * @return palavra_sem_espaços
	 */
	private static String Retira_Espaco(String palavra) {
		String alterada = "", interna = (palavra).trim();
		char c;

		for (int i = 0; i < interna.length(); i++) {
			c = interna.charAt(i);
			if (Character.isLetterOrDigit(c)) {
				alterada += c;
			}// if
		}// for

		return alterada;
	}// fim metodo Retira_Espaco()

	/**
	 * Este metodo recebe o vetor contendo a palavra e mostra para o usuario
	 * todas as possibilidades de anagrama com esta palavra.
	 * 
	 * @param vetor
	 */
	private static void Calcula_Anagrama(char vetor[], int k) {
		int i;
		if (k == vetor.length - 1)
			Mostra(vetor);
		else {
			Calcula_Anagrama(vetor, k + 1);
			i = k + 1;
			while (i < vetor.length) {
				Troca_Posicao(vetor, k, i);
				Calcula_Anagrama(vetor, k + 1);
				Troca_Posicao(vetor, k, i);
				i = i + 1;
			}
		}
	}// fim metodo Calcula_Anagrama()

	/**
	 * Este metodo efetua a troca das posições desejadas
	 * 
	 * @param vetor
	 * @param i
	 * @param k
	 */
	private static void Troca_Posicao(char[] vetor, int k, int i) {
		char aux;
		aux = vetor[i];
		vetor[i] = vetor[k];
		vetor[k] = aux;
	}// fim metodo Troca_Posicao()

	/**
	 * Este metodo recebe a palavra e um vetor vazio e retorna o vetor contendo
	 * a palavra
	 * 
	 * @param palavra
	 * @param vetor
	 */
	private static void Quebra_Palavra(String palavra, char vetor[]) {
		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = palavra.charAt(i);
		}// for
	}// fim metodo Quebra_Palavra()
}// fim class
