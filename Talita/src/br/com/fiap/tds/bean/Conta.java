package br.com.fiap.tds.bean;

import java.util.Date;
import java.util.Objects;

public class Conta {
	
	private int id;
	
	private Usuario usuario;
	
	private Double valorSaldo;
	
	private String status;
	
	private Date dataAbertura;
	
	private Date dataEncerramento;
	
	public Conta() {}

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

	public Double getValorSaldo() {
		return valorSaldo;
	}

	public void setValorSaldo(Double valorSaldo) {
		this.valorSaldo = valorSaldo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Date getDataEncerramento() {
		return dataEncerramento;
	}

	public void setDataEncerramento(Date dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataAbertura, dataEncerramento, id, status, usuario, valorSaldo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return Objects.equals(dataAbertura, other.dataAbertura)
				&& Objects.equals(dataEncerramento, other.dataEncerramento) && id == other.id
				&& Objects.equals(status, other.status) && Objects.equals(usuario, other.usuario)
				&& Objects.equals(valorSaldo, other.valorSaldo);
	}

	@Override
	public String toString() {
		return "Conta [id=" + id + ", usuario=" + usuario + ", valorSaldo=" + valorSaldo + ", status=" + status
				+ ", dataAbertura=" + dataAbertura + ", dataEncerramento=" + dataEncerramento + "]";
	}
	
	

}
