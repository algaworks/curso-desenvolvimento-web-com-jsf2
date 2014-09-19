package com.algaworks.cursojsf2.financeiro.view;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.algaworks.cursojsf2.financeiro.model.Lancamento;
import com.algaworks.cursojsf2.financeiro.repository.Lancamentos;
import com.algaworks.cursojsf2.financeiro.service.GestaoLancamentos;
import com.algaworks.cursojsf2.financeiro.service.RegraNegocioException;
import com.algaworks.cursojsf2.financeiro.util.FacesUtil;
import com.algaworks.cursojsf2.financeiro.util.Repositorios;

@ManagedBean
public class ConsultaLancamentoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Repositorios repositorios = new Repositorios();
	private List<Lancamento> lancamentos = new ArrayList<Lancamento>();
	private Lancamento lancamentoSelecionado;
	
	@PostConstruct
	public void inicializar() {
		Lancamentos lancamentos = this.repositorios.getLancamentos();
		this.lancamentos = lancamentos.todos();
	}

	public void excluir() {
		GestaoLancamentos gestaoLancamentos = new GestaoLancamentos(this.repositorios.getLancamentos());
		try {
			gestaoLancamentos.excluir(this.lancamentoSelecionado);
			
			this.inicializar();
			
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Lançamento excluído com sucesso!");
		} catch (RegraNegocioException e) {
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, e.getMessage());
		}
	}
	
	public void downloadComprovante() throws IOException {
		if (!lancamentoSelecionado.isPago() || lancamentoSelecionado.getComprovante() == null) {
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, "Lançamento não possui comprovante!");
			return;
		}
		
		String nomeArquivo = "comprovante_" + lancamentoSelecionado.getCodigo() + ".pdf";
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		
		externalContext.responseReset();
		externalContext.setResponseContentType("application/pdf");
		externalContext.setResponseHeader("Content-Disposition", "attachment; filename=\"" + nomeArquivo + "\"");
		
		OutputStream out = externalContext.getResponseOutputStream();
		
		try (InputStream is = new ByteArrayInputStream(lancamentoSelecionado.getComprovante())) {
            int read = -1;
            byte[] buffer = new byte[1024];
            
            while ((read = is.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
		}
		
		facesContext.responseComplete();
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