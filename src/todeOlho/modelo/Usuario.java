package todeOlho.modelo;

public class Usuario {
	
	private int idUsuario;
	private String loginUsuario;
	private String senhaUsuario;
	
	public Usuario() {
		super();
	}
	
	public Usuario(int idUsuario, String loginUsuario, String senhaUsuario) {
		super();
		this.idUsuario = idUsuario;
		this.loginUsuario = loginUsuario;
		this.senhaUsuario = senhaUsuario;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getLoginUsuario() {
		return loginUsuario;
	}
	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}
	public String getSenhaUsuario() {
		return senhaUsuario;
	}
	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}
}
