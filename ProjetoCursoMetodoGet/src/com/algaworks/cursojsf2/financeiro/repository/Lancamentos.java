package com.algaworks.cursojsf2.financeiro.repository;

import java.util.List;

import com.algaworks.cursojsf2.financeiro.model.Lancamento;

public interface Lancamentos {

	public List<Lancamento> todos();
	public Lancamento comDadosIguais(Lancamento lancamento);
	public Lancamento porCodigo(Integer codigo);
	
	public Lancamento guardar(Lancamento lancamento);
	public void remover(Lancamento lancamento);
	
}