package com.algaworks.cursojsf2.financeiro.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ConsultaLancamentoBean {

	private List<String> lancamentos = new ArrayList<String>();
	
	@PostConstruct
	public void inicializar() {
		for (int i = 0; i < 20; i++) {
			lancamentos.add("");
		}
	}

	public List<String> getLancamentos() {
		return lancamentos;
	}
	
}