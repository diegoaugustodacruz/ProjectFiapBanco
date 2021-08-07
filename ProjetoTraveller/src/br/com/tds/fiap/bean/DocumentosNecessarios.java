package br.com.tds.fiap.bean;

public class DocumentosNecessarios {
	
	private String documentos;
	private boolean rg,cpf,cnh,passaporte;
	
	//Construtores 
	
	public DocumentosNecessarios(String documentos, boolean rg, boolean cpf, boolean cnh, boolean passaporte) {
		this.documentos = documentos;
		this.rg = rg;
		this.cpf = cpf;
		this.cnh = cnh;
		this.passaporte = passaporte;
	}
	
	public DocumentosNecessarios() {
		
	}
	//Metodos gets e sets

	public String getDocumentos() {
		return documentos;
	}

	public void setDocumentos(String documentos) {
		this.documentos = documentos;
	}

	public boolean isRg() {
		return rg;
	}

	public void setRg(boolean rg) {
		this.rg = rg;
	}

	public boolean isCpf() {
		return cpf;
	}

	public void setCpf(boolean cpf) {
		this.cpf = cpf;
	}

	public boolean isCnh() {
		return cnh;
	}

	public void setCnh(boolean cnh) {
		this.cnh = cnh;
	}

	public boolean isPassaporte() {
		return passaporte;
	}

	public void setPassaporte(boolean passaporte) {
		this.passaporte = passaporte;
	}

	
	
	//Métodos especificos
	
	@Override
	public String toString() {
		return "DOCUMENTOS NECESSARIOS: \nDocumentos Específicos =" + documentos + 
				"\nVALIDACAO DOCUMENTOS BASICOS" +
				"\nRG =" + rg + "\nCPF =" + cpf + "\nCNH =" + cnh
				+ "\nPassaporte =" + passaporte;
	}
	
}
