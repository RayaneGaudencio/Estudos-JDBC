package br.com.loja.produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.loja.ConnectionFactory;
import br.com.loja.categoria.Categoria;

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
			
			try(ResultSet rst = pstm.getResultSet()) {
				while(rst.next()) {
					Produto produto = new Produto(rst.getInt(1), rst.getString(2), rst.getDouble(3));
					
					produtos.add(produto);
				}
			}
		}
		
		return produtos;
		}
	
	public List<Produto> buscarProdutoPorCategoria() throws SQLException {
		List <Produto> produtosECategorias = new ArrayList<>();
		String sql = "SELECT p.nome, p.preco, p.id, c.id, c.nome FROM produto p INNER JOIN categoria c WHERE p.categoria_id = c.id";
		
		try(PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.execute();
			
			try(ResultSet rst = pstm.getResultSet()) {
				while(rst.next()) {
					Produto produto = new Produto(rst.getString(1), rst.getDouble(2), rst.getInt(3), rst.getInt(4), rst.getString(5));
					
					produtosECategorias.add(produto);
				}
			}
		}
		return produtosECategorias;
	}
}
