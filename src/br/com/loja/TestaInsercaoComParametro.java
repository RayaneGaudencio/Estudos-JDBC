package br.com.loja;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {
		public static void main(String[] args) throws SQLException {
		
			ConnectionFactory factory = new ConnectionFactory();
			try(Connection connection = factory.recuperarConexao();) {
			
			connection.setAutoCommit(false); // não permite fazer o autoCommit
			
			try (PreparedStatement stm = 
					connection.prepareStatement("INSERT INTO PRODUTO (NOME, PRECO, CATEGORIA_ID) VALUES (?, ?, ?)" , Statement.RETURN_GENERATED_KEYS);) {
				
					adicionarVariavel("Teclado", 300, 1, stm);
					adicionarVariavel("Fogão", 1000, 2, stm);
					
					connection.commit(); // responsável por commitar caso a transação dê certo
					
			} catch(Exception e) { // a exception nesse caso é utilizada caso para fazer o rollback, não permitindo inconsistência 
				e.printStackTrace();
				System.out.println("Rollback executado.");
				connection.rollback();
			}
			}
		}

		private static void adicionarVariavel(String nome, double preco, int idCategoria, PreparedStatement stm)
				throws SQLException {
			stm.setString(1, nome);
			stm.setDouble(2, preco);		
			stm.setInt(3, idCategoria);
			stm.execute();
			
			if(nome.equals("fones")) {
				throw new RuntimeException("Não foi possível adicionar o produto.");
			}
			
			try(ResultSet rst = stm.getGeneratedKeys();) {
				while(rst.next()) {
					int id = rst.getInt(1);
					System.out.println("O id criado foi " + id);
				}				
			}
		}
}

