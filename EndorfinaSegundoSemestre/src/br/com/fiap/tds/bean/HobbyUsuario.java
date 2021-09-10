package br.com.fiap.tds.bean;

public class HobbyUsuario {

	private int idHobby;
	
	private int idUsuario;
	
	private Hobby hobby;
	
		
	public HobbyUsuario() {
		
	}


	public HobbyUsuario(int idHobby, int idUsuario, Hobby hobby) {
		super();
		this.idHobby = idHobby;
		this.idUsuario = idUsuario;
		this.hobby = hobby;
	}


	public int getIdHobby() {
		return idHobby;
	}


	public void setIdHobby(int idHobby) {
		this.idHobby = idHobby;
	}


	public int getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}


	public Hobby getHobby() {
		return hobby;
	}


	public void setHobby(Hobby hobby) {
		this.hobby = hobby;
	}


	
	
	
	
}
