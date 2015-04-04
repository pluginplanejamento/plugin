package br.edu.ifba.plugin.PROJETO.modelo;

import java.util.List;

import br.edu.ifba.plugin.PROJETO.modelo.bd.FachadaBD;
import br.edu.ifba.plugin.PROJETO.modelo.beans.Usuario;
import br.edu.ifba.plugin.PROJETO.visao.IAcessoUsuario;

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

	public void setAcessoUsuario(IAcessoUsuario acesso) {
		this.acessoUsuario = acesso;
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

}
