package br.edu.ifba.plugin.PROJETO.visao;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "padrao")
public class Padrao {

	private String texto = "";
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public String getTexto() {
		return texto;
	}
	
}
