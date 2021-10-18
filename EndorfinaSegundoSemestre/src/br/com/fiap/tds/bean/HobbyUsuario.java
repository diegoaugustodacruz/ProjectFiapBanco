package br.com.fiap.tds.bean;

public class HobbyUsuario {

	private Usuario usuario;
	
	private Hobby hobby;

		
	public HobbyUsuario() {
		
	}


	public HobbyUsuario(Usuario usuario, Hobby hobby) {
		super();
		this.usuario = usuario;
		this.hobby = hobby;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Hobby getHobby() {
		return hobby;
	}


	public void setHobby(Hobby hobby) {
		this.hobby = hobby;
	}


	



	
	
	
	
}
