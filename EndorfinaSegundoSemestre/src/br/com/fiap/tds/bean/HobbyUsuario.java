package br.com.fiap.tds.bean;

public class HobbyUsuario {

	private int idHobby;
	
	private int idUsuario;	

		
	public HobbyUsuario() {
		
	}


	public HobbyUsuario(int idHobby, int idUsuario) {
		super();
		this.idHobby = idHobby;
		this.idUsuario = idUsuario;
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




	
	
	
	
}
