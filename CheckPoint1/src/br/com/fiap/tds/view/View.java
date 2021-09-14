package br.com.fiap.tds.view;

import javax.swing.JOptionPane;

import br.com.fiap.tds.bean.Produto;
import br.com.fiap.tds.dao.ProdutoDao;

public class View {
	
	public static void main(String[] args) {
		
		int opcao;
		
		ProdutoDao dao = new ProdutoDao();


		do {
			
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha: \n1-Cadastrar \n2-Listar \n3-Consultar por código"
					+ "\n4-Editar \n5-Remover \n6-Pesquisar por nome  \n7-Sair"));
			
			
			
			switch (opcao) {
				case 1:
					
					do {
						int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo para cadastro: "));
						String nomeProduto = JOptionPane.showInputDialog("Digite o nome do produto: ");
						double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do produto"));
						int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade do produto: "));
						
						dao.cadastrar(codigo, nomeProduto, valor, quantidade);						
						
					}while(JOptionPane.showConfirmDialog(null, "Quer continuar cadastrando?") == JOptionPane.YES_OPTION);					
					
					
					break;
					
				case 2:
					System.out.println(dao.listar());
					
					break;
				
				case 3:
					int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo para consulta: "));
					System.out.println(dao.pesquisarPorCodigo(codigo));

					//JOptionPane.showMessageDialog(null, dao.pesquisarPorCodigo(codigo));
					break;
					
				case 4:
					codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do produto para editar seus valores: "));
					String nomeProduto = JOptionPane.showInputDialog("Digite o nome do produto: ");
					double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do produto"));
					int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade do produto: "));
					
					dao.editar(codigo, nomeProduto, valor, quantidade);
					
					break;
					
				case 5:
					codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do produto para remove-lo: "));
					dao.remover(codigo);
					break;
					
				case 6:
					System.out.println("Finalizando o sistema");
					break;

				case 7:
					System.out.println("Finalizando o sistema");
					break;
					
				default:
					break;
			}
			
			
		}while(opcao!=7);

	}
	

	
	
	
}
