package br.com.loja;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {
	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory conexao = new ConnectionFactory();
		Connection connection = conexao.recuperarConexao();
		
		connection.close();
	}
}
