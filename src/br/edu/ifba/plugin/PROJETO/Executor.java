package br.edu.ifba.plugin.PROJETO;

import br.edu.ifba.plugin.PROJETO.controle.ControleAcesso;
import br.edu.ifba.plugin.PROJETO.modelo.ModeloUsuario;
import br.edu.ifba.plugin.PROJETO.visao.IAcessoUsuario;
import br.edu.ifba.plugin.PROJETO.visao.impl.AcessoUsuario;

public class Executor {

	public static void main(String[] args) {
		IAcessoUsuario acessoUsuario = new AcessoUsuario(
				"astro", "mamaee");
		ModeloUsuario modelo = new ModeloUsuario();
		
		ControleAcesso controle = new ControleAcesso();
		controle.setAcessoUsuario(acessoUsuario);
		controle.setModeloUsuario(modelo);
		
		controle.validarAcesso();
	}
	
	
	
	
}
