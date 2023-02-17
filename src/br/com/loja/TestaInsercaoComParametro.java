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
			connection.setAutoCommit(false); // não permite fazer o autoCommit
			
			try {
				PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUTO (NOME, PRECO) VALUES (?, ?)" , Statement.RETURN_GENERATED_KEYS);
				
				adicionarVariavel("Teclado", 300, stm);
				adicionarVariavel("fones", 200, stm);
				
				connection.commit(); // responsável por commitar caso a transação dê certo
				
				connection.close();
				
				stm.close();				
			} catch(Exception e) { // a exception nesse caso é utilizada caso para fazer o rollback, não permitindo inconsistência 
				e.printStackTrace();
				System.out.println("Rollback executado.");
				connection.rollback();
			}
		}

		private static void adicionarVariavel(String nome, double preco, PreparedStatement stm)
				throws SQLException {
			stm.setString(1, nome);
			stm.setDouble(2, preco);		
			stm.execute();
			
			if(nome.equals("fones")) {
				throw new RuntimeException("Não foi possível adicionar o produto.");
			}
			ResultSet rst = stm.getGeneratedKeys();
			while(rst.next()) {
				int id = rst.getInt(1);
				System.out.println("O id criado foi " + id);
			}
			rst.close();;
		}
}

