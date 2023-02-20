package br.com.loja;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {
	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();
		
		try(PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUTO (NOME, PRECO) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);) {
			stm.setString(1, "FONES DE OUVIDO");
			stm.setDouble(2, 200);
			stm.execute();
			try(ResultSet rst = stm.getGeneratedKeys();) {
				while(rst.next()) {
					int id = rst.getInt(1);
					System.out.println("O id criado foi " + id);
				}				
			}
		}
	}
}
