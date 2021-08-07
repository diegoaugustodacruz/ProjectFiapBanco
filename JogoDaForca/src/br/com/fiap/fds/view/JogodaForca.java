package br.com.fiap.fds.view;
import javax.swing.JOptionPane;

public class JogodaForca {
	public static void main(String[] args) {
		boolean acertou = false;
		int qtd = 0;
		int contaErros = 0;
		String senha, tenta;
		String boneco = "\0";
		String v = JOptionPane.showInputDialog(null,
						"::: Jogo da Forca :::\nConfigurando...\nDigite a Palavra-chave a ser descoberta")
				.toLowerCase();
		
		char formaPalavra[] = new char[v.length()];
		
		String apresentaPalavra = "\0";
		
		for (int y = 0; y < v.length(); y++) {
			formaPalavra[y] = '_';
			apresentaPalavra += formaPalavra[y] + " ";
		}
		
		JOptionPane.showMessageDialog(null, "::: Inicio do Jogo ::: \n");
		for (int j = 0; j < v.length() + 5; j++) // tentativas = qtd de palavras + 5 erros
		{
			acertou = false;
			senha = JOptionPane.showInputDialog(null, "Tentativa: " + (j + 1) + " de " + (v.length() + 5) + "\n"
					+ apresentaPalavra + "\nDigite a letra:");
			apresentaPalavra = "\0";
			for (int i = 0; i < v.length(); i++) {
				tenta = v.substring(i, i + 1);
				if (senha.trim().equals(tenta)) {
					acertou = true;
					qtd++;
					formaPalavra[i] = senha.charAt(0); // converte de String para
					apresentaPalavra = apresentaPalavra + formaPalavra[i] + " ";
					if (qtd == v.length()) {
						JOptionPane.showMessageDialog(null,
								"Você Ganhou! PalavraCompleta: " + v + "\nTotal de Tentativas: " + (j + 1));
						System.exit(0);
					}
				} else {
					apresentaPalavra += formaPalavra[i] + " ";
				}
			}
			if (acertou == false) {
				contaErros++;
				boneco = "\0";
				switch (contaErros) {
				case 1:
					boneco = "  __ O \n";
					boneco += "|\t \n";
					boneco += "|\t \n";
					boneco += "|\t \n";
					break;
				case 2:
					boneco = "  __  O \n";
					boneco += "|        | \n";
					boneco += "|\n";
					boneco += "|\n";
					break;
				case 3:
					boneco = "  __  O \n";
					boneco += "|       -|-\n";
					boneco += "|\n";
					boneco += "|\n";
					break;
				case 4:
					boneco = "  __  O \n";
					boneco += "|       -|-\n";
					boneco += "|       | \n";
					boneco += "|\n";
					break;
				case 5:
					boneco = "  __  O \n";
					boneco += "|       -|-\n";
					boneco += "|       |  | \n";
					boneco += "|        \n";
					break;
				}
				JOptionPane.showMessageDialog(null, boneco + "\nVocê ERROU " + contaErros + " vez(es)");
				if (contaErros >= 5) {
					JOptionPane.showMessageDialog(null, "PERDEU! FIM DO JOGO");
					System.exit(0);
				}
			}
		}
	}
}


