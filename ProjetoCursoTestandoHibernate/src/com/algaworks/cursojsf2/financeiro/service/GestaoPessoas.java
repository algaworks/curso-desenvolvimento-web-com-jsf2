package com.algaworks.cursojsf2.financeiro.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.algaworks.cursojsf2.financeiro.model.Pessoa;

public class GestaoPessoas {

	private static Map<Integer, Pessoa> pessoas = new HashMap<Integer, Pessoa>();
	
	static {
		pessoas.put(1, new Pessoa(1, "João da Silva"));
		pessoas.put(2, new Pessoa(2, "Lava-jato Água e Sabão Ltda"));
		pessoas.put(3, new Pessoa(3, "Sebastião Mendes de Souza"));
	}
	
	public List<Pessoa> listarTodas() {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.addAll(GestaoPessoas.pessoas.values());
		return pessoas;
	}
	
	public Pessoa buscarPorCodigo(Integer codigo) {
		return pessoas.get(codigo);
	}
	
}