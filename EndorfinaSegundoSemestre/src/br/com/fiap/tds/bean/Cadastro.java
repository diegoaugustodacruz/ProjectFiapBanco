package br.com.fiap.tds.bean;

import java.util.List;

public class Cadastro {
	
	protected List<Integer> idCadastro, numero;

	
	protected List<String> nome, email, senha, dataNascimento, perfil, hobby, telefone, cidade, estado;
	
	public Cadastro(){
		
	}

	public Cadastro(List<Integer> idCadastro, List<Integer> numero, List<String> nome, List<String> email,
			List<String> senha, List<String> dataNascimento, List<String> perfil, List<String> hobby,
			List<String> telefone, List<String> cidade, List<String> estado) {
		super();
		this.idCadastro = idCadastro;
		this.numero = numero;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.dataNascimento = dataNascimento;
		this.perfil = perfil;
		this.hobby = hobby;
		this.telefone = telefone;
		this.cidade = cidade;
		this.estado = estado;
	}

	public List<Integer> getIdCadastro() {
		return idCadastro;
	}

	public void setIdCadastro(List<Integer> idCadastro) {
		this.idCadastro = idCadastro;
	}

	public List<Integer> getNumero() {
		return numero;
	}

	public void setNumero(List<Integer> numero) {
		this.numero = numero;
	}

	public List<String> getNome() {
		return nome;
	}

	public void setNome(List<String> nome) {
		this.nome = nome;
	}

	public List<String> getEmail() {
		return email;
	}

	public void setEmail(List<String> email) {
		this.email = email;
	}

	public List<String> getSenha() {
		return senha;
	}

	public void setSenha(List<String> senha) {
		this.senha = senha;
	}

	public List<String> getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(List<String> dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<String> getPerfil() {
		return perfil;
	}

	public void setPerfil(List<String> perfil) {
		this.perfil = perfil;
	}

	public List<String> getHobby() {
		return hobby;
	}

	public void setHobby(List<String> hobby) {
		this.hobby = hobby;
	}

	public List<String> getTelefone() {
		return telefone;
	}

	public void setTelefone(List<String> telefone) {
		this.telefone = telefone;
	}

	public List<String> getCidade() {
		return cidade;
	}

	public void setCidade(List<String> cidade) {
		this.cidade = cidade;
	}

	public List<String> getEstado() {
		return estado;
	}

	public void setEstado(List<String> estado) {
		this.estado = estado;
	}

	
	
	

	
	
	

}
