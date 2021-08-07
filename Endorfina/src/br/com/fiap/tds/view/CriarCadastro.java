package br.com.fiap.tds.view;

import javax.swing.JOptionPane;

import br.com.fiap.tds.bean.Cliente;
import br.com.fiap.tds.bean.Endereco;
import br.com.fiap.tds.bean.Hobby;
import br.com.fiap.tds.bean.Login;
import br.com.fiap.tds.bean.Profissional;
import br.com.fiap.tds.bean.Telefone;

public class CriarCadastro {
	public static void main(String[] args) {

		String tipo = JOptionPane
				.showInputDialog("Olá vamos fazer cadastro ! (digite C para Usuário ou P para Profissional) ");

		switch (tipo) {
		case "C": {
			JOptionPane.showMessageDialog(null, "Olá iremos te fazer algumas perguntas, para afins de cadastro! Vamos lá");

			String nomeDoUsuario = JOptionPane.showInputDialog("Digite o nome do usuário: ");

			int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo: "));

			int anoDeNascimento = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de nascimento: "));

			String email = JOptionPane.showInputDialog("Digite o e-mail: ");

			String senha = JOptionPane.showInputDialog("Digite a senha: ");

			String redeSocial = JOptionPane.showInputDialog("Digite a rede social: ");

			String tipoDeProcura = JOptionPane
					.showInputDialog("Digite o tipo de procura (U para Usuários ou P para Profissionais): ");

			String nomeHobby = JOptionPane.showInputDialog("Digite o hobby desejado: ");

			String rua = JOptionPane.showInputDialog("Digite o nome da rua: ");

			int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da residencia: "));

			String cep = JOptionPane.showInputDialog("Digite o CEP: ");

			String bairro = JOptionPane.showInputDialog("Digite o bairro: ");

			String cidade = JOptionPane.showInputDialog("Digite a cidade: ");

			String estado = JOptionPane.showInputDialog("Digite o estado: ");

			int ddi = Integer.parseInt(JOptionPane.showInputDialog("Digite o DDI: "));

			int ddd = Integer.parseInt(JOptionPane.showInputDialog("Digite o DDD: "));

			int tel = Integer.parseInt(JOptionPane.showInputDialog("Digite o telefone: "));

			Hobby hobby = new Hobby(nomeHobby);

			Endereco endereco = new Endereco(rua, numero, cep, bairro, cidade, estado);

			Telefone telefone = new Telefone(ddi, ddd, tel);

			Login login = new Login(email, senha);

			Cliente cliente = new Cliente(codigo, anoDeNascimento, nomeDoUsuario, email, redeSocial, hobby,
					telefone, endereco, tipoDeProcura);

			switch (tipoDeProcura) {
			case "U": {
				JOptionPane.showMessageDialog(null, "Perfeito, iremos te direcionar para usuários do hobby: " + nomeHobby);
				break;
			}
			case "P": {
				JOptionPane.showMessageDialog(null,
						"Perfeito, iremos te direcionar para os profissionais do hobby: " + nomeHobby);
				break;
			}
			default: {
				return;
			}
			}

			JOptionPane.showMessageDialog(null, cliente.exibirDados());

			JOptionPane.showMessageDialog(null, "Sua idade aproximada é: " + cliente.exibirIdade() + " anos.");

			JOptionPane.showMessageDialog(null, hobby.exibirDadosHobbySimples());

			JOptionPane.showMessageDialog(null, endereco.exibirEnderecoSimples());

			JOptionPane.showMessageDialog(null, telefone.exibirTelSimples());

			JOptionPane.showMessageDialog(null, login.exibirSenha());
		}
		
		case "P":{
			String nomeProfissional = JOptionPane.showInputDialog("Digite o nome do usuário: ");

			int codigoProfissional = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo: "));

			int dataAnoNascimento = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de nascimento: "));

			String emailProfissional = JOptionPane.showInputDialog("Digite o e-mail: ");
			
			String senhaProfissional = JOptionPane.showInputDialog("Digite a senha: ");
			
			String nomeHobbyProfissional = JOptionPane.showInputDialog("Digite o hobby especializado: ");
			
			Hobby hobbyProfissional = new Hobby(nomeHobbyProfissional);
			
			String redeSocialProfissional = JOptionPane.showInputDialog("Digite a rede social: ");
				
			String ruaProfissional = JOptionPane.showInputDialog("Digite o nome da rua: ");

			int numeroProfissional = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da residencia: "));

			String cepProfissional = JOptionPane.showInputDialog("Digite o CEP: ");

			String bairroProfissional = JOptionPane.showInputDialog("Digite o bairro: ");

			String cidadeProfissional = JOptionPane.showInputDialog("Digite a cidade: ");

			String estadoProfissional = JOptionPane.showInputDialog("Digite o estado: ");
			
			int ddiProfissional = Integer.parseInt(JOptionPane.showInputDialog("Digite o DDI: "));

			int dddProfissional = Integer.parseInt(JOptionPane.showInputDialog("Digite o DDD: "));

			int telProfissional = Integer.parseInt(JOptionPane.showInputDialog("Digite o telefone: "));
			
			Endereco enderecoProfissional = new Endereco(ruaProfissional, numeroProfissional, cepProfissional, bairroProfissional, cidadeProfissional, estadoProfissional);

			Telefone telefoneProfissional = new Telefone(ddiProfissional, dddProfissional, telProfissional);
			
			Profissional profissional = new Profissional(codigoProfissional, dataAnoNascimento, nomeProfissional, emailProfissional, redeSocialProfissional, hobbyProfissional,
					telefoneProfissional, enderecoProfissional);
			
			Login loginProfissional = new Login(emailProfissional, senhaProfissional);
			
			JOptionPane.showMessageDialog(null, profissional.exibirDados());

			JOptionPane.showMessageDialog(null, "Sua idade aproximada é: " + profissional.exibirIdade() + " anos.");
			
			JOptionPane.showMessageDialog(null, enderecoProfissional.exibirEnderecoSimples());

			JOptionPane.showMessageDialog(null, telefoneProfissional.exibirTelSimples());
			
			JOptionPane.showMessageDialog(null, loginProfissional.exibirSenha());
		}

		}



	}

}
