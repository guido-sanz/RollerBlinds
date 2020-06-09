package com.example.demo.controller;

import java.util.List;
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
import com.example.demo.service.PedidoDAOimple;

@Controller
public class PedidosController {

	@Autowired
	ClienteDAO clientedao;

	@Autowired
	PedidoDAO pedidoDAO;

	@Autowired
	PedidoDAOimple dao;

	@GetMapping("/listaDePedidos/{id}")
	public String pedidos(@PathVariable("id") Integer id, Model model) {
		if (id != null) {
			model.addAttribute("listaPedidos", pedidoDAO.findByclienteId(id));
		}
		return "Pedidos";
	}

	@GetMapping("/agregarPedido/{id}")
	public String agregar(@PathVariable("id") Integer id, Model model) {
		if (id != null) {
			Optional<Cliente> c = clientedao.findById(id);
			if (c.isPresent()) {
				Cliente cliente = c.get();
				Pedido p = new Pedido();
				cliente.agregarPedido(p);
				clientedao.save(cliente);
			}

		}
		return "redirect:/Clientes";
	}

	@GetMapping("/cotizar/{id}")
	public String agregar2(@PathVariable(name = "id") Integer id, Model model) {
		model.addAttribute("pedido", pedidoDAO.findById(id).get());
		return "cotizacion";
	}

	@PostMapping("/coti")
	public String agregar3(Pedido pedido, Model model) {
		pedidoDAO.save(pedido);
		return "redirect:/Clientes";
	}
}