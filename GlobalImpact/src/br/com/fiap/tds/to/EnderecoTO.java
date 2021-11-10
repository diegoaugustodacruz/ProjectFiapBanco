package br.com.fiap.tds.to;

public class EnderecoTO {
	
	private int idEndereco, numeroCasa;
	
	private String nomeRua, bairro, cidade, estado, numeroCEP;
	
	private SupermercadoTO supermercado;
	
	public EnderecoTO() {
		
	}
	
	
	public EnderecoTO(int idEndereco, int numeroCasa, String nomeRua, String bairro, String cidade, String estado,
			String numeroCEP, SupermercadoTO supermercado) {
		super();
		this.idEndereco = idEndereco;
		this.numeroCasa = numeroCasa;
		this.nomeRua = nomeRua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.numeroCEP = numeroCEP;
		this.supermercado = supermercado;
	}
	
	public EnderecoTO(int idEndereco, int numeroCasa, String nomeRua, String bairro, String cidade, String estado,
			String numeroCEP) {
		super();
		this.idEndereco = idEndereco;
		this.numeroCasa = numeroCasa;
		this.nomeRua = nomeRua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.numeroCEP = numeroCEP;
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


	public String getNumeroCEP() {
		return numeroCEP;
	}


	public void setNumeroCEP(String numeroCEP) {
		this.numeroCEP = numeroCEP;
	}


	public SupermercadoTO getSupermercado() {
		return supermercado;
	}


	public void setSupermercado(SupermercadoTO supermercado) {
		this.supermercado = supermercado;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Rua: " + nomeRua + ", numero: " + numeroCasa + ", bairro: " + bairro + ", cidade: " + cidade + ", estado: " + estado;
	}
	
}
