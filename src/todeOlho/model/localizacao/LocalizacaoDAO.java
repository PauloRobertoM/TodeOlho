package todeOlho.model.localizacao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import todeOlho.util.DaoPai;

public class LocalizacaoDAO extends DaoPai{

	public void salvarLocalizacao(double latitude, double longitude) throws SQLException{
		conectar();
        try {
            String sql = "INSERT INTO Localizacao (latitude,longitude) VALUES(?,?)";
            
            System.out.println("metodo salvar de Localizacao SQL: "+sql);
            System.out.println("Parametros de Localizacao: "+
            					latitude + ", "+ longitude);
            
            PreparedStatement stmt = (PreparedStatement) getCon().prepareStatement(sql);
          
            stmt.setDouble(1, latitude);
            stmt.setDouble(2, longitude);
            
            stmt.execute();
            
        } catch (SQLException e) {
        	throw new SQLException(e.getMessage()); 
        }
    }
	
	public Localizacao buscarLocalizacao(double latitude, double longitude) throws SQLException{
		conectar();
		ResultSet rs;
		Localizacao localizacao = null;
		try {
			
			String sql = "SELECT * FROM Localizacao WHERE latitude = " + latitude +
															" AND longitude = " + longitude;
			
			System.out.println("metodo getLocalizacao sql: "+sql);
			
			rs = getComando().executeQuery(sql);
			while (rs.next()) {  
				// pega todos os atributos os comentarios
				localizacao = new Localizacao();
				localizacao.setIdLocalizacao(rs.getInt("idLocalizacao"));
				localizacao.setLatitude(rs.getDouble("latitude"));
				localizacao.setLongitude(rs.getDouble("longitude")); 
			}
			return localizacao;
		} catch (SQLException e) {
			throw new SQLException(e.getMessage()); 
		}
	}
}
