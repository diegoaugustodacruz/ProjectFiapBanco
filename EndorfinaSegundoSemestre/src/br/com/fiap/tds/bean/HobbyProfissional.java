package br.com.fiap.tds.bean;

public class HobbyProfissional {

	private Profissional profissional;
	
	private Hobby hobby;	

	public HobbyProfissional() {
		
	}

	public HobbyProfissional(Profissional profissional, Hobby hobby) {
		super();
		this.profissional = profissional;
		this.hobby = hobby;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public Hobby getHobby() {
		return hobby;
	}

	public void setHobby(Hobby hobby) {
		this.hobby = hobby;
	}

	
	
	
}
