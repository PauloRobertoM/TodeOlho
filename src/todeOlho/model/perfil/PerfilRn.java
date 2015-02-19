package todeOlho.model.perfil;

import todeOlho.modelo.Usuario;

public class PerfilRn {
	private PerfilDAO perfilDAO = new PerfilDAO();
	
	public void salvarPerfilRn(Perfil perfil) {
		boolean salvou = perfilDAO.salvarUsuarioDao(perfil);
		if (salvou) {
			Usuario user = new Usuario();
			user = perfilDAO.autenticarUsuario(perfil.getLogin(), perfil.getSenha());
			perfil.setUsuario_id(user.getIdUsuario());
			perfilDAO.salvarPerfil(perfil);
		}
	}
}