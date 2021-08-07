package br.com.fiap.tds.bean;

public class Endereco {
	
	private int codigoEndereco, numero;
	
	private String rua, cep, bairro, cidade, estado;
	
	public Endereco() {
		
	}
	
	public Endereco(String rua, int numero, String cep, String bairro, String cidade, String estado) {
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	public Endereco(String rua, int numero, String bairro, String cidade, String estado) {
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	public Endereco(int numero, String cep) {
		this.numero = numero;
		this.cep = cep;
	}
	
	public String exibirDadosEndereo() {
		return "Rua: " + rua + ", número: " + numero + ", CEP: " + cep + ", Bairro: " + bairro + ", Cidade: " + cidade + ", Estado: " + estado;
	}

	public String exibirEnderecoSimples() {
		return "Você esta localizado na " + rua + ", número " + numero
				+ ", da cidade de " + cidade + ", no estado de " + estado;
		
	}

	public int getCodigoEndereco() {
		return codigoEndereco;
	}

	public void setCodigoEndereco(int codigoEndereco) {
		this.codigoEndereco = codigoEndereco;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
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
