package br.edu.ifba.plugin.PROJETO.visao.impl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.edu.ifba.plugin.PROJETO.controle.ControleUsuario;
import br.edu.ifba.plugin.PROJETO.modelo.ModeloUsuario;
import br.edu.ifba.plugin.PROJETO.modelo.bd.estatico.Usuario;
import br.edu.ifba.plugin.PROJETO.visao.ICadastroUsuario;

@ManagedBean(name = "cadusuario")
@ViewScoped
public class CadastroUsuario implements ICadastroUsuario {

	private String id = "";
	private Usuario usuario = new Usuario();

	public CadastroUsuario() {
		ExternalContext context = FacesContext.getCurrentInstance()
				.getExternalContext();
		id = (String) context.getSessionMap().get("idUsuario");
		System.out.println("ID do usuário = " + id);

		recuperarUsuario();
	}

	private void recuperarUsuario() {
		ModeloUsuario modelo = new ModeloUsuario();
		ControleUsuario controle = new ControleUsuario();

		controle.setModeloUsuario(modelo);
		controle.setCadastroUsuario(this);

		controle.pesquisarParaCadastro(Integer.parseInt(id));
	}

	@Override
	public int getId() {
		int iid = -1;
		
		if (!id.isEmpty()) {
			iid = Integer.parseInt(id);
		}
		
		return iid;
	}
	
	@Override
	public Usuario getUsuario() {
		return usuario;
	}

	public void gravar() {
		System.out.println("Gravando = " + usuario);
	}

	@Override
	public void atualizarUsuarioEncontrado(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public void notificarUsuarioNaoEncontrado() {
		System.out
				.println("Usuário não encontrado. Talvez ele tenha sido removido!");
	}

	@Override
	public void notificarUsuarioGravado(Usuario usuario) {
		this.usuario = usuario;

		System.out.println("Usuario adicionado com sucesso!");
	}

	@Override
	public void notificarErroGravacao() {
		System.out.println("Erro de gravação de dados de usuário!");
	}

}
