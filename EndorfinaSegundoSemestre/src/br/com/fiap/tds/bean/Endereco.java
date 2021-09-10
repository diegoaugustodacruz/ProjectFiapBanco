package br.com.fiap.tds.bean;

public class Endereco {
	
	private int idEndereco, idUsuario, idProfissional, numeroCasa, numeroCEP;
	
	private String nomeRua, bairro, cidade, estado;
	
	public Endereco() {
		
	}

	public Endereco(int idEndereco, int idUsuario, int idProfissional, int numeroCasa, int numeroCEP, String nomeRua,
			String bairro, String cidade, String estado) {
		super();
		this.idEndereco = idEndereco;
		this.idUsuario = idUsuario;
		this.idProfissional = idProfissional;
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

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdProfissional() {
		return idProfissional;
	}

	public void setIdProfissional(int idProfissional) {
		this.idProfissional = idProfissional;
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
	
	
	

	
	
	
	
}
