package com.algaworks.cursojsf2.financeiro.repository;

import java.util.List;

import com.algaworks.cursojsf2.financeiro.model.Pessoa;

public interface Pessoas {

	public List<Pessoa> todas();
	public Pessoa porCodigo(Integer codigo);
	
}