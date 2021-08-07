package br.com.tds.fiap.bean;

public class DicasUteis {

	private String quandoIr,fusoHorario,idioma,tipoTomada,moeda,bagagem,comoSeLocomover;
	private double temperaturaMediaAnual, moedaReais;
	private int tempoMedioPermanencia,voltagem;
	private DocumentosNecessarios documentosNecessarios;
	
	
	//Construtores
	
	public DicasUteis(String quandoIr, String fusoHorario, String idioma, String tipoTomada, String moeda,
			String bagagem, String comoSeLocomover, double temperaturaMediaAnual, int tempoMedioPermanencia,
			int voltagem, DocumentosNecessarios documentosNecessarios, double moedaReais) {
		this.quandoIr = quandoIr;
		this.fusoHorario = fusoHorario;
		this.idioma = idioma;
		this.tipoTomada = tipoTomada;
		this.moeda = moeda;
		this.bagagem = bagagem;
		this.comoSeLocomover = comoSeLocomover;
		this.temperaturaMediaAnual = temperaturaMediaAnual;
		this.tempoMedioPermanencia = tempoMedioPermanencia;
		this.voltagem = voltagem;
		this.documentosNecessarios = documentosNecessarios;
		this.moedaReais = moedaReais;
	}
	public DicasUteis() {
		
	}
	//Métodos gets e sets


	public String getQuandoIr() {
		return quandoIr;
	}


	public void setQuandoIr(String quandoIr) {
		this.quandoIr = quandoIr;
	}


	public String getFusoHorario() {
		return fusoHorario;
	}


	public void setFusoHorario(String fusoHorario) {
		this.fusoHorario = fusoHorario;
	}


	public String getIdioma() {
		return idioma;
	}


	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}


	public String getTipoTomada() {
		return tipoTomada;
	}


	public void setTipoTomada(String tipoTomada) {
		this.tipoTomada = tipoTomada;
	}


	public String getMoeda() {
		return moeda;
	}


	public void setMoeda(String moeda) {
		this.moeda = moeda;
	}


	public String getBagagem() {
		return bagagem;
	}


	public void setBagagem(String bagagem) {
		this.bagagem = bagagem;
	}


	public String getComoSeLocomover() {
		return comoSeLocomover;
	}


	public void setComoSeLocomover(String comoSeLocomover) {
		this.comoSeLocomover = comoSeLocomover;
	}


	public double getTemperaturaMediaAnual() {
		return temperaturaMediaAnual;
	}


	public void setTemperaturaMediaAnual(double temperaturaMediaAnual) {
		this.temperaturaMediaAnual = temperaturaMediaAnual;
	}


	public int getTempoMedioPermanencia() {
		return tempoMedioPermanencia;
	}


	public void setTempoMedioPermanencia(int tempoMedioPermanencia) {
		this.tempoMedioPermanencia = tempoMedioPermanencia;
	}


	public int getVoltagem() {
		return voltagem;
	}


	public void setVoltagem(int voltagem) {
		this.voltagem = voltagem;
	}


	public DocumentosNecessarios getDocumentosNecessarios() {
		return documentosNecessarios;
	}


	public void setDocumentosNecessarios(DocumentosNecessarios documentosNecessarios) {
		this.documentosNecessarios = documentosNecessarios;
	}
	
	
	public double getMoedaReais() {
		return moedaReais;
	}


	public void setMoedaReais(double moedaReais) {
		this.moedaReais = moedaReais;
	}
	
	
	//Métodos específicos 
	@Override
	public String toString() {
		return "DICAS UTEIS: \nQuando Ir =" + quandoIr + "\nFuso Horario =" + fusoHorario + "\nIdioma =" + idioma
				+ "\nTipo Tomada =" + tipoTomada + "\nMoeda =" + moeda + "\nBagagem =" + bagagem + "\nComo Se Locomover ="
				+ comoSeLocomover + "\nTemperatura Media Anual =" + temperaturaMediaAnual + "\nTempo Medio Permanencia ="
				+ tempoMedioPermanencia + "\nVoltagem =" + voltagem + "\n" + documentosNecessarios.toString();
	}
		
	
	public double conversorMoeda(String moedaLocal) {
		if(moedaLocal.toUpperCase().equals("DOLAR")) {
			moedaReais = moedaReais/5;
			
		}else if (moedaLocal.toUpperCase().equals("EURO"))	{
			moedaReais = moedaReais/6.16;
			
		}else if (moedaLocal.toUpperCase().equals("LIBRA"))	{
			moedaReais = moedaReais/7.16;
			
		}
		return moedaReais;
		
		
	}
	
	
	public double conversorMoeda(String moedaLocal, double moedaParaTrocar ) {
		if(moedaLocal.toUpperCase().equals("DOLAR")) {
			moedaReais = moedaParaTrocar/5;
			
		}else if (moedaLocal.toUpperCase().equals("EURO"))	{
			moedaReais = moedaParaTrocar/6.16;
			
		}else if (moedaLocal.toUpperCase().equals("LIBRA"))	{
			moedaReais = moedaParaTrocar/7.16;
			
		}
		return moedaReais;
		
		
	}
	
	
	
}
	
	
	
	
	
	
	

