package com.example.demo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.example.demo.entidades.Cliente;

@Service
public class ClienteDAOimplet {

	
	@PersistenceContext
	private EntityManager em;
	
	public List Buscar(String nombre) {
		Query query = em.createQuery("select c from Cliente c where c.nombre = :nombreCliente");
		query.setParameter("nombreCliente", nombre);
		return query.getResultList();
	}
	
	
}
