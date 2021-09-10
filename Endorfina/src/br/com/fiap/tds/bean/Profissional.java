package br.com.fiap.tds.bean;

public class Profissional{

	protected int idProfissional, anoDeNascimento;

	protected String nome, email, senha, redeSocial;

	protected Hobby hobby;

	protected Telefone telefone;

	protected Endereco endereco;
	
	public Profissional() {
	}

	public Profissional(int idProfissional, int anoDeNascimento, String nome, String email, String senha,
			String redeSocial, Hobby hobby, Telefone telefone, Endereco endereco) {
		super();
		this.idProfissional = idProfissional;
		this.anoDeNascimento = anoDeNascimento;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.redeSocial = redeSocial;
		this.hobby = hobby;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public int getIdProfissional() {
		return idProfissional;
	}

	public void setIdProfissional(int idProfissional) {
		this.idProfissional = idProfissional;
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

	public String getRedeSocial() {
		return redeSocial;
	}

	public void setRedeSocial(String redeSocial) {
		this.redeSocial = redeSocial;
	}

	public Hobby getHobby() {
		return hobby;
	}

	public void setHobby(Hobby hobby) {
		this.hobby = hobby;
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

	public String toString() {
		return "ID Profissional " + idProfissional + ", Nome do Usuario: " + nome + ", Email: " + email
				+ ", Rede Social: " + redeSocial + ", " +  ", Ano de Nascimento: "
				+ anoDeNascimento;
	}

	public int exibirIdade() {
		int idade = 2021 - anoDeNascimento;
		return idade;
	}
	

	

	

	

	

}
