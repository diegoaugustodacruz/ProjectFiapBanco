package br.com.fiap.tds.bean;

import java.util.Date;
import java.util.Objects;

public class Transacao {
	
	private int id;
	
	private Conta conta;
	
	private Conta contaDestino;
	
	private Double valorTransacao;
	
	private Date dataTransacao;
	
	private String tipoTransacao;
	
	public Transacao () {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Conta getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(Conta contaDestino) {
		this.contaDestino = contaDestino;
	}

	public Double getValorTransacao() {
		return valorTransacao;
	}

	public void setValorTransacao(Double valorTransacao) {
		this.valorTransacao = valorTransacao;
	}

	public Date getDataTransacao() {
		return dataTransacao;
	}

	public void setDataTransacao(Date dataTransacao) {
		this.dataTransacao = dataTransacao;
	}

	public String getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(String tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(conta, contaDestino, dataTransacao, id, tipoTransacao, valorTransacao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transacao other = (Transacao) obj;
		return Objects.equals(conta, other.conta) && Objects.equals(contaDestino, other.contaDestino)
				&& Objects.equals(dataTransacao, other.dataTransacao) && id == other.id
				&& Objects.equals(tipoTransacao, other.tipoTransacao)
				&& Objects.equals(valorTransacao, other.valorTransacao);
	}

	@Override
	public String toString() {
		return "Transacao [id=" + id + ", conta=" + conta + ", contaDestino=" + contaDestino + ", valorTransacao="
				+ valorTransacao + ", dataTransacao=" + dataTransacao + ", tipoTransacao=" + tipoTransacao + "]";
	}
	
	

}
