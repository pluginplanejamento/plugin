package br.edu.ifba.plugin.PROJETO.modelo;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.plugin.PROJETO.modelo.bd.FachadaBD;
import br.edu.ifba.plugin.PROJETO.modelo.beans.Usuario;
import br.edu.ifba.plugin.PROJETO.visao.IAcessoUsuario;
import br.edu.ifba.plugin.PROJETO.visao.IPesquisaUsuario;

/**
 * Classe de Modelo especializada em manipular informacoes relacionadas aa
 * validacao de acesso do usuario.
 * 
 * Os modelos sao ativos, i.e. acionam automaticamente acoes na interface.
 * 
 * @author PLUGIN
 */
public class ModeloUsuario {

	private IAcessoUsuario acessoUsuario = null;
	private IPesquisaUsuario pesquisaUsuario = null;

	public void setAcessoUsuario(IAcessoUsuario acesso) {
		this.acessoUsuario = acesso;
	}

	public void setPesquisaUsuario(IPesquisaUsuario pesquisa) {
		this.pesquisaUsuario = pesquisa;
	}

	public void validarAcesso() {
		List<Usuario> usuarios = FachadaBD.getUsuariosPorLoginSenha(
				acessoUsuario.getLogin(), acessoUsuario.getSenha());
		if (usuarios.isEmpty()) {
			acessoUsuario.notificarSemPermissao();
		} else {
			Usuario usuario = usuarios.get(0);
			acessoUsuario.atualizarUsuarioComPermissao(usuario);
		}

	}

	public void pesquisarUsuario() {
		List<Usuario> usuarios = new ArrayList<Usuario>();

		String criterio = pesquisaUsuario.getCpf();
		if (!criterio.equals("")) {
			usuarios = FachadaBD.getUsuariosPorCPF(criterio);
		} else {
			criterio = pesquisaUsuario.getRg();
			if (!criterio.equals("")) {
				usuarios = FachadaBD.getUsuariosPorRG(criterio);
			} else {
				criterio = pesquisaUsuario.getNome();
				if (!criterio.equals("")) {
					usuarios = FachadaBD.
							getUsuariosPorNome(criterio);
				}
			}
		}

		if (usuarios.isEmpty()) {
			pesquisaUsuario.notificarUsuariosNaoEncontrados();
		} else {
			pesquisaUsuario.atualizarUsuariosEncontrados(usuarios);
		}
	}

}
