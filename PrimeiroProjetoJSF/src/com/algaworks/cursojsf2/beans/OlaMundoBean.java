package com.algaworks.cursojsf2.beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class OlaMundoBean {

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void enviar() {
		System.out.println("Nome digitado: " + this.getNome());
		this.setNome(this.getNome().toUpperCase());
	}
	
}