package br.com.fiap.tds.bean;

public class Cliente extends Usuario{

	private String tipoDeProcura;

	

	public Cliente() {
	}


	public Cliente(int anoDeNascimento, String nome, String email, String redeSocial, Hobby hobby,
			Telefone telefone, Endereco endereco, String tipoDeProcura) {
		super(anoDeNascimento, nome, email, redeSocial, hobby, telefone, endereco);
		this.tipoDeProcura = tipoDeProcura;
	}

	
	public String exibirDadosUsuario() {
		return "C�digo Usu�rio: " + ", Nome do Usu�rio: " + nome + ", Email: " + email
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
