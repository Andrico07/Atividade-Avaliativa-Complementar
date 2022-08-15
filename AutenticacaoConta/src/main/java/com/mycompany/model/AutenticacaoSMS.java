package com.mycompany.model;

import com.mycompany.model.chain.AbstractAutenticacao;
import java.util.Random;
import java.util.Scanner;


public class AutenticacaoSMS extends AbstractAutenticacao {

    @Override
    public Usuario verificarAutenticacao() {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random gerador = new Random();
        String sms = new String();
        for( int i = 0; i < 6; i++ ) {
            sms = sms + ( letras.charAt( gerador.nextInt( letras.length() ) ) );
        }
        
        System.out.print("Enviaremos um código de verificação para seu telefone de contato");
        try {
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.println(".\n");
            Thread.sleep(1000);
            System.out.print(sms);
            System.out.println("\t(Finge que foi para o seu celular)");
            System.out.println("Insira o código: ");
            Scanner scan = new Scanner( System.in );
            String codigo = scan.next();
            
            if(codigo.equals(sms)) {
                if( nextHandler != null )
                    return nextHandler.verificarAutenticacao();
                else
                    return null;
            }            
            
        } catch (InterruptedException e) {
            System.out.println("Erro ao enviar o código" + e.getMessage());
        }
        
        return null;
    }
    
}
