package br.com.fiap.tds.bean;

public class Telefone {

	private int idTelefone, ddi, ddd, numeroTel;
	
	private Usuario usuario;
	
	private Profissional profissional;

	public Telefone() {

	}

	public Telefone(int ddi, int ddd, int numeroTel, Usuario usuario, Profissional profissional) {
		super();
		this.ddi = ddi;
		this.ddd = ddd;
		this.numeroTel = numeroTel;
		this.usuario = usuario;
		this.profissional = profissional;
	}
	
	

	public Telefone(int idTelefone, int ddi, int ddd, int numeroTel) {
		super();
		this.idTelefone = idTelefone;
		this.ddi = ddi;
		this.ddd = ddd;
		this.numeroTel = numeroTel;
	}	

	public Telefone(int ddi, int ddd, int numeroTel, Usuario usuario) {
		super();
		this.ddi = ddi;
		this.ddd = ddd;
		this.numeroTel = numeroTel;
		this.usuario = usuario;
	}	
	

	public Telefone(int ddi, int ddd, int numeroTel, Profissional profissional) {
		super();
		this.ddi = ddi;
		this.ddd = ddd;
		this.numeroTel = numeroTel;
		this.profissional = profissional;
	}

	public int getIdTelefone() {
		return idTelefone;
	}

	public void setIdTelefone(int idTelefone) {
		this.idTelefone = idTelefone;
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

	@Override
	public String toString() {
		return "DDI: " + ddd + ", DDD: " + ddd + ", numero telefone: " + numeroTel;
	}

	

}
