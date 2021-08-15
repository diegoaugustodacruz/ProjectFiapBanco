package br.com.fiap.tdss.bean;
/**
 * Essa classe representa a conta corrente
 * @author Diego
 *
 */
public class ContaCorrente extends Conta{
	/**
	 * limite da conta
	 */
	private double limite;
	
	/**
	 * Inicializa o objeto com valores padrão
	 */
	public ContaCorrente() {
		
	}
	/**
	 * Inicia a conta corrente com os valores de agencia, numero e limite da conta
	 * @param agencia numero da agencia
	 * @param numero numero da conta
	 * @param limite limite da conta
	 */
	public ContaCorrente(int agencia, String numero, double limite) {
		super(agencia, numero);
		this.limite = limite;
	}

	/**
	 * Retorna o limite da conta
	 * @return limite da conta
	 */
	public double getLimite() {
		return limite;
	}
	/**
	 * Altera o limite da conta
	 * @param limite limite da conta
	 */
	public void setLimite(double limite) {
		this.limite = limite;
	}
	
	public double exibirSaldoTotal() {
		return saldo + limite;
		
	}
	
	
	
}
