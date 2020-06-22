package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
				cliente.agregaPedido(p);
				clientedao.save(cliente);
			}

		}
		return "redirect:/Clientes";
	}

	@GetMapping("/cotizar/{id}")
	public String agregar2(@PathVariable(name = "id") Integer id, Model model) {
		model.addAttribute("pedido", pedidoDAO.findById(id));
		return "cotizacion";
	}

	@PostMapping("/cotizacion")
	public String agregar3(Pedido pedido, Model model) {
		double ancho = pedido.getAncho();
		double alto = pedido.getAlto();
		String tipo = pedido.getTipo();
		if(tipo.equals("")) {
		double precio = (ancho*(alto+30));
		pedido.setTotal(precio);
		}
		System.out.println(ancho);
		System.out.println(alto);
		pedidoDAO.save(pedido);
		return "redirect:/Clientes";
	}

	@GetMapping("/deletePedidos/{id}/{cliente}")
	public String deletePedidos(@PathVariable("id") Integer id,@PathVariable("cliente") Integer clienteid, Model model) {
		if (id != null) {
			

			Optional<Cliente> c = clientedao.findById(clienteid);
			if (c.isPresent()) {
				Cliente cliente = c.get();
				System.out.println(cliente.toString());
				Optional<Pedido> p = pedidoDAO.findById(id);
				if (p.isPresent()) {
					Pedido pedidos = p.get();
					System.out.println(pedidos.toString());
					cliente.removePedido(pedidos);
					clientedao.save(cliente);
				}
			}
		}
		return "redirect:/Clientes";
	}
}

