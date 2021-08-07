package br.com.fiap.tds.ltp.jogo.personagem;

public class Personagem {
	
	private int forca, inteligencia, destreza, level;
	
	private String nome;
	
	public Personagem () {
		
	}
	
	public Personagem(int forca, int inteligencia, int destreza, int level, String nome) {
		super();
		this.forca = forca;
		this.inteligencia = inteligencia;
		this.destreza = destreza;
		this.level = level;
		this.nome = nome;
	}

	public int getForca() {
		return forca;
	}

	public void setForca(int forca) {
		this.forca = forca;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}

	public int getDestreza() {
		return destreza;
	}

	public void setDestreza(int destreza) {
		this.destreza = destreza;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	protected double subirLevel() {
		level = level + 10;
		return level;
	}
	
	

}
