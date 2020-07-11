package com.example.demo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entidades.Cliente;
import com.example.demo.entidades.Pedido;
import com.example.demo.generadorPdf.GeneradorPdf;
import com.example.demo.service.ClienteDAO;
import com.example.demo.service.PedidoDAO;
import com.example.demo.service.PedidoDAOimple;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfTable;

@Controller
public class PedidosController {

	@Autowired
	ClienteDAO clientedao;

	@Autowired
	PedidoDAO pedidoDAO;

	@Autowired
	PedidoDAOimple dao;
	
	@Autowired
	Pedido pedidoCoti;
	
	@Autowired
	GeneradorPdf pdfGenerator;

	@GetMapping("/listaDePedidos/{id}")
	public String pedidos(@PathVariable("id") Integer id, Model model) {
		double sumaPedidos = 0;
		List<Pedido> p = pedidoDAO.findByclienteId(id);
		if (id != null) {
			model.addAttribute("listaPedidos", p);
			
			for(Pedido pedidos : p) {
				if(pedidos.getTotal() != null) {
				sumaPedidos = sumaPedidos + pedidos.getTotal();
				}else {
					sumaPedidos = 0;
				}
			}
			model.addAttribute("sumaPedidos", ((double)Math.round(sumaPedidos * 100d) / 100d));
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
				p.setTotal(0.0);
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
	public String agregar3(@Valid @ModelAttribute("pedido") Pedido pedido, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("ESTA VACIO");
			return "cotizacion";
		}
		double ancho = pedido.getAncho();
		double alto = pedido.getAlto();
		int cantidad = pedido.getCantidad();
		String tela = pedido.getTela();
		double precio = pedidoCoti.cotizacion(ancho, alto, cantidad, tela);
		pedido.setTotal(precio);
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
	
	@GetMapping("/descargarPDF/{id}")
	public void descargarPDF(HttpServletResponse response, @PathVariable("id") Integer id) throws DocumentException, IOException {
		
		response.setContentType("application/pdf");
		String headerKey = "Content-disposition";
		String headerValue = "ateachment; filename=pedido.pdf";
		
		response.setHeader(headerKey, headerValue);
		
		List<Pedido> listaPedido = pedidoDAO.findByclienteId(id);
		System.out.println(listaPedido.toString());
		
		
		
		GeneradorPdf exporter = new GeneradorPdf(listaPedido);
		exporter.export(response);
	}
	
	
	
}

