package br.com.fiap.tds.bean;

public class HobbyProfissional {

	private int idHobby;
	
	private int idProfissional;
	
	private Hobby hobby;

	public HobbyProfissional() {
		
	}

	public HobbyProfissional(int idHobby, int idProfissional, Hobby hobby) {
		super();
		this.idHobby = idHobby;
		this.idProfissional = idProfissional;
		this.hobby = hobby;
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

	public Hobby getHobby() {
		return hobby;
	}

	public void setHobby(Hobby hobby) {
		this.hobby = hobby;
	}
	
	
}
