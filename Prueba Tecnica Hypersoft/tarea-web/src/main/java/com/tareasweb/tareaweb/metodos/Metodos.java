package com.tareasweb.tareaweb.metodos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tareasweb.tareaweb.modelos.*;

public class Metodos {
	
	public static boolean PruebaConexion(){
		try {
			Statement sql = getConexion().createStatement();
			String Consulta ="SELECT name FROM sys.databases ";
			ResultSet resultado = sql.executeQuery(Consulta);
			while(resultado.next()) 
			{
				return true;
			}
			return false;		
		}catch(Exception ex) {
			System.out.println(ex.toString());
			return false;
		}
	}
	
	public static Connection getConexion() {
		String conexionUrl ="jdbc:sqlserver://localhost:1433;"
				+"database=db_PrbHypersoft;"
				+"user=sa;"
				+"password=2019*;"
				+"loginTimeout=30;";
		try {
			return DriverManager.getConnection(conexionUrl);
		}catch(SQLException ex) {
			System.out.println(ex.toString());
			return null;
		}
	}
	
	public static boolean ValidarUsuario(Usuario usr)	{
		try {
			Statement sql = getConexion().createStatement();
			String Consulta ="exec [Usr_ValidarUsuarios] '"+usr.getCorreo_Usr()+"','"+usr.getPass()+"'";
			ResultSet resultado =sql.executeQuery(Consulta);
			while(resultado.next()) {
				return Integer.parseInt(resultado.getString("Resultado"))==1;
			}		
			return false;
		}catch(Exception ex) {
			System.out.println(ex.toString());
			return false;
		}
	}
	
	public static ArrayList<Tarea> CargarListaTareas(){
		try {
			ArrayList<Tarea> Tareas = new ArrayList<>();
			Statement sql = getConexion().createStatement();
			String Consulta ="exec [Tr_CargarListaTareas]";
			ResultSet resultado = sql.executeQuery(Consulta);
			while(resultado.next()) 
			{ 
				Tarea tarea = new Tarea(Integer.parseInt(resultado.getString("id_tr")) ,
						resultado.getString("Tipo_Tr"),
						resultado.getString("Descripcion_Tr"), 
						resultado.getString("Prioridad_Tr"));
				Tareas.add(tarea);
			}
			return Tareas;		
		}catch(Exception ex) {
			System.out.println(ex.toString());
			return null;
		}
	}
	
	public static boolean EditarTarea(Tarea tarea){
		try {
			Statement sql = getConexion().createStatement();
			String Consulta ="exec [Tr_EditarTarea] "+tarea.getId_tr()+",'"+
					tarea.getTipo_Tr()+"','"+
					tarea.getDescripcion_Tr()+"','"+
					tarea.getPrioridad_Tr()+"'";
			return sql.executeUpdate(Consulta)>0;		
		}catch(Exception ex) {
			System.out.println(ex.toString());
			return false;
		}
	}
	
	public static boolean EliminarTarea(int tarea){
		try {
			Statement sql = getConexion().createStatement();
			String Consulta ="exec [Tr_EliminarTarea] "+tarea;
			return sql.executeUpdate(Consulta)>0;		
		}catch(Exception ex) {
			System.out.println(ex.toString());
			return false;
		}
	}
	
	public static boolean InsertarTarea(Tarea tarea){
		try {
			Statement sql = getConexion().createStatement();
			String Consulta ="exec [Tr_InsertarTarea] '"+tarea.getTipo_Tr()+"','"+
					tarea.getDescripcion_Tr()+"','"+
					tarea.getPrioridad_Tr()+"'";
			int a=sql.executeUpdate(Consulta);
			return a>0;		
		}catch(Exception ex) {
			System.out.println(ex.toString());
			return false;
		}
	}
}