package br.edu.ifba.plugin.PROJETO.visao;

import br.edu.ifba.plugin.PROJETO.modelo.bd.estatico.Usuario;

public interface ICadastroUsuario {
	
	public Usuario getUsuario();
	
	///////////////////////
	
	public void notificarUsuarioGravado(Usuario usuario);
	
	public void notificarErroGravacao();
	
}
