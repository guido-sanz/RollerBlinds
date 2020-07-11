package com.example.demo.service;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidades.Usuarios;

@Service
public class UsuariosDAOimplet {

	@Autowired
	UsuariosDAO usuariosDAO;
	
	@PersistenceContext
	private EntityManager em;
	
	public boolean validarUsuario(Usuarios usuario) {
		boolean usuarioEncontrado = false;
		Optional<Usuarios> busqueda_usuario = usuariosDAO.findByUserAndPassword(usuario.getUser(), usuario.getPassword());
		if(busqueda_usuario.isPresent()) {
			usuarioEncontrado=true;
			System.out.println("EN USUARIO ES CORRECTO");
		}else {
			System.out.println("usuario incorrecto");
		}
		return usuarioEncontrado;
		
		
	}
	
	
}
