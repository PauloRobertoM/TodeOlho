package todeOlho.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import todeOlho.model.categoria.Categoria;
import todeOlho.model.categoria.CategoriaRn;

@ManagedBean
@RequestScoped
public class CategoriaMB implements Serializable{
	private static final long serialVersionUID = 1L;
	
	int codigoCategoria;
	private int idCategoria;
	private String nomeCategoria;
	private String descricaoCategoria;
	private Categoria categoria;
	CategoriaRn categoriaRn;
	private List<SelectItem> categoriaItens;
	private List<Categoria> categorias = new ArrayList<Categoria>();
	
	@PostConstruct
	public void init(){
		categoriaRn = new CategoriaRn();
		this.listarCategorias();
	}

	public CategoriaMB(){
		super();
	}

	public String criarCategoria() {
		categoriaRn = new CategoriaRn();	
		categoriaRn.salvarCategoria(nomeCategoria, descricaoCategoria);
		
		return null;
	}
	
	public void listarCategorias(){
		List<Categoria> categorias = new ArrayList<Categoria>();
		this.categoriaItens = new ArrayList<SelectItem>();
		categorias = categoriaRn.getCategorias();
		categoriaItens.add(new SelectItem(null, "Selecione"));
		
		for(Categoria categoria : categorias){
			categoriaItens.add(new SelectItem(categoria.getIdCategoria(),categoria.getNomeCategoria()));
		}	
	}
	
	public String excluirCategoria(int idCategoria) {
		categoriaRn.excluirCategoria(idCategoria);
		
		return "gerenciarCategoria.jsf?faces-redirect=true";
	}
	
	public String editAction(int idCategoria) {
		this.categoria = categoriaRn.getCategoria(idCategoria);
		this.nomeCategoria = categoriaRn.getCategoria(idCategoria).getNomeCategoria();
		this.descricaoCategoria = categoriaRn.getCategoria(idCategoria).getDescricaoCategoria();
		this.idCategoria = categoriaRn.getCategoria(idCategoria).getIdCategoria();
		
		return "editarCategoria.jsf";
	}
	
	public String alterar() {
		codigoCategoria =  Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id"));  
		
		categoriaRn.alterar(this.nomeCategoria, this.descricaoCategoria, codigoCategoria);
		
		return "gerenciarCategoria";
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<SelectItem> getCategoriaItens() {
		return categoriaItens;
	}

	public void setCategoriaItens(List<SelectItem> categoriaItens) {
		this.categoriaItens = categoriaItens;
	}
	
	public List<Categoria> getCategorias() {
		this.categorias =  categoriaRn.getCategorias();
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	public String getDescricaoCategoria() {
		return descricaoCategoria;
	}
	public void setDescricaoCategoria(String descricaoCategoria) {
		this.descricaoCategoria = descricaoCategoria;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

}
