package br.com.fiap.tdss.bean;
/**
 * Essa classe representa a conta
 * @author Diego
 *
 */
public class Conta {
	/**
	 * numero da agencia
	 */
	private int agencia;
	/**
	 * Numero da conta
	 */
	private String numero;
	/**
	 * Saldo da conta
	 */
	protected double saldo;
	
	/**
	 * Inicializa o objeto com valores padrão
	 */
	public Conta() {
		
	}
	
	/**
	 * 
	 * @param agencia numero da agencia
	 * @param numero numero da conta
	 * @param saldo saldo da conta
	 */
	public Conta(int agencia, String numero, double saldo) {
		super();
		this.agencia = agencia;
		this.numero = numero;
		this.saldo = saldo;
	}
	
	/**
	 * 
	 * @param agencia numero da agencia
	 * @param numero numero da conta
	 */
	public Conta(int agencia, String numero) {
		super();
		this.agencia = agencia;
		this.numero = numero;
	}
	
	/**
	 * Retorna o numero da agencia
	 * @return numero da agencia
	 */
	public int getAgencia() {
		return agencia;
	}

	/**
	 * Altera o numero da agencia
	 * @param agencia numero da agencia
	 */
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	
	/**
	 * Retorna o numero da conta
	 * @return numero da conta
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * Altera o numero da conta
	 * @param numero numero da conta
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * Retorna o saldo da conta
	 * @return saldo da conta
	 */
	public double getSaldo() {
		return saldo;
	}
	
	/**
	 * Altera o saldo da conta
	 * @param saldo saldo da conta da conta
	 */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

		

}
