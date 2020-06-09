package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Pedido;
import com.example.demo.entidades.Usuarios;

@Repository
public interface PedidoDAO extends CrudRepository<Pedido, Integer> {

	
	public  List<Pedido> findByclienteId(Integer id);
}
