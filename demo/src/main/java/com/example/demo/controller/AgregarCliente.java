package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entidades.Cliente;
import com.example.demo.entidades.Usuarios;
import com.example.demo.service.ClienteDAO;

@Controller
public class AgregarCliente {

	@Autowired
	ClienteDAO clienteDAO;
	
	
	@PostMapping("/save")
	public String save(Cliente c, Model model) {
		clienteDAO.save(c);
		return "redirect:/Clientes";
	}
	

	
	
}
