package com.mycompany.model;

import com.mycompany.model.chain.AbstractAutenticacao;
import java.util.Random;


public class AutorizacaoSMS extends AbstractAutenticacao {

    @Override
    public Usuario verificarAutenticacao() {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random gerador = new Random();
        String sms = new String();
        for( int i = 0; i < 6; i++ ) {
            sms = sms + ( letras.charAt( gerador.nextInt( letras.length() ) ) );
        }
        
        System.out.println( sms );
        
        /*if( nextHandler == null ) {
            usuario.setAutenticado( true );
        } else
            nextHandler.setNextHandler(nextHandler);*/
        
        return null;
    }
    
}
