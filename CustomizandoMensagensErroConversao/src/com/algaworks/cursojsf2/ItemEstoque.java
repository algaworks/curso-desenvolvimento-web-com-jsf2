package com.algaworks.cursojsf2;

import java.math.BigDecimal;
import java.util.Date;

public class ItemEstoque {

	private Integer codigoProduto;
	private String descricao;
	private Short quantidade;
	private BigDecimal valorUnitario;
	private Date dataChecagem;
	
	public Integer getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(Integer codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Short getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Short quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public Date getDataChecagem() {
		return dataChecagem;
	}
	public void setDataChecagem(Date dataChecagem) {
		this.dataChecagem = dataChecagem;
	}
	
}