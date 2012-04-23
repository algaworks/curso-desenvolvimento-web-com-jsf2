package com.algaworks.cursojsf2;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class PerfilUsuarioBean {

	private String sexo;
	private boolean receberNovidades;
	private String[] linguagensFavoritas;
	
	public String enviar() {
		return "Confirmacao";
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public boolean isReceberNovidades() {
		return receberNovidades;
	}

	public void setReceberNovidades(boolean receberNovidades) {
		this.receberNovidades = receberNovidades;
	}

	public String[] getLinguagensFavoritas() {
		return linguagensFavoritas;
	}

	public void setLinguagensFavoritas(String[] linguagensFavoritas) {
		this.linguagensFavoritas = linguagensFavoritas;
	}
	
}