package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entidades.Cliente;
import com.example.demo.entidades.Pedido;
import com.example.demo.service.ClienteDAO;
import com.example.demo.service.PedidoDAO;

@Controller
public class PedidosController {
	
	@Autowired
	ClienteDAO clientedao;

	@Autowired
	PedidoDAO pedidoDAO;
	
	@GetMapping("/listaDePedidos/{id}")
	public String pedidos(@PathVariable("id") Integer id, Model model) {
		if(id != null) {
			model.addAttribute("listaPedidos", pedidoDAO.findBycliente_id(id));
		}
		return "Pedidos";	
}

	@GetMapping("/agregarPedido/{id}")
	public String agregar(@PathVariable("id") Integer id, Model model) {
		if(id != null) {
			model.addAttribute("pedido", clientedao.findById(id));
			
		}
		return "cotizacion";	
}
	
	@PostMapping("/cotizador")
	public String save( Pedido p, Model model) {
		
		pedidoDAO.save(p);
		return "redirect:/Clientes";
	}
	
	
	
}