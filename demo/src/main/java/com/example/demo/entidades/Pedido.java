package com.example.demo.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer id;
	private String tipo;
	private String tela;
	private String color;
	private double ancho;
	private double alto;
	private String cantidad;
	private String ladoCadena;
	private String tipoCadena;
	private String envio;
	private Double total;
	
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Cliente cliente;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public double getAncho() {
		return ancho;
	}


	public void setAncho(double ancho) {
		this.ancho = ancho;
	}


	public double getAlto() {
		return alto;
	}


	public void setAlto(double alto) {
		this.alto = alto;
	}


	public String getCantidad() {
		return cantidad;
	}


	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}


	public String getLadoCadena() {
		return ladoCadena;
	}


	public void setLadoCadena(String ladoCadena) {
		this.ladoCadena = ladoCadena;
	}


	public String getTipoCadena() {
		return tipoCadena;
	}


	public void setTipoCadena(String tipoCadena) {
		this.tipoCadena = tipoCadena;
	}


	public String getEnvio() {
		return envio;
	}


	public void setEnvio(String envio) {
		this.envio = envio;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public String getTela() {
		return tela;
	}


	public void setTela(String tela) {
		this.tela = tela;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public Double getTotal() {
		return total;
	}


	public void setTotal(Double total) {
		this.total = total;
	}

	
	
	
	
	
}