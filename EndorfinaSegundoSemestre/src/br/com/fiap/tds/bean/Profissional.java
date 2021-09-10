package br.com.fiap.tds.bean;

public class Profissional{

	protected int idProfissional, idEndereco, anoDeNascimento;

	protected String nome, email, senha, dtCadastro;
	
	protected HobbyProfissional hobbyProfissional;

	protected Telefone telefone;

	protected Endereco endereco;
	
	public Profissional() {
	}

	

	public Profissional(int idProfissional, int idEndereco, int anoDeNascimento, String nome, String email,
			String senha, String dtCadastro, HobbyProfissional hobbyProfissional, Telefone telefone,
			Endereco endereco) {
		super();
		this.idProfissional = idProfissional;
		this.idEndereco = idEndereco;
		this.anoDeNascimento = anoDeNascimento;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.dtCadastro = dtCadastro;
		this.hobbyProfissional = hobbyProfissional;
		this.telefone = telefone;
		this.endereco = endereco;
	}



	public int exibirIdade() {
		int idade = 2021 - anoDeNascimento;
		return idade;
	}



	public int getIdProfissional() {
		return idProfissional;
	}



	public void setIdProfissional(int idProfissional) {
		this.idProfissional = idProfissional;
	}



	public int getIdEndereco() {
		return idEndereco;
	}



	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}



	public int getAnoDeNascimento() {
		return anoDeNascimento;
	}



	public void setAnoDeNascimento(int anoDeNascimento) {
		this.anoDeNascimento = anoDeNascimento;
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



	public String getDtCadastro() {
		return dtCadastro;
	}



	public void setDtCadastro(String dtCadastro) {
		this.dtCadastro = dtCadastro;
	}



	public HobbyProfissional getHobbyProfissional() {
		return hobbyProfissional;
	}



	public void setHobbyProfissional(HobbyProfissional hobbyProfissional) {
		this.hobbyProfissional = hobbyProfissional;
	}



	public Telefone getTelefone() {
		return telefone;
	}



	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}



	public Endereco getEndereco() {
		return endereco;
	}



	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	

	
	

}
