package br.edu.ifba.plugin.PROJETO.visao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.edu.ifba.plugin.PROJETO.controle.ControleUsuario;
import br.edu.ifba.plugin.PROJETO.modelo.ModeloUsuario;
import br.edu.ifba.plugin.PROJETO.modelo.beans.Usuario;
import br.edu.ifba.plugin.PROJETO.visao.IPesquisaUsuario;

@ManagedBean(name = "pusuario")
public class PesquisaUsuario implements IPesquisaUsuario {

	private boolean naoEncontrado = false;
	
	private String rg = "";
	private String cpf = "";
	private String nome = "";
	
	private List<Usuario> usuariosEncontrados =
			new ArrayList<Usuario>();
	
	@Override
	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}
	
	@Override
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Override
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void pesquisar() {
		ModeloUsuario modelo = new ModeloUsuario();
		ControleUsuario controle = new ControleUsuario();
		
		controle.setModeloUsuario(modelo);
		controle.setPesquisaUsuario(this);
		
		controle.pesquisar();
	}

	@Override
	public void atualizarUsuariosEncontrados(List<Usuario> usuarios) {
		this.usuariosEncontrados = usuarios;
	}
	
	public List<Usuario> getUsuarios() {
		return this.usuariosEncontrados;
	}
	
	public boolean getNaoEncontrado() {
		return naoEncontrado;
	}

	@Override
	public void notificarUsuariosNaoEncontrados() {
		naoEncontrado = true;
	}

}
