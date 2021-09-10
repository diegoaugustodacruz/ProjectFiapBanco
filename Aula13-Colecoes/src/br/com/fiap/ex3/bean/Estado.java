package br.com.fiap.ex3.bean;

import java.util.HashSet;
import java.util.Set;

public class Estado {

	private String sigla;
	
	private Set<Integer> ddds;
	
	
	public Estado(String sigla) {
		super();
		this.sigla = sigla;
		this.ddds = new HashSet<Integer>();
		
	}

	public Estado(String sigla, Set<Integer> dds) {
		super();
		this.sigla = sigla;
		this.ddds = dds;
	}
	
	public void addDDD(int valor) {
		ddds.add(valor);
		
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Set<Integer> getDdds() {
		return ddds;
	}

	public void setDdds(Set<Integer> dds) {
		this.ddds = dds;
	}
	
	
	
	

}


