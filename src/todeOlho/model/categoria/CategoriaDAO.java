package todeOlho.model.categoria;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import todeOlho.util.DaoPai;

import com.mysql.jdbc.PreparedStatement;

public class CategoriaDAO extends DaoPai{
	public CategoriaDAO() {
		super();
	}

	public List<Categoria> getCategorias(){
		conectar();
		ResultSet rs;  
		try {  
			rs = getComando().executeQuery("SELECT * FROM Categoria");
			List<Categoria> categorias = new ArrayList<Categoria>();
			while (rs.next()) {  
				// pega todos os atributos da categoria
				Categoria cat = new Categoria();
				cat.setIdCategoria(rs.getInt("idCategoria"));
				cat.setNomeCategoria(rs.getString("nomeCategoria"));
				cat.setDescricaoCategoria(rs.getString("descricaoCategoria"));
				
				categorias.add(cat);
			}
			return categorias;
		} catch (SQLException e) {
			System.out.println(e.getMessage()); 
		}
		return null;
	}

	public Categoria getCategoria(Integer codigo){
		conectar();
		ResultSet rs;  
		try {  
			String sql = "SELECT * FROM Categoria WHERE idCategoria = "+codigo;
			rs = getComando().executeQuery(sql);
			
			Categoria categoria = new Categoria();
			
			System.out.println("retornou uma categoria "+sql);
			while (rs.next()) {  
				categoria = new Categoria();
				categoria.setIdCategoria(rs.getInt("idCategoria"));
				categoria.setNomeCategoria(rs.getString("nomeCategoria"));
				categoria.setDescricaoCategoria(rs.getString("descricaoCategoria"));
			}
			return categoria;
		} catch (SQLException e) {
			System.out.println(e.getMessage()); 
		}
		return null;
	}
/*
	public void salvarCategoria(Categoria categoria) throws SQLException {
		conectar();
		try {
			String sql = "INSERT INTO Categoria (nomeCategoria, descricaoCategoria) VALUES(?,?)";

			System.out.println("metodo salvar de Categoria SQL: "+sql);
			
			PreparedStatement stmt = (PreparedStatement) getCon().prepareStatement(sql);

			stmt.setString(1, categoria.getNomeCategoria());
			stmt.setString(2, categoria.getDescricaoCategoria());

			stmt.execute();

		} catch (SQLException e) {
			throw new SQLException(e.getMessage()); 
		}
	}
*/
	public void excluirCategoria(int idCategoria) {
		conectar();
		try{
			String sql = "DELETE FROM Categoria WHERE idCategoria = ?";

			PreparedStatement stmt = (PreparedStatement) getCon().prepareStatement(sql);

			stmt.setInt(1, idCategoria);

			stmt.execute();
			stmt.close();
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}

	public void editarCategoria(String nomeCategoria, String descricaoCategoria, int idCategoria) {
		conectar();
		try{
			String sql = "UPDATE Categoria SET nomeCategoria=?, descricaoCategoria=? WHERE idCategoria=?";

			System.out.println(sql);
			
			PreparedStatement stmt = (PreparedStatement) getCon().prepareStatement(sql);
			
			stmt.setString(1, nomeCategoria);
			stmt.setString(2, descricaoCategoria);
			stmt.setInt(3, idCategoria);

			stmt.execute();
			stmt.close();
		}
		catch(SQLException e){
			System.out.println(e.getMessage()); 
		}	
	}

	public void salvarCategoria(String nomeCategoria, String descricaoCategoria) {
		conectar();
		try {
			String sql = "INSERT INTO Categoria (nomeCategoria, descricaoCategoria) VALUES(?,?)";

			System.out.println("metodo salvar de Categoria SQL: "+sql);
			
			PreparedStatement stmt = (PreparedStatement) getCon().prepareStatement(sql);

			stmt.setString(1, nomeCategoria);
			stmt.setString(2, descricaoCategoria);

			stmt.execute();

		} catch (SQLException e) {
			System.out.println(e.getMessage()); 
		}
	}
}
