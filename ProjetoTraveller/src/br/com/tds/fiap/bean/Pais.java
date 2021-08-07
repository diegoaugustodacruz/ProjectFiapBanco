package br.com.tds.fiap.bean;

public class Pais extends Localidade{

	private String corBandeira,capitalPais, siglaPais;
	private DicasUteis dicasUteisPais;
	
	//Construtores
	public Pais(String nome, double area, double habitantes, String corBandeira, String capitalPais, String siglaPais,
			DicasUteis dicasUteisPais) {
		super(nome, area, habitantes);
		this.corBandeira = corBandeira;
		this.capitalPais = capitalPais;
		this.siglaPais = siglaPais;
		this.dicasUteisPais = dicasUteisPais;
	}
	public Pais() {
		
	}

	//Métodos gets e sets
	public String getCorBandeira() {
		return corBandeira;
	}

	public void setCorBandeira(String corBandeira) {
		this.corBandeira = corBandeira;
	}

	public String getCapitalPais() {
		return capitalPais;
	}

	public void setCapitalPais(String capitalPais) {
		this.capitalPais = capitalPais;
	}

	public String getSiglaPais() {
		return siglaPais;
	}

	public void setSiglaPais(String siglaPais) {
		this.siglaPais = siglaPais;
	}

	public DicasUteis getDicasUteisPais() {
		return dicasUteisPais;
	}

	public void setDicasUteis(DicasUteis dicasUteisPais) {
		this.dicasUteisPais = dicasUteisPais;
	}

	//Métodos especificos
	
	@Override
	public String toString() {
		return "PAIS: \nCor Bandeira =" + corBandeira + "\nCapital Pais =" + capitalPais + "\nSigla Pais =" + siglaPais
				+ "\n" + dicasUteisPais.toString() + "\nNome =" + nome + "\nArea =" + area + "\nHabitantes ="
				+ habitantes;
	}

	
	
	
}
