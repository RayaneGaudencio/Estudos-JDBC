package br.com.loja;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {
	public static void main(String[] args) throws SQLException {
		
			ConnectionFactory conexao = new ConnectionFactory();
			Connection connection = conexao.recuperarConexao();
		
			Statement stm = connection.createStatement();
			stm.execute("SELECT NOME, PRECO, ID FROM PRODUTO");
			
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
 