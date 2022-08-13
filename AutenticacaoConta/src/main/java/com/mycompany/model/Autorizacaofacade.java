package com.mycompany.model;

public class Autorizacaofacade {

	public void adicionarAutorizacao( Usuario user ) {
		if( user.getPerfil().equalsIgnoreCase( "cliente" ) ) {
			user.add( "depositar" );
			user.add( "sacar" );
			user.add( "pagar" );
			user.add( "desativar" );
			user.add( "transferir" );
			user.add( "getSaldo" );
			user.add( "getNumero" );
			user.add( "isAtiva" );
			user.add( "getUsuario" );
			return;
		}
		if( user.getPerfil().equalsIgnoreCase( "GerenteDoBanco" ) ) {
			user.add( "ativar" );
			user.add( "desativar" );
			user.add( "transferir" );
			user.add( "getSaldo" );
			user.add( "getNumero" );
			user.add( "isAtiva" );
			user.add( "getUsuario" );
			return;
		}
		System.out.println( "O perfil digitado não é válido" );
	}
}
