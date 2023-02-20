package br.com.loja.produto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.loja.ConnectionFactory;

public class TestaInsercaoEListagemComProduto {
	
	public static void main(String[] args) throws SQLException {
		
		Produto tablet = new Produto("Tablet", 400);
		Produto notebook = new Produto("Notebook Dell", 4000);
		
		try(Connection connection = new ConnectionFactory().recuperarConexao()) {
			ProdutoDAO produtoDAO = new ProdutoDAO(connection);
			
		 	produtoDAO.salvarProduto(tablet); 
		 	produtoDAO.salvarProduto(notebook);
			 		
			List<Produto> listaDeProdutos = produtoDAO.listar();
			listaDeProdutos.stream().forEach(lp -> System.out.println(lp));
		}
	}
}
