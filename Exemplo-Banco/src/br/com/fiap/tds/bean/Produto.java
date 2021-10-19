package br.com.fiap.tds.bean;

/**
 * Classe que representa um Produto e a tabela TDSS_TB_PRODUTO
 * @author Thiago Yamamoto
 */
public class Produto {

	private int codigo;
	
	private String nome;
	
	private String descricao;
	
	private double valor;
	
	private String nomeFornecedor;
	
	private Categoria categoria;
	
	//private int codigoCategoria;
	
	public Produto() {}

	public Produto(int codigo, String nome, String descricao, double valor, String nomeFornecedor) {
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
		this.nomeFornecedor = nomeFornecedor;
	}
	
	public Produto(int codigo, String nome, String descricao, double valor, String nomeFornecedor, Categoria categoria) {
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
		this.nomeFornecedor = nomeFornecedor;
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Código: " + codigo + ", nome: " + nome + ", descrição: " + descricao + ", valor: " + valor + 
				", fornecedor: " + nomeFornecedor; 
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getNomeFornecedor() {
		return nomeFornecedor;
	}

	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

//	public int getCodigoCategoria() {
//		return codigoCategoria;
//	}
//
//	public void setCodigoCategoria(int codigoCategoria) {
//		this.codigoCategoria = codigoCategoria;
//	}
	
}