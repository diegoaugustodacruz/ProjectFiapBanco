package br.com.fiap.tds.bean;

public class Login {

	private int codigoDoLogin;

	private String email, senha;

	public Login() {

	}

	public Login(int codigoDoLogin, String email, String senha) {
		this.codigoDoLogin = codigoDoLogin;
		this.email = email;
		this.senha = senha;

	}

	public Login(String email, String senha) {
		this.email = email;
		this.senha = senha;

	}

	public String exibirDadosLogin() {
		return "Código: " + codigoDoLogin + ", Email: " + email + ", Senha: " + senha;
	}

	public String exibirSenha() {
		return "A senha definida é " + senha;
	}

	public int getCodigoDoLogin() {
		return codigoDoLogin;
	}

	public void setCodigoDoLogin(int codigoDoLogin) {
		this.codigoDoLogin = codigoDoLogin;
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
