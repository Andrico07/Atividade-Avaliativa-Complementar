package com.mycompany.model;

import com.mycompany.model.chain.AbstractAutenticacao;
import java.util.Scanner;


public class AutenticacaoSenha extends AbstractAutenticacao {

    @Override
    public void verificarAutenticacao(Usuario usuario) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite seu nome de usuário: ");
        String nomeUsuario = scan.next();
        System.out.println("Digite sua senha: ");
        String senha = scan.next();
        if(nomeUsuario.equals(usuario.getNomeUsuario()) && senha.equals(usuario.getSenha()))
            if(nextHandler == null)
                usuario.setAutenticado(true);
            else
                nextHandler.verificarAutenticacao(usuario);
        else {
            System.out.println("Nome de usuário ou senha inválidos. Por favor, tente novamente.");
            usuario.setAutorizado(false);
        }
        
    }
    
}
