package com.algaworks.cursojsf2.financeiro.view;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.Part;

import com.algaworks.cursojsf2.financeiro.model.Lancamento;
import com.algaworks.cursojsf2.financeiro.model.Pessoa;
import com.algaworks.cursojsf2.financeiro.model.TipoLancamento;
import com.algaworks.cursojsf2.financeiro.repository.Pessoas;
import com.algaworks.cursojsf2.financeiro.service.GestaoLancamentos;
import com.algaworks.cursojsf2.financeiro.service.RegraNegocioException;
import com.algaworks.cursojsf2.financeiro.util.FacesUtil;
import com.algaworks.cursojsf2.financeiro.util.Repositorios;

@ManagedBean
@ViewScoped
public class CadastroLancamentoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Repositorios repositorios = new Repositorios();
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	private Lancamento lancamento = new Lancamento();
	private transient Part arquivoComprovante;

	public String init() {
//		if (this.lancamento.isPago()) {
//			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, 
//					"Lançamento pago não pode ser editado");
//			
//			return "ConsultaLancamento";
//		}
		
		Pessoas pessoas = this.repositorios.getPessoas();
		this.pessoas = pessoas.todas();
		
		return null;
	}
	
	public void lancamentoPagoModificado(ValueChangeEvent event) {
		this.lancamento.setPago((Boolean) event.getNewValue());
		this.lancamento.setDataPagamento(null);
		FacesContext.getCurrentInstance().renderResponse();
	}

	public void uploadComprovante(ActionEvent event) {
		if (arquivoComprovante != null) {
			try (InputStream is = arquivoComprovante.getInputStream();
					ByteArrayOutputStream out = new ByteArrayOutputStream()) {
				
				int read = -1;
                byte[] buffer = new byte[1024];
                
                while ((read = is.read(buffer)) != -1) {
                    out.write(buffer, 0, read);
                }
				
                lancamento.setComprovante(out.toByteArray());
			} catch (IOException e) {
				throw new RuntimeException("Erro ao enviar arquivo.", e);
			}
		}
	}
	
	public void salvar() {
		GestaoLancamentos gestaoLancamentos = new GestaoLancamentos(this.repositorios.getLancamentos());
		try {
			gestaoLancamentos.salvar(lancamento);
			
			this.lancamento = new Lancamento();
			
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, FacesUtil.getMensagemI18n("entry_saved"));
		} catch (RegraNegocioException e) {
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, FacesUtil.getMensagemI18n(e.getMessage()));
		}
	}
	
	public boolean isEditando() {
		return this.lancamento.getCodigo() != null;
	}
	
	public TipoLancamento[] getTiposLancamentos() {
		return TipoLancamento.values();
	}

	public Lancamento getLancamento() {
		return lancamento;
	}
	
	public void setLancamento(Lancamento lancamento) throws CloneNotSupportedException {
		this.lancamento = lancamento;
		if (this.lancamento == null) {
			this.lancamento = new Lancamento();
		} else {
			this.lancamento = (Lancamento) lancamento.clone();
		}
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public Part getArquivoComprovante() {
		return arquivoComprovante;
	}

	public void setArquivoComprovante(Part arquivoComprovante) {
		this.arquivoComprovante = arquivoComprovante;
	}

}