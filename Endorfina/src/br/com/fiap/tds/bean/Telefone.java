package br.com.fiap.tds.bean;

public class Telefone {

	private int codigoTelefone, ddi, ddd, tel;

	public Telefone() {

	}

	public Telefone(int codigoTelefone, int ddi, int ddd, int tel) {
		this.ddi = ddi;
		this.ddd = ddd;
		this.tel = tel;

	}

	public Telefone(int ddi, int ddd, int tel) {
		this.ddi = ddi;
		this.ddd = ddd;
		this.tel = tel;

	}

	public Telefone(int ddd, int tel) {
		this.ddd = ddd;
		this.tel = tel;

	}

	public String exibirDadosTel() {
		return "Código: " + codigoTelefone + ", DDI: " + ddi + ", DDD: " + ddd + ", TEL: " + tel;

	}

	public String exibirTelSimples() {
		return "Seu telefone é: " + ddi + " " + ddd + " " + tel;
	}

	public int getCodigoTelefone() {
		return codigoTelefone;
	}

	public void setCodigoTelefone(int codigoTelefone) {
		this.codigoTelefone = codigoTelefone;
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

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

}
