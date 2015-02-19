package todeOlho.mb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import todeOlho.model.perfil.Perfil;
import todeOlho.model.perfil.PerfilRn;

@ManagedBean
@RequestScoped
public class PerfilMB implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Perfil perfil;
	
	@PostConstruct
	public void init(){
		perfil = new Perfil();
	}
	
	public String salvarPerfil() {
		PerfilRn perfilRn = new PerfilRn();
		perfilRn.salvarPerfilRn(perfil);
		return null;
	}

	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
}