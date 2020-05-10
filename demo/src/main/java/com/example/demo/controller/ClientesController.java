package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Cliente;
import com.example.demo.service.ClienteDAO;
import com.example.demo.service.ClienteDAOimplet;
import com.example.demo.service.UsuariosDAO;

@Controller
public class ClientesController {

	@Autowired
	ClienteDAOimplet daoimplet;
	
	@Autowired
	ClienteDAO clienteDAO;

	@GetMapping("/Clientes")
	public String all(Model model) {
		model.addAttribute("list", clienteDAO.findAll());
		return "Clientes";
	}

	@GetMapping("/agregarClientes")
	public String agregar() {
		return "agregarCliente";
	}

	@GetMapping("/delete/{id}")
	public String pedidos(@PathVariable("id") Integer id, Model model) {
		if (id != null) {
			clienteDAO.deleteById(id);
		}
		return "redirect:/Clientes";
	}

	@GetMapping(value = "/cotizacion")
		public String cotizador() {
		return "cotizacion";
	}
	
}
