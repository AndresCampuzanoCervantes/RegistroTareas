package com.tareasweb.tareaweb.modelos;

public class Tarea {
	
	private int id_tr;
	private String Tipo_Tr;
	private String Descripcion_Tr;
	private String Prioridad_Tr;
	
	public Tarea (int id_tr, String Tipo_Tr, String Descripcion_Tr, String Prioridad_Tr) {
		this.id_tr=id_tr;
		this.Tipo_Tr=Tipo_Tr;
		this.Descripcion_Tr=Descripcion_Tr;
		this.Prioridad_Tr=Prioridad_Tr;
	}
	
	public int getId_tr() {
		return this.id_tr;
	}
	
	public String getTipo_Tr() {
		return this.Tipo_Tr;
	}
	
	public String getDescripcion_Tr() {
		return this.Descripcion_Tr;
	}
	
	public String getPrioridad_Tr() {
		return this.Prioridad_Tr;
	}
	
	public void setId_tr(int id_tr) {
		this.id_tr=id_tr;
	}
	
	public void setTipo_Tr(String Tipo_Tr) {
		this.Tipo_Tr=Tipo_Tr;
	}
	
	public void setDescripcion_Tr(String Descripcion_Tr) {
		this.Descripcion_Tr=Descripcion_Tr;
	}
	
	public void setPrioridad_Tr(String Prioridad_Tr) {
		this.Prioridad_Tr=Prioridad_Tr;
	}
}
