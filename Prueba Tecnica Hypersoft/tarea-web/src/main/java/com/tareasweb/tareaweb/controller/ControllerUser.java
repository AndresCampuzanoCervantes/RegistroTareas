package com.tareasweb.tareaweb.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tareasweb.tareaweb.metodos.Metodos;
import com.tareasweb.tareaweb.modelos.*;
@RestController
@RequestMapping("/Tareas-WEB/User")
public class ControllerUser {
	@PostMapping
	public boolean getUsuario(@RequestBody Usuario usr) {
		return  Metodos.ValidarUsuario(usr);
	}	
}
