package br.com.fiap.tds.view;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Exercicio02 {

	public static void main(String[] args) {
		
Connection conexao = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "rm86877", "050291");
			System.out.println("Conectado no banco \n");			
			Statement stmt = conexao.createStatement();			
			ResultSet rs = stmt.executeQuery("SELECT * FROM TB_ALUNO");
			
			FileWriter outputStream = new FileWriter("alunos.txt", true);
			PrintWriter arquivo = new PrintWriter(outputStream);

			
			while (rs.next()) { //equanto houver registro..
				//pega o valor da coluna e coloca numa variável
				Integer rm = rs.getInt("NR_RM");
				String nome = rs.getString("NM_ALUNO");
				boolean st = rs.getBoolean("ST_ATIVO");
				Integer nota1 = rs.getInt("VL_NOTA1");
				Integer nota2 = rs.getInt("VL_NOTA2");				
				
				boolean st2;
				
			

				arquivo.println(rm + ";" + nome + ";" + st + ";" + nota1 + ";" + nota2);				
			
			}
			
			outputStream.close();
			arquivo.close();
		} catch (Exception e) {
			e.printStackTrace(); //exibir a pilha de execucao
		}finally {
			if(conexao != null)
				try {
					conexao.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
	}
	
}
