package todeOlho.model.categoria;

import java.util.List;

public class CategoriaRn {

	private CategoriaDAO categoriaDAO = new CategoriaDAO();
	
	public void salvarCategoria(String nomeCategoria, String descricaoCategoria) {
		categoriaDAO.salvarCategoria(nomeCategoria, descricaoCategoria);
	}

	public List<Categoria> getCategorias(){
		return categoriaDAO.getCategorias();
	}

	public void excluirCategoria(int idCategoria) {
		categoriaDAO.excluirCategoria(idCategoria);
	}

	public Categoria getCategoria(int idCategoria) {
		return categoriaDAO.getCategoria(idCategoria);
	}

	public void alterar(String nomeCategoria, String descricaoCategoria, int idCategoria) {
		categoriaDAO.editarCategoria(nomeCategoria, descricaoCategoria, idCategoria);
	}

}
