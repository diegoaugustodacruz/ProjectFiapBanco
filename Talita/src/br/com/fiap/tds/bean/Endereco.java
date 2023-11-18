package br.com.fiap.tds.bean;

import java.util.Objects;

public class Endereco {

	private int id;
	
	private Usuario usuario;
	
	private String pais;
	
	private String estado;
	
	private String cidade;
	
	private String cep;
	
	private String rua;
	
	private String bairro;
	
	private int numero;
	
	public Endereco() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bairro, cep, cidade, estado, id, numero, pais, rua, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cep, other.cep)
				&& Objects.equals(cidade, other.cidade) && Objects.equals(estado, other.estado) && id == other.id
				&& numero == other.numero && Objects.equals(pais, other.pais) && Objects.equals(rua, other.rua)
				&& Objects.equals(usuario, other.usuario);
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", usuario=" + usuario + ", pais=" + pais + ", estado=" + estado + ", cidade="
				+ cidade + ", cep=" + cep + ", rua=" + rua + ", bairro=" + bairro + ", numero=" + numero + "]";
	}
	
	
	
}
