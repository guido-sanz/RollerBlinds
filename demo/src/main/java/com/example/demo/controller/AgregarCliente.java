package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entidades.Cliente;
import com.example.demo.entidades.Usuarios;
import com.example.demo.service.ClienteDAO;

@Controller
public class AgregarCliente {

	@Autowired
	ClienteDAO clienteDAO;
	
	
	
	@GetMapping("/save/{id}")
	public String showSave(@PathVariable("id") Integer id, Model model) {
		if (id != null && id != 0) {
		model.addAttribute("cliente", clienteDAO.findById(id));
		}else {
			model.addAttribute("cliente", new Cliente());
		}
		return "agregarCliente";
		}
	
	

	@PostMapping("/save")
	public String save(Cliente cliente, Model model) {
		cliente.setEstado("false");
		clienteDAO.save(cliente);
		return "redirect:/Clientes";
	}

	@GetMapping("/finalizar/{id}")
	public String finalizar(@PathVariable("id") Integer id, Model model) {
		if (id != null) {
			Optional<Cliente> c = clienteDAO.findById(id);
			if (c.isPresent()) {
				Cliente cliente = c.get();
				cliente.setEstado("true");
				clienteDAO.save(cliente);
			}
		}
		return "redirect:/Clientes";
	}
}
