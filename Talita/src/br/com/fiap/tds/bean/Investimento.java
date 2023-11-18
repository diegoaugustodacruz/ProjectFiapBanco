package br.com.fiap.tds.bean;

import java.util.Date;
import java.util.Objects;

public class Investimento {
	
	private int id;
	
	private Usuario usuario;
	
	private String statusInvestimento;
	
	private Double valorInvestido;
	
	private Double valorTaxaJuros;
	
	private Date dataInicioInvestimento;
	
	private Date dataFimInvestimento;
	
	public Investimento() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getStatusInvestimento() {
		return statusInvestimento;
	}

	public void setStatusInvestimento(String statusInvestimento) {
		this.statusInvestimento = statusInvestimento;
	}

	public Double getValorInvestido() {
		return valorInvestido;
	}

	public void setValorInvestido(Double valorInvestido) {
		this.valorInvestido = valorInvestido;
	}

	public Double getValorTaxaJuros() {
		return valorTaxaJuros;
	}

	public void setValorTaxaJuros(Double valorTaxaJuros) {
		this.valorTaxaJuros = valorTaxaJuros;
	}

	public Date getDataInicioInvestimento() {
		return dataInicioInvestimento;
	}

	public void setDataInicioInvestimento(Date dataInicioInvestimento) {
		this.dataInicioInvestimento = dataInicioInvestimento;
	}

	public Date getDataFimInvestimento() {
		return dataFimInvestimento;
	}

	public void setDataFimInvestimento(Date dataFimInvestimento) {
		this.dataFimInvestimento = dataFimInvestimento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataFimInvestimento, dataInicioInvestimento, id, statusInvestimento, usuario,
				valorInvestido, valorTaxaJuros);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Investimento other = (Investimento) obj;
		return Objects.equals(dataFimInvestimento, other.dataFimInvestimento)
				&& Objects.equals(dataInicioInvestimento, other.dataInicioInvestimento) && id == other.id
				&& Objects.equals(statusInvestimento, other.statusInvestimento)
				&& Objects.equals(usuario, other.usuario) && Objects.equals(valorInvestido, other.valorInvestido)
				&& Objects.equals(valorTaxaJuros, other.valorTaxaJuros);
	}

	@Override
	public String toString() {
		return "Investimento [id=" + id + ", usuario=" + usuario + ", statusInvestimento=" + statusInvestimento
				+ ", valorInvestido=" + valorInvestido + ", valorTaxaJuros=" + valorTaxaJuros
				+ ", dataInicioInvestimento=" + dataInicioInvestimento + ", dataFimInvestimento=" + dataFimInvestimento
				+ "]";
	}
	
	
	

}
