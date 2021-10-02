package br.com.fiap.tds.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Exercicio01 {
	
	public static void main(String[] args) {
		Connection conexao = null;

		try{
			
			FileReader inputStream = new FileReader("alunos.csv");			
			BufferedReader reader = new BufferedReader(inputStream);			
			
			//BANCO
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "rm86877", "050291");
			System.out.println("Conectado no banco \n");
			Statement comando = conexao.createStatement();

			String linha;
			reader.readLine(); //le a primeira linha (titulo)
			
			while((linha = reader.readLine())!= null) {
				String[] valores = linha.split(";");
				String rm = valores[0];
				String nome = valores[1];
				String st = valores[2];
				String nota1 = valores[3];
				String nota2 = valores[4];	
				
				int linhasAfetadas = comando.executeUpdate("INSERT INTO TB_ALUNO "
						+ "(NR_RM, NM_ALUNO, ST_ATIVO, VL_NOTA1, VL_NOTA2) "
						+ "VALUES (" + rm + ", '" + nome + "', " + (st.equals("true")?1:0) + ", " + nota1 + ", " + nota2 + ")");
				System.out.println("Inserido");
			}
			
			inputStream.close();
			reader.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//Fechar
			
			if(conexao != null)
				try {
					conexao.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		
		
		
		
	}

}
