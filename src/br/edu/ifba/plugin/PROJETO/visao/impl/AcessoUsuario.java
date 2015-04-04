package br.edu.ifba.plugin.PROJETO.visao.impl;

import br.edu.ifba.plugin.PROJETO.modelo.beans.Usuario;
import br.edu.ifba.plugin.PROJETO.visao.IAcessoUsuario;

/**
 * Concretizacao de interface para validacao de credenciais (login + senha) de
 * acesso do usuario.
 * 
 * Esta concretizacao pode ser utilizada para validar requisitos relacionados ao
 * controle de acesso de usuarios aas funcionalidades do sistema. Nao sao
 * tratados recursos graficos/visuais de interacao do usuario (e.g. tela de
 * login). Toda a interacao eh realizada atraves do console da aplicacao.
 * 
 * @author PLUGIN
 */
public class AcessoUsuario implements IAcessoUsuario {

	private String login, senha;

	public AcessoUsuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}

	@Override
	public String getLogin() {
		return login;
	}

	@Override
	public String getSenha() {
		return senha;
	}

	@Override
	public void atualizarUsuarioComPermissao(Usuario usuario) {
		System.out.println("Usuário com permissão de acesso = "
				+ usuario.getNome());
	}

	@Override
	public void notificarSemPermissao() {
		System.out.println("Informações inválidas!");
	}

}
