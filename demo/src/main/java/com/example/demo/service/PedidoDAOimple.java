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
	
//		public void Buscar(Integer id) {
//		Query query = em.createQuery("insert into Pedido p = :p where p.idCliente = :id ");
//		query.setParameter("id", id);
//		query.setParameter("p", p);
//	}
	
	
	
	
}
