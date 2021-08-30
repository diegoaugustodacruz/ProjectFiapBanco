package br.com.fiap.tds.bean;

public class Login {

	protected int idLogin;

	protected String email, senha;

	public Login() {

	}

	public Login(int idLogin, String email, String senha) {
		this.idLogin = idLogin;
		this.email = email;
		this.senha = senha;

	}

	public Login(String email, String senha) {
		this.email = email;
		this.senha = senha;

	}

	public String exibirDadosLogin() {
		return "C�digo: " + idLogin + ", Email: " + email + ", Senha: " + senha;
	}

	public String exibirSenha() {
		return "A senha definida � " + senha;
	}

	public int getCodigoDoLogin() {
		return idLogin;
	}

	public void setCodigoDoLogin(int codigoDoLogin) {
		this.idLogin = codigoDoLogin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
