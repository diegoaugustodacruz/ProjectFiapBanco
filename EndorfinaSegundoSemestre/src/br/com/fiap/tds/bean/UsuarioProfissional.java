package br.com.fiap.tds.bean;

public class UsuarioProfissional {
	
	protected int idUsuario, idProfissional;
	
	
	public UsuarioProfissional() {
		
	}


	public UsuarioProfissional(int idUsuario, int idProfissional) {
		super();
		this.idUsuario = idUsuario;
		this.idProfissional = idProfissional;
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
	
	

}
