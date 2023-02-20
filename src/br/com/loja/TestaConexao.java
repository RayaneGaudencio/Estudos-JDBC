package br.com.loja;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {
	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory conexao = new ConnectionFactory();
		
		try(Connection connection = conexao.recuperarConexao();){
			System.out.println("Acessando conexão...");
		} catch (Exception e) {
			System.out.println("Não foi possível recuperar a conexão.");
		}
	}
}
