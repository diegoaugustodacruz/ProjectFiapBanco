package br.com.fiap.tds.bean;

public class UsuarioProfissional {
	
	private Usuario usuario;
	
	private Profissional profissional;
	
	
	public UsuarioProfissional() {
		
	}


	public UsuarioProfissional(Usuario usuario, Profissional profissional) {
		super();
		this.usuario = usuario;
		this.profissional = profissional;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Profissional getProfissional() {
		return profissional;
	}


	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}


	
	
	

}
