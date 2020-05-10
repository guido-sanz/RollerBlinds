package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entidades.Usuarios;
import com.example.demo.service.ClienteDAO;
import com.example.demo.service.UsuariosDAO;
import com.example.demo.service.UsuariosDAOimplet;

@Controller
public class UserController {

	@Autowired
	UsuariosDAOimplet usuariosDAOimplet;
	
	@Autowired
	ClienteDAO clienteDAO;
	
	@Autowired
	UsuariosDAO usuariosDAO;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@PostMapping("/formulario")
	public String buscarUsuario(Usuarios u, Model model) {
		if (usuariosDAOimplet.validarUsuario(u)) {
			model.addAttribute("list", clienteDAO.findAll());
			return "Clientes";
		} else {
			return "index";
		}
	}
	
//	@GetMapping("/Clientes")
//	public String clientes() {
//		return "Clientes";
//	}
//	
//	@GetMapping("/listar")
//	public String buscarPorNombre(Model model) {
//		model.addAttribute("list", usuariosDAO.findAll());
//		return "Clientes";
//	}

}
