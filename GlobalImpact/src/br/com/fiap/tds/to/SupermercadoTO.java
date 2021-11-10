package br.com.fiap.tds.to;

public class SupermercadoTO {
	
	private int codigo;
	
	private String nome;
	
	private String ativo;
	
	private String dataCadastro;
	
	private String cnpj;
	
	private String email;
	
	private String senha;
	
	
	public SupermercadoTO() {
		
	}


	public SupermercadoTO(int codigo, String nome, String ativo, String dataCadastro, String cnpj, String email,
			String senha) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.ativo = ativo;
		this.dataCadastro = dataCadastro;
		this.cnpj = cnpj;
		this.email = email;
		this.senha = senha;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getAtivo() {
		return ativo;
	}


	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}


	public String getDataCadastro() {
		return dataCadastro;
	}


	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}


	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Nome" + nome + ", data de cadastro: " + dataCadastro + ", CNPJ: " + cnpj + ", email: " + email;
	}

}
