package com.algaworks.cursojsf2;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class EstoqueBean {

	private ItemEstoque itemEstoque = new ItemEstoque();
	private List<ItemEstoque> itensEstoque = new ArrayList<ItemEstoque>();
	
	public void incluir() {
		this.itensEstoque.add(this.itemEstoque);
		this.itemEstoque = new ItemEstoque();
	}

	public ItemEstoque getItemEstoque() {
		return itemEstoque;
	}

	public List<ItemEstoque> getItensEstoque() {
		return itensEstoque;
	}
	
}