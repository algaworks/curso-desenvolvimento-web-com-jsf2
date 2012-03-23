package com.algaworks.cursojsf2.visao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;

import com.algaworks.cursojsf2.dominio.Produto;

@ManagedBean
@NoneScoped
public class GestaoProdutosBean implements Serializable {

	private List<Produto> produtos;
	private Produto produto;

	public GestaoProdutosBean() {
		this.produtos = new ArrayList<Produto>();
		this.produto = new Produto();
	}
	
	public void incluir() {
		this.produtos.add(this.produto);
		this.produto = new Produto();
	}
	
	@PostConstruct
	public void inicializar() {
		System.out.println("Inicializou bean");
	}
	
	@PreDestroy
	public void finalizar() {
		System.out.println("Finalizando bean");
	}
	
	public Produto getProduto() {
		return produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}
	
}