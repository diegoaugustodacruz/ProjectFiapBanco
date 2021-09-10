package br.com.fiap.tds.bean;

public class Usuario {
	
	protected int idUsuario, idEndereco, anoDeNascimento;

	protected String nome, email, senha, dtCadastro;
	
	protected HobbyUsuario hobbyUsuario;

	protected Telefone telefone;

	protected Endereco endereco;

	
	public Usuario() {
		
	}		
	

	public Usuario(int idUsuario, int idEndereco, int anoDeNascimento, String nome, String email, String senha,
			HobbyUsuario hobbyUsuario, Telefone telefone, Endereco endereco) {
		super();
		this.idUsuario = idUsuario;
		this.idEndereco = idEndereco;
		this.anoDeNascimento = anoDeNascimento;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.hobbyUsuario = hobbyUsuario;
		this.telefone = telefone;
		this.endereco = endereco;
	}


	public int exibirIdade() {
		int idade = 2021 - anoDeNascimento;
		return idade;
	}



	public int getIdUsuario() {
		return idUsuario;
	}



	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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



	public HobbyUsuario getHobbyUsuario() {
		return hobbyUsuario;
	}



	public void setHobbyUsuario(HobbyUsuario hobbyUsuario) {
		this.hobbyUsuario = hobbyUsuario;
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
