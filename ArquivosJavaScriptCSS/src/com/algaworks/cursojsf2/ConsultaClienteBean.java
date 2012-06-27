package com.algaworks.cursojsf2;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ConsultaClienteBean {

	private List<Cliente> clientes = new ArrayList<Cliente>();
	
	@PostConstruct
	public void consultar() {
		this.getClientes().add(new Cliente(1, "Pedro Pereira", "Uberlândia"));
		this.getClientes().add(new Cliente(2, "José da Silva", "Araguari"));
		this.getClientes().add(new Cliente(4, "Joaquim Manoel", "Uberaba"));
		this.getClientes().add(new Cliente(6, "Sebastião Souza", "São Paulo"));
		this.getClientes().add(new Cliente(7, "Joana Carvalho", "Uberlândia"));
		this.getClientes().add(new Cliente(10, "Maria José", "Rio de Janeiro"));
	}
	
	public List<Cliente> getClientes() {
		return this.clientes;
	}
	
}