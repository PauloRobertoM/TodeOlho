package todeOlho.model.denuncia;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import todeOlho.util.DaoPai;

public class DenunciaDAO extends DaoPai{

	public void salvarDenuncia(Denuncia denuncia) throws SQLException {
		conectar();
        try {
            String sql = "INSERT INTO Denuncia (statusDenuncia, anexoDenuncia, descricaoDenuncia, dataDenuncia, "
            		+ "Categoria_id, Localizacao_id, Usuario_id) VALUES(?,?,?,?,?,?,?)";
            
            System.out.println("metodo salvar de Denuncia SQL: "+sql);
            
            PreparedStatement stmt = (PreparedStatement) getCon().prepareStatement(sql);
          
            stmt.setInt(1, 1);
            stmt.setBytes(2,denuncia.getAnexoDenuncia());
            stmt.setString(3,denuncia.getDescricaoDenuncia());
            java.util.Date data = new java.util.Date();
			stmt.setDate(4, new Date(data.getTime()));
			stmt.setInt(5, 1); /* setar categoria */
			stmt.setInt(6, denuncia.getLocalizacaoDenuncia().getIdLocalizacao());
			stmt.setInt(7, 1); /* setar usuario */
            
            stmt.execute();
            
        } catch (SQLException e) {
        	throw new SQLException(e.getMessage()); 
        }
	}
	
	
	
}