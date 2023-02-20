package br.com.loja.categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
	
	private Connection connection;

	public CategoriaDAO(Connection connection) {
		this.connection = connection;
	}
	
	public List<Categoria> listar() throws SQLException {
		List<Categoria> categorias = new ArrayList<>();
		
		 PreparedStatement pstm = connection.prepareStatement("SELECT * FROM CATEGORIA");
		 pstm.execute();
		 
		 ResultSet rst = pstm.getResultSet();
		 
		 while(rst.next()) {
			 int id = rst.getInt("id");
			 System.out.println(id);
			 
			 String nome = rst.getString("nome");
			 System.out.println(nome);
		 }
		return categorias;
	}
}
