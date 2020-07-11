package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.ClienteDAOimplet;

@Controller
public class BuscarCliente {

	@Autowired
	ClienteDAOimplet daoimplet;
	
	
	@PostMapping("/buscador")
	public String greeting(@RequestParam(value = "nombre", defaultValue = "1") String nombre, Model model) {
		model.addAttribute("lista2", daoimplet.Buscar(nombre));
		return "BusquedaPorNombre";
	}
}
