package br.com.loja.produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.loja.ConnectionFactory;

public class ProdutoDAO {
	
	private Connection connection;
	
	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void salvarProduto(Produto produto) throws SQLException {
		
			String sql = "INSERT INTO PRODUTO (NOME, PRECO) VALUES (?, ?)";
			
			try(PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
				stm.setString(1, produto.getNome());
				stm.setDouble(2, produto.getPreco());
				
				stm.execute();

				System.out.println(produto.toString());
			}
		}
	
	public List<Produto> listar() throws SQLException {
		List<Produto> produtos = new ArrayList<>();
		
		String sql = "SELECT * FROM PRODUTO";
		
		try(PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.execute();
		}
		
		return produtos;
		}
}
