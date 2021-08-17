package br.com.fiap.tds.bean;

public class Usuario {
	
	protected int codigo, anoDeNascimento;

	protected String nome, email, redeSocial;

	protected Hobby hobby;

	protected Telefone telefone;

	protected Endereco endereco;

	
	public Usuario() {
		
	}
	
	public Usuario(int codigo, int anoDeNascimento, String nome, String email, String redeSocial, Hobby hobby,
			Telefone telefone, Endereco endereco) {
		this.codigo = codigo;
		this.anoDeNascimento = anoDeNascimento;
		this.nome = nome;
		this.email = email;
		this.redeSocial = redeSocial;
		this.hobby = hobby;
		this.telefone = telefone;
		this.endereco = endereco;
	}
	
	public String exibirDados() {
		return "Código Usuário: " + codigo + ", Nome do Usuário: " + nome + ", Email: " + email
				+ ", Rede Social: " + redeSocial + ", " +  ", Ano de Nascimento: "
				+ anoDeNascimento;
	}

	public int exibirIdade() {
		int idade = 2021 - anoDeNascimento;
		return idade;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
	
	
	
	
	
	
	
	

}
