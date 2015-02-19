package todeOlho.model.localizacao;

public class Localizacao {
	
	private int idLocalizacao;
	private double longitude;
	private double latitude;

	public Localizacao() {
		super();
	}
	
//	public Localizacao(int idLocalizacao, double longitude,	double latitude) {
//		super();
//		this.idLocalizacao = idLocalizacao;
//		this.longitude = longitude;
//		this.latitude = latitude;
//	}
	
	public int getIdLocalizacao() {
		return idLocalizacao;
	}
	public void setIdLocalizacao(int idLocalizacao) {
		this.idLocalizacao = idLocalizacao;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
}
