package br.edu.ifba.plugin.PROJETO.visao.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

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

	private List<Usuario> usuariosEncontrados = new ArrayList<Usuario>();

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
		naoEncontrado = false;
		
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

	private void exibirCadastro(String id) {
		ExternalContext context = FacesContext.
				getCurrentInstance()
				.getExternalContext();
		context.getSessionMap().put("idUsuario", id);
		try {
			context.redirect("cadastro_usuario.ifba");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void ver(String id) {
		exibirCadastro(id);
	}

	public void adicionar() {
		exibirCadastro("");
	}

	public void remover(String id) {
		this.id = id;

		ModeloUsuario modelo = new ModeloUsuario();
		ControleUsuario controle = new ControleUsuario();

		controle.setModeloUsuario(modelo);
		controle.setPesquisaUsuario(this);

		controle.remover();
	}

	public boolean getNaoEncontrado() {
		return naoEncontrado;
	}

	@Override
	public void notificarUsuariosNaoEncontrados() {
		naoEncontrado = true;
	}

}
