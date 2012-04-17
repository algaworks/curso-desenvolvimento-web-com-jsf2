package com.algaworks.cursojsf2;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class TimesFavoritosBean {

	private String[] times;

	public void escolher() {
		System.out.println("---------------------");
		System.out.println("Times selecionados: ");
		for (String time : this.getTimes()) {
			System.out.println(time);
		}
	}
	
	public String[] getTimes() {
		return times;
	}

	public void setTimes(String[] times) {
		this.times = times;
	}

}