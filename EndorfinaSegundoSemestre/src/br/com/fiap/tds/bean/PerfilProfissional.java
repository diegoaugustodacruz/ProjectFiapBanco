package br.com.fiap.tds.bean;

import java.util.List;

public class PerfilProfissional extends Cadastro{
	
	private List<String> hobbies, conexoes;
	
	private String ResultadoBarraPesquisa;
	
	public PerfilProfissional() {
			
		}

	public PerfilProfissional(List<Integer> idCadastro, List<Integer> numero, List<String> nome, List<String> email,
			List<String> senha, List<String> dataNascimento, List<String> perfil, List<String> hobby,
			List<String> telefone, List<String> cidade, List<String> estado) {
		super(idCadastro, numero, nome, email, senha, dataNascimento, perfil, hobby, telefone, cidade, estado);
		// TODO Auto-generated constructor stub
	}


	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	public List<String> getConexoes() {
		return conexoes;
	}

	public void setConexoes(List<String> conexoes) {
		this.conexoes = conexoes;
	}

	public String getResultadoBarraPesquisa() {
		return ResultadoBarraPesquisa;
	}

	public void setResultadoBarraPesquisa(String resultadoBarraPesquisa) {
		ResultadoBarraPesquisa = resultadoBarraPesquisa;
	}

}
