package br.com.loja;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {
		public static void main(String[] args) throws SQLException {
			
			ConnectionFactory factory = new ConnectionFactory();
			Connection connection = factory.recuperarConexao();
			
			String nome = "MOUSE); delete from produto";
			double preco = 99;
			
			PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUTO (NOME, PRECO) VALUES (?, ?)" , Statement.RETURN_GENERATED_KEYS);
			
			ResultSet rst = adicionarVariavel(nome, preco, stm);
			
			while(rst.next()) {
				int id = rst.getInt(1);
				System.out.println("O id criado foi " + id);
			}
			connection.close();
		}

		private static ResultSet adicionarVariavel(String nome, double preco, PreparedStatement stm)
				throws SQLException {
			stm.setString(1, nome);
			stm.setDouble(2, preco);		
			stm.execute();

			ResultSet rst = stm.getGeneratedKeys();
			return rst;
		}
}