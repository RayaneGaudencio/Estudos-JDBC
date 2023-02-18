import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.loja.ConnectionFactory;
import modelo.Produto;

public class TestaInsercaoComProduto {
	
	public static void main(String[] args) throws SQLException {
		
		Produto tablet = new Produto("Tablet", 400);
		
		try(Connection conn = new ConnectionFactory().recuperarConexao()) {
			String sql = "INSERT INTO PRODUTO (NOME, PRECO) VALUES (?, ?)";
			
			try(PreparedStatement stm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
				stm.setString(1, tablet.getNome());
				stm.setDouble(2, tablet.getPreco());
				
				stm.execute();
				try(ResultSet rst = stm.getGeneratedKeys()) {
					while(rst.next()) {
						tablet.setId(rst.getInt(1));
					}
				}
				System.out.println(tablet.toString());
			}
		}
	}
}
