package com.mycompany.autenticacaoconta;

import com.mycompany.model.Autorizacaofacade;
import java.util.Random;

import com.mycompany.model.Usuario;
import com.mycompany.model.DAO.BancoSimulator;
import com.mycompany.model.proxy.ContaCorrente;

public class Aplicacao {

	public static void main( String[] args ) {

		String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		Random gerador = new Random();
		String sms = new String();
		for( int i = 0; i < 6; i++ ) {
			sms = sms + ( letras.charAt( gerador.nextInt( letras.length() ) ) );
		}
		System.out.println( sms );

		BancoSimulator dao = BancoSimulator.getInstancia();
                Autorizacaofacade facade = new Autorizacaofacade();
		Usuario mario = new Usuario( "mario", "cliente", "mario", "bros" );
		Usuario didico = new Usuario( "Didico", "cliente", "didico", "darksouls" );
		dao.insert( mario );
		dao.insert( didico );
		ContaCorrente conta1 = new ContaCorrente( mario, "1846", 10000 );
                
                facade.adicionarAutorizacao(mario);
                facade.adicionarAutorizacao(didico);
               

		System.out.println( conta1.getSaldo() );
		conta1.sacar( 100 );
		System.out.println( conta1.getSaldo() );
		conta1.depositar( 1000 );
		System.out.println( conta1.getSaldo() );
		conta1.sacar( 10000 );
		System.out.println( conta1.getSaldo() );
		conta1.sacar( 10000 );
		System.out.println( conta1.getSaldo() );
	}
}
