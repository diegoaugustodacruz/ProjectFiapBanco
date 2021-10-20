package br.com.fiap.tds.bean;

public class Hobby {

	private int idHobby;

	private String nomeHobby;

	public Hobby() {
	}

	public Hobby(int idHobby, String nomeHobby) {
		super();
		this.idHobby = idHobby;
		this.nomeHobby = nomeHobby;
	}
	
	

	public Hobby(String nomeHobby) {
		super();
		this.nomeHobby = nomeHobby;
	}

	public int getIdHobby() {
		return idHobby;
	}

	public void setIdHobby(int idHobby) {
		this.idHobby = idHobby;
	}

	public String getNomeHobby() {
		return nomeHobby;
	}

	public void setNomeHobby(String nomeHobby) {
		this.nomeHobby = nomeHobby;
	}

	@Override
	public String toString() {
		return "Nome Hobby: " + nomeHobby;
	}
	

}
