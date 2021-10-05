package br.com.fiap.tds.bean;

public class HobbyProfissional {

	private int idHobby;
	
	private int idProfissional;	

	public HobbyProfissional() {
		
	}

	public HobbyProfissional(int idHobby, int idProfissional) {
		super();
		this.idHobby = idHobby;
		this.idProfissional = idProfissional;
	}

	public int getIdHobby() {
		return idHobby;
	}

	public void setIdHobby(int idHobby) {
		this.idHobby = idHobby;
	}

	public int getIdProfissional() {
		return idProfissional;
	}

	public void setIdProfissional(int idProfissional) {
		this.idProfissional = idProfissional;
	}

	
	
	
}
