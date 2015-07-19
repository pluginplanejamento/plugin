package br.edu.ifba.plugin.PROJETO.modelo.bd.estatico;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Mock de acesso a banco de dados. Utiliza colecoes estaticas para
 * simular manipulacao de banco.
 * 
 * OBS.: deve ser substituido por fachada(s) real(is).
 * 
 * @author PLUGIN
 */
public class UsuarioDAO {

	private static Map<Integer, Usuario> usuarios = 
			new TreeMap<Integer, Usuario>();
	
	static {
		
		Usuario u1 = new Usuario();
		u1.setId(1);
		u1.setCpf("123-4");
		u1.setRg("321-1");
		u1.setCtps("456-7");
		u1.setNome("Astrogildo da Silva");
		u1.setLogin("astro");
		u1.setSenha("123");
		
		usuarios.put(u1.getId(), u1);
		
		Usuario u2 = new Usuario();
		u2.setId(2);
		u2.setCpf("789-0");
		u2.setRg("987-6");
		u2.setCtps("567-8");
		u2.setNome("Estelvania da Silva");
		u2.setLogin("telva");
		u2.setSenha("456");
		
		usuarios.put(u2.getId(), u2);
	}
	
	public static List<Usuario> getUsuariosPorLoginSenha(
			String login,
			String senha) {
		List<Usuario> encontrados = new ArrayList<Usuario>();
		
		for (Usuario u : usuarios.values()) {
			if (u.getLogin().equals(login) && 
					u.getSenha().equals(senha)) {
				encontrados.add(u);
			}
		}
		
		return encontrados;
	}
	
	public static List<Usuario> getUsuariosPorCPF(String cpf)
	{
		List<Usuario> encontrados = new ArrayList<Usuario>();
		
		for (Usuario u : usuarios.values()) {
			if (u.getCpf().equals(cpf)) {
				encontrados.add(u);
			}
		}
		
		return encontrados;
	}

	public static List<Usuario> getUsuariosPorRG(String rg)
	{
		List<Usuario> encontrados = new ArrayList<Usuario>();
		
		for (Usuario u : usuarios.values()) {
			if (u.getRg().equals(rg)) {
				encontrados.add(u);
			}
		}
		
		return encontrados;
	}
	
	public static List<Usuario> getUsuariosPorNome(
			String nome)
	{
		List<Usuario> encontrados = new ArrayList<Usuario>();
		
		for (Usuario u : usuarios.values()) {
			if (u.getNome().toLowerCase().
					contains(nome.toLowerCase())) {
				encontrados.add(u);
			}
		}
		
		return encontrados;
	}
	
	public static void remover(int id) {
		usuarios.remove(id);
	}
}











