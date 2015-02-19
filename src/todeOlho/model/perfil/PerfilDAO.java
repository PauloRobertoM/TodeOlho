package todeOlho.model.perfil;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import todeOlho.modelo.Usuario;
import todeOlho.util.DaoPai;

public class PerfilDAO extends DaoPai{

	public boolean salvarUsuarioDao(Perfil perfil) {
		conectar();
        try {
            String sql = "INSERT INTO Usuario (login, senha) VALUES(?,?)";
            
            System.out.println("metodo salvar de PERFIL DAO SQL - PERFIL DAO: "+sql);
            
            PreparedStatement stmt = (PreparedStatement) getCon().prepareStatement(sql);
            
            stmt.setString(1, perfil.getLogin());
            stmt.setString(2, perfil.getSenha());
            
            stmt.execute();
            return true;
            
        } catch (SQLException e) {
        	imprimeErro("Erro ao cadastrar usuario", e.getMessage());  
        }
		return false;
    }
	
	public void salvarPerfil(Perfil perfil) {
		conectar();
        try {
            String sql = "INSERT INTO Perfil (tipoPerfil, status, nome, email, senha, cpf, "
            		+ "cnpj, descricao, dataNascimento, imagem, Usuario_id)"
                    +" VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            
            System.out.println("metodo salvar dentro de PerfilDAO sql: "+sql);
            
            PreparedStatement stmt = (PreparedStatement) getCon().prepareStatement(sql);
          
            stmt.setInt(1, perfil.getTipoPerfil());
            stmt.setBoolean(2, true);
            stmt.setString(3, perfil.getNome());
            stmt.setString(4, perfil.getEmail());
            stmt.setString(5, perfil.getSenha());
            stmt.setString(6, perfil.getCpf());
            stmt.setString(7, perfil.getCnpj());
            stmt.setString(8, perfil.getDescricao());
            stmt.setDate(9, (Date) perfil.getDataNascimento());
            stmt.setString(10, perfil.getImagem());
            stmt.setInt(11, perfil.getUsuario_id());
            
            stmt.execute();
            
        } catch (SQLException e) {
        	imprimeErro("Erro ao cadastrar perfil", e.getMessage());  
        }
    }
	
	public Usuario autenticarUsuario(String login, String senha) {  
		conectar();
		ResultSet rs;
		Usuario usr = null;
		try {
			PreparedStatement ps = getCon().prepareStatement("SELECT * FROM Usuario WHERE login=? and senha=?");
			ps.setString(1, login);
			ps.setString(2, senha);
			rs = ps.executeQuery();
			while (rs.next()) {  
				// pega todos os atributos da postagem
				usr = new Usuario();
				usr.setIdUsuario(rs.getInt("idUsuario"));
				usr.setLoginUsuario(rs.getString("login"));
				usr.setSenhaUsuario(rs.getString("senha"));
			}
		} catch (SQLException e) {  
			imprimeErro("Erro ao buscar usuario", e.getMessage());  
		}
		return usr;
	} 
}