package br.com.fiap.tds.to;

public class TelefoneTO {

	private int idTelefone, ddd, numeroTel;
	
	private String ddi;
	
	private SupermercadoTO supermercado;

	public TelefoneTO() {

	}

	public TelefoneTO(String ddi, int ddd, int numeroTel, SupermercadoTO supermercado) {
		super();
		this.ddi = ddi;
		this.ddd = ddd;
		this.numeroTel = numeroTel;
		this.supermercado = supermercado;
	}
	
	

	public TelefoneTO(String ddi, int ddd, int numeroTel, int idTelefone) {
		super();
		this.ddi = ddi;
		this.ddd = ddd;
		this.numeroTel = numeroTel;
		this.idTelefone = idTelefone;
	}	


	public int getIdTelefone() {
		return idTelefone;
	}

	public void setIdTelefone(int idTelefone) {
		this.idTelefone = idTelefone;
	}

	public String getDdi() {
		return ddi;
	}

	public void setDdi(String ddi) {
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

	public SupermercadoTO getSupermercado() {
		return supermercado;
	}

	public void setSupermercado(SupermercadoTO supermercado) {
		this.supermercado = supermercado;
	}

	
	@Override
	public String toString() {
		return "DDI: " + ddd + ", DDD: " + ddd + ", numero telefone: " + numeroTel;
	}

	

}
