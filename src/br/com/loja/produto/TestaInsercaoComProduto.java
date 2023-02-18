package br.com.loja.produto;

import java.sql.Connection;
import java.sql.SQLException;
import br.com.loja.ConnectionFactory;

public class TestaInsercaoComProduto {
	
	public static void main(String[] args) throws SQLException {
		
		Produto tablet = new Produto("Tablet", 400);
		
		try(Connection connection = new ConnectionFactory().recuperarConexao()) {
			ProdutoDAO produtoDAO = new ProdutoDAO(connection);
			produtoDAO.salvarProduto(tablet);
		}
	}
}
