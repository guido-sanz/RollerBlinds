package com.example.demo.service;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Usuarios;

@Repository
public interface UsuariosDAO extends CrudRepository<Usuarios, Integer> {

	public  Optional<Usuarios> findByUserAndPassword(String user, String password);
	public  Optional<Usuarios> findByUser(String user);
		
	
	
}
