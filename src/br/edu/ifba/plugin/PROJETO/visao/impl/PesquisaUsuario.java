package br.edu.ifba.plugin.PROJETO.visao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifba.plugin.PROJETO.controle.ControleUsuario;
import br.edu.ifba.plugin.PROJETO.modelo.ModeloUsuario;
import br.edu.ifba.plugin.PROJETO.modelo.bd.estatico.Usuario;
import br.edu.ifba.plugin.PROJETO.visao.IPesquisaUsuario;

@ManagedBean(name = "pusuario")
@ViewScoped
public class PesquisaUsuario implements IPesquisaUsuario {

	private boolean naoEncontrado = false;
	
	private String id = "";
	private String rg = "";
	private String cpf = "";
	private String nome = "";
	
	private List<Usuario> usuariosEncontrados =
			new ArrayList<Usuario>();
	
	@Override
	public String getId() {
		return id;
	}
	
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
		System.out.println("pesquisar");
		
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
	
	public void ver(String id) {
		
	}
	
	public void remover(String id) {
		this.id = id;
		
		ModeloUsuario modelo = new ModeloUsuario();
		ControleUsuario controle = new ControleUsuario();
		
		controle.setModeloUsuario(modelo);
		controle.setPesquisaUsuario(this);
		
		controle.remover();
	}
	
	public void adicionar() {
		
	}
	
	public boolean getNaoEncontrado() {
		return naoEncontrado;
	}
	
	@Override
	public void notificarUsuariosNaoEncontrados() {
		naoEncontrado = true;
	}

}
