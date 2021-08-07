package br.com.fiap.tds.ltp.sistemabanco.entidades;

public class Endereco {
	
	public String rua, complemento, bairro, cep;
	
	public short numero;
	
	public short getNumero() {
		return numero;
	}
	
	public void setNumero(short num) {
		numero = num;
	}

}
