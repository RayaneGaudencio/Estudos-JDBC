package br.com.loja.categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.loja.ConnectionFactory;
import br.com.loja.produto.Produto;
import br.com.loja.produto.ProdutoDAO;

public class TestaListagemCategoria {

	public static void main(String[] args) throws SQLException {

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			
			ProdutoDAO produtoDAO = new ProdutoDAO(connection);
			List<Produto> produtos = produtoDAO.buscarProdutoPorCategoria();
			
			produtos.stream().forEach(p -> System.out.println(p.getNome() + " - " + p.getCategoria().getNome()));
		}
	}
}
