package br.com.fiap.tds.bean;

public class Funcionario {
	
	private int codigo;
	private String nome;
	private String cpf;
	private String dataNascimento;
	private String estadoCivil;
	private double salario;
	private String dataAdmissao;
	private Departamento departamento;
	
	public Funcionario() {
		
	}

	public Funcionario(int codigo, String nome, String cpf, String dataNascimento, String estadoCivil, double salario,
			String dataAdmissao, Departamento departamento) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.estadoCivil = estadoCivil;
		this.salario = salario;
		this.dataAdmissao = dataAdmissao;
		this.departamento = departamento;
	}	
	
	

	public Funcionario(int codigo, String nome, String cpf, String dataNascimento, String estadoCivil, double salario,
			String dataAdmissao) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.estadoCivil = estadoCivil;
		this.salario = salario;
		this.dataAdmissao = dataAdmissao;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(String dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	
	
}
