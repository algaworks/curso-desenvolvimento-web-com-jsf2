package com.algaworks.cursojsf2;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ConsultaClienteBean {

	private List<Cliente> clientes = new ArrayList<Cliente>();
	
	public void consultar() {
		this.getClientes().add(new Cliente(1, "Pedro Pereira", "Uberlândia"));
		this.getClientes().add(new Cliente(2, "José da Silva", "Araguari"));
		this.getClientes().add(new Cliente(4, "Joaquim Manoel", "Uberaba"));
		this.getClientes().add(new Cliente(6, "Sebastião Souza", "São Paulo"));
		this.getClientes().add(new Cliente(7, "Joana Carvalho", "Uberlândia"));
		this.getClientes().add(new Cliente(10, "Maria José", "Rio de Janeiro"));
	}
	
	public void salvar() {
		for (Cliente cliente : this.getClientes()) {
			System.out.println(cliente.getCodigo() + " - " + cliente.getNome());
		}
	}
	
	public List<Cliente> getClientes() {
		return this.clientes;
	}
	
}