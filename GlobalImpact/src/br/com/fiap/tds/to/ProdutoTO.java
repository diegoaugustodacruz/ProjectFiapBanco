package br.com.fiap.tds.to;

public class ProdutoTO {

	private int idProduto;
	
	private String nome;
	
	private int quantidade;
	
	private String dataCadastro;
	
	private String dataValidade;
	
	private double valorUnitario;
	
	private double valorTotal;
	
	public ProdutoTO() {
		
	}

	public ProdutoTO(int idProduto, String nome, int quantidade, String dataCadastro, String dataValidade,
			double valorUnitario, double valorTotal) {
		super();
		this.idProduto = idProduto;
		this.nome = nome;
		this.quantidade = quantidade;
		this.dataCadastro = dataCadastro;
		this.dataValidade = dataValidade;
		this.valorUnitario = valorUnitario;
		this.valorTotal = valorTotal;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Nome: " + nome + ", quantidade: " + quantidade + ", data validade: " + dataValidade + ", valor unitario:" + valorUnitario + ", valor total: " + valorTotal;
	}
}
