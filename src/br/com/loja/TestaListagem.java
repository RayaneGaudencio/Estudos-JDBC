package br.com.loja;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {
	public static void main(String[] args) throws SQLException {
		
			ConnectionFactory conexao = new ConnectionFactory();
			Connection connection = conexao.recuperarConexao();
		
			PreparedStatement stm = connection.prepareStatement("SELECT NOME, PRECO, ID FROM PRODUTO");
			stm.execute();
			
			ResultSet rst = stm.getResultSet();
			
			while(rst.next()) {
				int id = rst.getInt("id");
				System.out.println(id);
				
				String nome = rst.getString("nome");
				System.out.println(nome);
		
				double preco = rst.getDouble("preco");
				System.out.println(preco);
			}
			connection.close();
	}
}
 