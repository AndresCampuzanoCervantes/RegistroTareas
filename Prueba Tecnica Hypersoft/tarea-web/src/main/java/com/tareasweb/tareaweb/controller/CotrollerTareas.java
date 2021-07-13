package com.tareasweb.tareaweb.controller;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tareasweb.tareaweb.metodos.Metodos;
import com.tareasweb.tareaweb.modelos.*;

@RequestMapping("/Tareas-WEB/Tareas")
@RestController
public class CotrollerTareas {
	
	@GetMapping
	public ArrayList<Tarea> getTareas() {
		try {
			return new ArrayList<Tarea>(Metodos.CargarListaTareas());
		} catch (Exception e) {
			return null;
		}
	}	
	
	@PostMapping
	public boolean insertTarea(@RequestBody Tarea tr) {
		boolean respuesta =false ;
		if (tr.getId_tr()==0) {
			respuesta=Metodos.InsertarTarea(tr);
		}else {
			respuesta=Metodos.EditarTarea(tr);
		}
		return respuesta;
	}
	
	@DeleteMapping(value="/{id}")
	public boolean deleteTarea(@PathVariable("id") Integer tr) {
		
		return Metodos.EliminarTarea(tr);
	}
	
}
