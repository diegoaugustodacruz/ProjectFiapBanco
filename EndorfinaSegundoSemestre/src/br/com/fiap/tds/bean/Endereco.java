package br.com.fiap.tds.bean;

public class Endereco {
	
	private int idEndereco, numeroCasa, numeroCEP;
	
	private String nomeRua, bairro, cidade, estado;
	
	private Usuario usuario;
	
	private Profissional profissional;
	
	
	public Endereco() {
		
	}


	public Endereco(int numeroCasa, int numeroCEP, String nomeRua, String bairro, String cidade, String estado,
			Usuario usuario, Profissional profissional) {
		super();
		this.numeroCasa = numeroCasa;
		this.numeroCEP = numeroCEP;
		this.nomeRua = nomeRua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.usuario = usuario;
		this.profissional = profissional;
	}
	
	public Endereco(int idEndereco, int numeroCasa, int numeroCEP, String nomeRua, String bairro, String cidade, String estado) {
		super();
		this.idEndereco = idEndereco;
		this.numeroCasa = numeroCasa;
		this.numeroCEP = numeroCEP;
		this.nomeRua = nomeRua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}

	

	public Endereco(int numeroCasa, int numeroCEP, String nomeRua, String bairro, String cidade, String estado) {
		super();
		this.numeroCasa = numeroCasa;
		this.numeroCEP = numeroCEP;
		this.nomeRua = nomeRua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}


	public int getIdEndereco() {
		return idEndereco;
	}


	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}


	public int getNumeroCasa() {
		return numeroCasa;
	}


	public void setNumeroCasa(int numeroCasa) {
		this.numeroCasa = numeroCasa;
	}


	public int getNumeroCEP() {
		return numeroCEP;
	}


	public void setNumeroCEP(int numeroCEP) {
		this.numeroCEP = numeroCEP;
	}


	public String getNomeRua() {
		return nomeRua;
	}


	public void setNomeRua(String nomeRua) {
		this.nomeRua = nomeRua;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Profissional getProfissional() {
		return profissional;
	}


	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}
	
	
	
}
