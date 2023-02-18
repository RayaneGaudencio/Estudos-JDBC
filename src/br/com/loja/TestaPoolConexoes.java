package br.com.loja;

import java.sql.SQLException;

public class TestaPoolConexoes {
	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		for(int i = 0; i < 200; i++) {
			connectionFactory.recuperarConexao();
			System.out.println("Conexão de número " + i);
		}
		
	}
}
