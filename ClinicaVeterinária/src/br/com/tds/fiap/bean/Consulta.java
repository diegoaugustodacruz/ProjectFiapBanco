package br.com.tds.fiap.bean;

public class Consulta {
	
	int numeroConsulta;
	
	String dataConsulta, horaConsulta, salaConsulta, medicacaoDaConsulta;

	public Consulta() {
		
	}
	
	public Consulta(int numeroConsulta, String dataConsulta, String horaConsulta, String salaConsulta,
			String medicacaoDaConsulta) {
		this.numeroConsulta = numeroConsulta;
		this.dataConsulta = dataConsulta;
		this.horaConsulta = horaConsulta;
		this.salaConsulta = salaConsulta;
		this.medicacaoDaConsulta = medicacaoDaConsulta;
	}

	public int getNumeroConsulta() {
		return numeroConsulta;
	}

	public void setNumeroConsulta(int numeroConsulta) {
		this.numeroConsulta = numeroConsulta;
	}

	public String getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(String dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public String getHoraConsulta() {
		return horaConsulta;
	}

	public void setHoraConsulta(String horaConsulta) {
		this.horaConsulta = horaConsulta;
	}

	public String getSalaConsulta() {
		return salaConsulta;
	}

	public void setSalaConsulta(String salaConsulta) {
		this.salaConsulta = salaConsulta;
	}

	public String getMedicacaoDaConsulta() {
		return medicacaoDaConsulta;
	}

	public void setMedicacaoDaConsulta(String medicacaoDaConsulta) {
		this.medicacaoDaConsulta = medicacaoDaConsulta;
	}
	
	
	
	

}
