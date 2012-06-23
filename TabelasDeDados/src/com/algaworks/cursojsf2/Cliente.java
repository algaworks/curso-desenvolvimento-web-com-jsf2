package com.algaworks.cursojsf2;

public class Cliente {

	private Integer codigo;
	private String nome;
	private String cidade;
	
	public Cliente(Integer codigo, String nome, String cidade) {
		this.codigo = codigo;
		this.nome = nome;
		this.cidade = cidade;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
}