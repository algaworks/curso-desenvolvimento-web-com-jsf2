package com.algaworks.cursojsf2.financeiro.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.algaworks.cursojsf2.financeiro.model.Lancamento;
import com.algaworks.cursojsf2.financeiro.util.FacesUtil;

@ManagedBean
public class ConsultaLancamentoBean implements Serializable {

	private List<Lancamento> lancamentos = new ArrayList<Lancamento>();
	private Lancamento lancamentoSelecionado;
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	public void inicializar() {
		Session session = (Session) FacesUtil.getRequestAttribute("session");
		
		this.lancamentos = session.createCriteria(Lancamento.class)
				.addOrder(Order.desc("dataVencimento"))
				.list();
	}

	public void excluir() {
		if (this.lancamentoSelecionado.isPago()) {
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, "Lançamento já foi pago e não pode ser excluído.");
		} else {
			Session session = (Session) FacesUtil.getRequestAttribute("session");
			session.delete(this.lancamentoSelecionado);
			
			this.inicializar();
			
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Lançamento excluído com sucesso!");
		}
	}
	
	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public Lancamento getLancamentoSelecionado() {
		return lancamentoSelecionado;
	}

	public void setLancamentoSelecionado(Lancamento lancamentoSelecionado) {
		this.lancamentoSelecionado = lancamentoSelecionado;
	}
	
}