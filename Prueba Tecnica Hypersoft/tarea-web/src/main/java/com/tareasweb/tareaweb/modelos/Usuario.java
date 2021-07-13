package com.tareasweb.tareaweb.modelos;

public class Usuario {
	private int Id_Usuario;
	private String Correo_Usr;
	private String Pass;
	
	public Usuario (int Id_Usuario,String Correo_Usr,String pass) {
		this.Id_Usuario=Id_Usuario;
		this.Correo_Usr=Correo_Usr;
		this.Pass=pass;
	}
	
	public void setId_Usuario(int Id_Usuario) {
		this.Id_Usuario=Id_Usuario;
	}
	public void setCorreo_Usr(String Correo_Usr) {
		this.Correo_Usr=Correo_Usr;
	}
	public void setPass(String Pass) {
		this.Pass=Pass;
	}
	public int getId_Usuario() {
		return this.Id_Usuario;
	}
	public String getCorreo_Usr() {
		return this.Correo_Usr;
	}
	public String getPass() {
		return this.Pass;
	}
	
}
