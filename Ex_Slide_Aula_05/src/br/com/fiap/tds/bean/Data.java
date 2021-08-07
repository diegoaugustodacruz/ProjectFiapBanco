package br.com.fiap.tds.bean;

public class Data {

	private int dia, mes, ano;
	
	//Método que retorna a data no formado dd/mm/aaa
	public String retornarData() {
		return dia + "/" + mes + "/" + ano;
				
	}
	
	
	//Crie um método para validar o dia. Ele deve estar entre 1 e 31. Caso contrário inicializar o atributo com o valor 1;
	private int validarDia(int dia) {
		// > (maior, < (menor, >= (maior ou igual), <= (menor ou igual)
		// == (igual), != (diferente), && (e), || (ou), ! (negacao)
		if(dia>=1 && dia<=31) {
			return dia;			
		} 
		
		else {
			return 1;
		}
				
	}
	
	private int validarMes(int mes) {
		if(mes>=1 && mes<=12) {
			return mes;			
		}	
		else{
			return 1;
		}
		
	}
	
	private int validarAno(int ano) {
		if(ano>0) 
			return ano;
		else 
			return 2020;
		
				
	}
	
	//Crie um método que retorne o nome do mês de acordo com o número que esta armazenado no atributo nome;
	public String retornarMes() {
		if(mes==1) 
			return "Janeiro";
		else if(mes==2) 
			return "Fevereiro";
		else if(mes==3) 
			return "Março";
		else if(mes==4)
			return "Abril";
		else if(mes==5)
			return "Maio";
		else if(mes==6)
			return "Junho";
		else if(mes==7)
			return "Julho";
		else if(mes==8)
			return "Agosto";
		else if(mes==9)
			return "Setembro";
		else if(mes==10)
			return "Outubro";
		else if(mes==11)
			return "Novembro";
		return "Dezembro";
		 	
	}
	
	public int getDia() {
		return dia;
	}




	public void setDia(int dia) {
		this.dia = validarDia(dia);
	}




	public int getMes() {
		return mes;
	}




	public void setMes(int mes) {
		this.mes = validarMes(mes);
	}




	public int getAno() {
		return ano;
	}




	public void setAno(int ano) {
		this.ano = validarAno(ano);
	}




	
	
	
	
	
}
