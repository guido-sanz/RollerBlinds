package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Cliente;
import com.example.demo.entidades.Usuarios;

@Repository
public interface ClienteDAO extends JpaRepository<Cliente, Integer> {

	public Cliente findByNombre(String nombre);

}
