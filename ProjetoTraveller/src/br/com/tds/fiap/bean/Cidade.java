package br.com.tds.fiap.bean;

public class Cidade extends Localidade{

	private double densidadeCidade,latitude,longitude;
	private DicasUteis dicasUteisCidade;
	
	//Construtores
	
	public Cidade(String nome, double area, double habitantes, double densidadeCidade, double latitude,
			double longitude, DicasUteis dicasUteisCidade) {
		super(nome, area, habitantes);
		this.densidadeCidade = densidadeCidade;
		this.latitude = latitude;
		this.longitude = longitude;
		this.dicasUteisCidade = dicasUteisCidade;
	}
	public Cidade() {
		
	}
	//Métodos gets e sets
	
	public double getDensidadeCidade() {
		return densidadeCidade;
	}

	public void setDensidadeCidade(double densidadeCidade) {
		this.densidadeCidade = densidadeCidade;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public DicasUteis getDicasUteisCidade() {
		return dicasUteisCidade;
	}

	public void setDicasUteisCidade(DicasUteis dicasUteisCidade) {
		this.dicasUteisCidade = dicasUteisCidade;
	}
	
	
	//Métodos específicos
	
	@Override
	public String toString() {
		return "Cidade \ndensidade cidade =" + densidadeCidade + "\nlatitude =" + latitude + "\nlongitude =" + longitude
				+ "\ndicas uteis cidade =" + dicasUteisCidade + "\nnome =" + nome + "\narea =" + area + "\nhabitantes ="
				+ habitantes;
	}
	
	
	public double densindade() {
		densidadeCidade = getHabitantes()/getArea();
		return densidadeCidade;
	}
	
}
