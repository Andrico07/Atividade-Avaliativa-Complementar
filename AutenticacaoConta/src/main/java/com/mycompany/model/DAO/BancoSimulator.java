package com.mycompany.model.DAO;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.model.Usuario;

public class BancoSimulator {

	private List<Usuario> banco;
	private static BancoSimulator instancia;

	private BancoSimulator() {
		banco = new ArrayList<>();
	}

	public static BancoSimulator getInstancia() {
		if( instancia == null ) {
			instancia = new BancoSimulator();
			return instancia;
		}
		return instancia;
	}

	public void insert( Usuario usuario ) {
		banco.add( usuario );
	}

	public boolean find( Usuario usuario ) {
		for( Usuario user : banco ) {
			if( user.equals( usuario ) ) {
				return true;
			}
		}
		return false;
	}

	public Usuario findNomeUsuarioSenha( String usuario, String senha ) {
		for( Usuario user : banco ) {
			if( user.getNomeUsuario().equals( usuario ) && user.getSenha().equals( senha ) ) {
				return user;
			}
		}
		return null;
	}

	public void delete( Usuario usuario ) {
		if( find( usuario ) )
			banco.remove( usuario );
	}

}
