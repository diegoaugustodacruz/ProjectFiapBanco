package br.com.fiap.tds.bean;

import java.util.Objects;

public class Telefone {
	
	private int id;
	
	private Usuario usuario;
	
	private String telefone;
	
	private String tipoTelefone;
	
	public Telefone() {}

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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(String tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, telefone, tipoTelefone, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefone other = (Telefone) obj;
		return id == other.id && Objects.equals(telefone, other.telefone)
				&& Objects.equals(tipoTelefone, other.tipoTelefone) && Objects.equals(usuario, other.usuario);
	}

	@Override
	public String toString() {
		return "Telefone [id=" + id + ", usuario=" + usuario + ", telefone=" + telefone + ", tipoTelefone="
				+ tipoTelefone + "]";
	}
	
	

}
