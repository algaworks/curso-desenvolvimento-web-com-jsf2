package com.algaworks.cursojsf2.financeiro.model;

public enum TipoLancamento {

	RECEITA("Receita"),
	DESPESA("Despesa");
	
	private String descricao;
	
	TipoLancamento(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
}