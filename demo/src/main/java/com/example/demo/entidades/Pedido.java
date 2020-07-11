package com.example.demo.entidades;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;

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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.stereotype.Component;

import com.lowagie.text.pdf.PdfPCell;

@Entity
@Component
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	private String tipo;
	private String tela;
	private String color;
	@NotNull
	private double ancho;
	@NotNull
	private double alto;
	private int cantidad;
	private String ladoCadena;
	private String tipoCadena;
	private String envio;
	private Double total;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Cliente cliente;

	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Pedido() {
		// TODO Auto-generated constructor stub
	}


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


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
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


	@Override
	public String toString() {
		return "Pedido [id=" + id + ", tipo=" + tipo + ", tela=" + tela + ", color=" + color + ", ancho=" + ancho
				+ ", alto=" + alto + ", cantidad=" + cantidad + ", ladoCadena=" + ladoCadena + ", tipoCadena="
				+ tipoCadena + ", envio=" + envio + ", total=" + total + ", cliente=" + cliente + "]";
	}

	
	public double cotizacion(double ancho, double alto, int cantidad, String tela) {
		DecimalFormat df = new DecimalFormat("#.00");
		String tela1 = "Blackout premiun";
		String tela2 = "Blackout smart";
		String tela3 = "Screen 5% premiun";
		String tela4 = "Screen 5% smart";
		double precio = 0;
		if(tela.equals(tela1)) {
			 precio = (((ancho*(alto+30))/10000)*899)*cantidad;
		}else if(tela.equals(tela2)) {
			precio = (((ancho*(alto+30))/10000)*600)*cantidad;
		}else if(tela.equals(tela3)) {
			precio = (((ancho*(alto+30))/10000)*1200)*cantidad;
		}else if(tela.equals(tela4)) {
			precio = (((ancho*(alto+30))/10000)*950)*cantidad;
		}
		return ((double)Math.round(precio * 100d) / 100d);
		
	}
	
	public double sumaPedidos(List<Pedido> pedidos) {
		double sumaPedidos = 0;
		
		for(Pedido p : pedidos) {
			sumaPedidos = sumaPedidos + p.getTotal();
		}
		return sumaPedidos;

	}
}