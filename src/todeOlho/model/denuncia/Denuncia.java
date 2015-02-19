package todeOlho.model.denuncia;

import java.io.Serializable;
import java.util.Date;

import todeOlho.model.localizacao.Localizacao;
import todeOlho.modelo.Categoria;
import todeOlho.modelo.Usuario;

public class Denuncia implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int idDenuncia;
	private String descricaoDenuncia;
	private byte[] anexoDenuncia;
	private boolean statusDenuncia;
	private Date dataDenuncia;
	private Usuario usuarioDenuncia;
	private Categoria categoriaDenuncia;
	private Localizacao localizacaoDenuncia;
	
	public Denuncia() {
		super();
		usuarioDenuncia = new Usuario();
		categoriaDenuncia = new Categoria();
		localizacaoDenuncia = new Localizacao();
	}
	
//	public Denuncia(int idDenuncia, String descricaoDenuncia, byte[] anexoDenuncia,
//			boolean statusDenuncia, Usuario usuarioDenuncia,
//			Categoria categoriaDenuncia, Localizacao localizacaoDenuncia) {
//		super();
//		this.idDenuncia = idDenuncia;
//		this.descricaoDenuncia = descricaoDenuncia;
//		this.anexoDenuncia = anexoDenuncia;
//		this.statusDenuncia = statusDenuncia;
//		this.dataDenuncia = new Date();
//		this.usuarioDenuncia = usuarioDenuncia;
//		this.categoriaDenuncia = categoriaDenuncia;
//		this.localizacaoDenuncia = localizacaoDenuncia;
//	}

	public boolean isStatusDenuncia() {
		return statusDenuncia;
	}
	public void setStatusDenuncia(boolean statusDenuncia) {
		this.statusDenuncia = statusDenuncia;
	}
	public String getDescricaoDenuncia() {
		return descricaoDenuncia;
	}
	public void setDescricaoDenuncia(String descricaoDenuncia) {
		this.descricaoDenuncia = descricaoDenuncia;
	}
	public byte[] getAnexoDenuncia() {
		return anexoDenuncia;
	}
	public void setAnexoDenuncia(byte[] anexoDenuncia) {
		this.anexoDenuncia = anexoDenuncia;
	}
	public int getIdDenuncia() {
		return idDenuncia;
	}
	public void setIdDenuncia(int idDenuncia) {
		this.idDenuncia = idDenuncia;
	}
	public Date getDataDenuncia() {
		return dataDenuncia;
	}
	public void setDataDenuncia(Date dataDenuncia) {
		this.dataDenuncia = dataDenuncia;
	}
	public Usuario getUsuarioDenuncia() {
		return usuarioDenuncia;
	}
	public void setUsuarioDenuncia(Usuario usuarioDenuncia) {
		this.usuarioDenuncia = usuarioDenuncia;
	}
	public Categoria getCategoriaDenuncia() {
		return categoriaDenuncia;
	}
	public void setCategoriaDenuncia(Categoria categoriaDenuncia) {
		this.categoriaDenuncia = categoriaDenuncia;
	}
	public Localizacao getLocalizacaoDenuncia() {
		return localizacaoDenuncia;
	}
	public void setLocalizacaoDenuncia(Localizacao localizacaoDenuncia) {
		this.localizacaoDenuncia = localizacaoDenuncia;
	}
}
