package com.algaworks.cursojsf2.financeiro.service;

import com.algaworks.cursojsf2.financeiro.model.Lancamento;
import com.algaworks.cursojsf2.financeiro.repository.Lancamentos;

public class GestaoLancamentos {

	private Lancamentos lancamentos;
	
	public GestaoLancamentos(Lancamentos lancamentos) {
		this.lancamentos = lancamentos;
	}
	
	public void salvar(Lancamento lancamento) throws RegraNegocioException {
		if (existeLancamentoSemelhante(lancamento)) {
			throw new RegraNegocioException("existing_entry");
		}
		
		this.lancamentos.guardar(lancamento);
	}
	
	private boolean existeLancamentoSemelhante(Lancamento lancamento) {
		Lancamento lancamentoSemelhante = this.lancamentos.comDadosIguais(lancamento);
		
		return lancamentoSemelhante != null && !lancamentoSemelhante.equals(lancamento);
	}
	
	public void excluir(Lancamento lancamento) throws RegraNegocioException {
		if (lancamento.isPago()) {
			throw new RegraNegocioException("Lançamento pago não pode ser excluído.");
		}
		
		this.lancamentos.remover(lancamento);
	}
	
}