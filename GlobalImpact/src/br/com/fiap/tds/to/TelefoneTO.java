package br.com.fiap.tds.to;

public class TelefoneTO {

	private int idTelefone, ddi, ddd, numeroTel;
	
	private SupermercadoTO supermercado;

	public TelefoneTO() {

	}

	public TelefoneTO(int ddi, int ddd, int numeroTel, SupermercadoTO supermercado) {
		super();
		this.ddi = ddi;
		this.ddd = ddd;
		this.numeroTel = numeroTel;
		this.supermercado = supermercado;
	}
	
	

	public TelefoneTO(int idTelefone, int ddi, int ddd, int numeroTel) {
		super();
		this.idTelefone = idTelefone;
		this.ddi = ddi;
		this.ddd = ddd;
		this.numeroTel = numeroTel;
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
