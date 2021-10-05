package br.com.fiap.tds.bean;

public class Profissional{

	private int idProfissional;

	private String nome, email, senha, dataCadastro, dataNascimento;
	
	public Profissional() {
	}

	public Profissional(int idProfissional, String nome, String email, String senha, String dataCadastro,
			String dataNascimento) {
		super();
		this.idProfissional = idProfissional;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.dataCadastro = dataCadastro;
		this.dataNascimento = dataNascimento;
	}

	public int getIdProfissional() {
		return idProfissional;
	}

	public void setIdProfissional(int idProfissional) {
		this.idProfissional = idProfissional;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	
	
	

	
	

}
