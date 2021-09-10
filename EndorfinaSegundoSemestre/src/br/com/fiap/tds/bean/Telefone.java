package br.com.fiap.tds.bean;

public class Telefone {

	private int idTelefone, idUsuario, idProfissional, ddi, ddd, numeroTel;

	public Telefone() {

	}

	public Telefone(int idTelefone, int idUsuario, int idProfissional, int ddi, int ddd, int numeroTel) {
		super();
		this.idTelefone = idTelefone;
		this.idUsuario = idUsuario;
		this.idProfissional = idProfissional;
		this.ddi = ddi;
		this.ddd = ddd;
		this.numeroTel = numeroTel;
	}

	public int getIdTelefone() {
		return idTelefone;
	}

	public void setIdTelefone(int idTelefone) {
		this.idTelefone = idTelefone;
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

	public int getDdi() {
		return ddi;
	}

	public void setDdi(int ddi) {
		this.ddi = ddi;
	}

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public int getNumeroTel() {
		return numeroTel;
	}

	public void setNumeroTel(int numeroTel) {
		this.numeroTel = numeroTel;
	}

	

}
