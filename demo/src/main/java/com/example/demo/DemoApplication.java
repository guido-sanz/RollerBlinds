package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.entidades.Cliente;
import com.example.demo.entidades.Pedido;
import com.example.demo.entidades.Usuarios;
import com.example.demo.service.ClienteDAO;
import com.example.demo.service.ClienteDAOimplet;
import com.example.demo.service.PedidoDAO;
import com.example.demo.service.PedidoDAOimple;
import com.example.demo.service.UsuariosDAO;
import com.example.demo.service.UsuariosDAOimplet;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	UsuariosDAO dao;

	@Autowired
	UsuariosDAOimplet daOimplet;

	@Autowired
	ClienteDAO clienteDAO;

	@Autowired
	ClienteDAOimplet daoimple;

	@Autowired
	PedidoDAO pedidoDAO;

	@Autowired
	PedidoDAOimple daOimple2;
	
	@Autowired
	BCryptPasswordEncoder encoder;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//			Cliente c = new Cliente();
//			c.setNombre("roberto");
//			c.setApellido("gomez");
//			c.setDni("46895123");
//			c.setEmail("gomez.fabian@hotmail.com");
//			c.setTelefono("456327812");
//		
//			Pedido p = new Pedido();
//			p.setTipo("simple");
//			p.setTela("blackout premiun");
//			p.setColor("negro");
//			p.setAncho(220);
//			p.setAlto(120);
//			p.setCantidad("2");
//			p.setTipoCadena("metalica");
//			p.setLadoCadena("derecha");
//			p.setEnvio("no");
//		
//			
//			Pedido p2 = new Pedido();
//			p2.setTipo("simple");
//			p2.setTela("blackout premiun");
//			p2.setColor("gris");
//			p2.setAncho(200);
//			p2.setAlto(130);
//			p2.setCantidad("1");
//			p2.setTipoCadena("metalica");
//			p2.setLadoCadena("derecha");
//			p2.setEnvio("no");
//			
//			
//			Pedido p3 = new Pedido();
//			p3.setTipo("simple");
//			p3.setTela("screen 5%");
//			p3.setColor("blanco");
//			p3.setAncho(170);
//			p3.setAlto(130);
//			p3.setCantidad("1");
//			p3.setTipoCadena("plastica");
//			p3.setLadoCadena("derecha");
//			p3.setEnvio("no");
//			
//			List<Pedido> array = c.getPedidos();
//			  array.add(p);
//			  array.add(p2);
//			  array.add(p3);
//			  
//			  c.setPedidos(array);
//
//			  
//			  clienteDAO.save(c);
//		pedidoDAO.save(p);
//		
////	System.out.println(clienteDAO.fin);
//		
//		pedidoDAO.deleteAll();

//		Usuarios u = new Usuarios();
//		u.setUser("admin");
//		u.setPassword(encoder.encode("admin"));		
//		dao.save(u);
//		

//		System.out.println(daOimple2.listarPedido(1));	

//		Optional<Cliente> c = clienteDAO.findById(3);
//		if (c.isPresent()) {
//			Cliente cliente = c.get();
//			System.out.println(cliente.toString());
//			Optional<Pedido> p = pedidoDAO.findById(5);
//			if (p.isPresent()) {
//				Pedido pedidos = p.get();
//				cliente.removePedido(pedidos);
//				clienteDAO.save(cliente);
//			}
//		}
		
//		pedidoDAO.deleteById(1);

		
		
	}
}
