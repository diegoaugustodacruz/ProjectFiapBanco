package br.com.tds.fiap.bean;

public class Continente extends Localidade {
 
	private String hemisferio;
	private String lesteOeste;
	private String climaPredominanteContinente;
	
	//Construtores
	
	public Continente(String nome, double area, double habitantes, String hemisferio, String lesteOeste,
			String climaPredominanteContinente) {
		super(nome, area, habitantes);
		this.hemisferio = hemisferio;
		this.lesteOeste = lesteOeste;
		this.climaPredominanteContinente = climaPredominanteContinente;
	}
	
    public Continente() {
    	
    }
	//Métodos gets e sets
	
	public String getHemisferio() {
		return hemisferio;
	}
	public void setHemisferio(String hemisferio) {
		this.hemisferio = hemisferio;
	}
	public String getLesteOeste() {
		return lesteOeste;
	}
	public void setLesteOeste(String lesteOeste) {
		this.lesteOeste = lesteOeste;
	}
	public String getClimaPredominanteContinente() {
		return climaPredominanteContinente;
	}
	public void setClimaPredominanteContinente(String climaPredominanteContinente) {
		this.climaPredominanteContinente = climaPredominanteContinente;
	}
	//Métodos especificos 

	@Override
	public String toString() {
		return "Continente \nHemisferio =" + hemisferio + "\nLeste ou Oeste =" + lesteOeste + "\nClima predominante do Continente ="
				+ climaPredominanteContinente + "\nNome =" + nome + "\nArea =" + area + "\nHabitantes =" + habitantes;
	}

	
}
