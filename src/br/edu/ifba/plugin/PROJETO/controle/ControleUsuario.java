package br.edu.ifba.plugin.PROJETO.controle;

import br.edu.ifba.plugin.PROJETO.modelo.ModeloUsuario;
import br.edu.ifba.plugin.PROJETO.visao.IPesquisaUsuario;

public class ControleUsuario {

	private IPesquisaUsuario pesquisaUsuario;
	private ModeloUsuario modeloUsuario;

	public void setPesquisaUsuario(IPesquisaUsuario pesquisa) {
		this.pesquisaUsuario = pesquisa;
	}

	public void setModeloUsuario(ModeloUsuario modelo) {
		this.modeloUsuario = modelo;
	}

	public void pesquisar() {
		modeloUsuario.setPesquisaUsuario(pesquisaUsuario);
		modeloUsuario.pesquisarUsuario();
	}

}
