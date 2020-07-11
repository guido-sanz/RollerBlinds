package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

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
		List<Cliente> listaClientes = new ArrayList<>();
		listaClientes = clienteDAO.findAll();
		List<Cliente> sinFinalizar = new ArrayList<>();
		for(int i=0; i<listaClientes.size(); i++) {
			Cliente cliente = listaClientes.get(i);
			if(cliente.getEstado().equals("false")) {
				sinFinalizar.add(cliente);
			}
		}
		model.addAttribute("list", sinFinalizar);
		return "Clientes";
	}
	
	@GetMapping("/finalizado")
	public String Finalizado(Model model) {
		List<Cliente> listaClientes = new ArrayList<>();
		listaClientes = clienteDAO.findAll();
		List<Cliente> finalizado = new ArrayList<>();
		for(int i=0; i<listaClientes.size(); i++) {
			Cliente cliente = listaClientes.get(i);
			if(cliente.getEstado().equals("true")) {
				finalizado.add(cliente);
			}
		}
		model.addAttribute("list", finalizado);
		return "finalizado";
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
	
	
	
}
