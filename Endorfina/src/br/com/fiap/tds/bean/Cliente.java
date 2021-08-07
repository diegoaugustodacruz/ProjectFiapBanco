package br.com.fiap.tds.bean;

public class Cliente extends Usuario{

	private String tipoDeProcura;

	

	public Cliente() {
	}


	public Cliente(int codigo, int anoDeNascimento, String nome, String email, String redeSocial, Hobby hobby,
			Telefone telefone, Endereco endereco, String tipoDeProcura) {
		super(codigo, anoDeNascimento, nome, email, redeSocial, hobby, telefone, endereco);
		this.tipoDeProcura = tipoDeProcura;
	}

	
	public String exibirDadosUsuario() {
		return "Código Usuário: " + codigo + ", Nome do Usuário: " + nome + ", Email: " + email
				+ ", Rede Social: " + redeSocial + ", " +  ", Ano de Nascimento: "
				+ anoDeNascimento + ", Tipo de procura: " + tipoDeProcura;
	}

	public String getTipoDeProcura() {
		return tipoDeProcura;
	}


	public void setTipoDeProcura(String tipoDeProcura) {
		this.tipoDeProcura = tipoDeProcura;
	}

	
	
	

	

	

	

	

}
