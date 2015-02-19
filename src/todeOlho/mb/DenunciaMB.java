package todeOlho.mb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.UploadedFile;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.MapModel;

import todeOlho.model.denuncia.Denuncia;
import todeOlho.model.denuncia.DenunciaRn;

@ManagedBean
@RequestScoped
public class DenunciaMB implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Denuncia denuncia;
	private MapModel mapa;
	private UploadedFile anexoDenuncia;
	double latitude, longitude;
	
	@PostConstruct
	public void init(){
		denuncia = new Denuncia();
		mapa = new DefaultMapModel();
	}

	public String criarDenuncia() {
		DenunciaRn denunciaRn = new DenunciaRn();
		System.out.println(latitude + ", "+ longitude);
		denunciaRn.salvarDenuncia(this.denuncia, anexoDenuncia);
		return null;
	}
	
	public Denuncia getDenuncia() {
		return denuncia;
	}
	public void setDenuncia(Denuncia denuncia) {
		this.denuncia = denuncia;
	}
	public MapModel getMapa() {
		return mapa;
	}

	public void setMapa(MapModel mapa) {
		this.mapa = mapa;
	}

	public UploadedFile getAnexoDenuncia() {
		return anexoDenuncia;
	}

	public void setAnexoDenuncia(UploadedFile anexoDenuncia) {
		this.anexoDenuncia = anexoDenuncia;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	
}
