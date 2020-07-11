package com.example.demo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.example.demo.entidades.Pedido;

@Service
public class PedidoDAOimple {

	
	@PersistenceContext
	private EntityManager em;
	
		public List listarPedido(Integer id) {
		Query query = em.createQuery("select p from p Pedido where p.cliente_id = :id");
		query.setParameter("id", id);
		return query.getResultList();
	}
	
	
	
	
}
