package com.mycompany.model;

import com.mycompany.model.DAO.BancoSimulator;
import com.mycompany.model.chain.AbstractAutenticacao;
import java.util.Scanner;


public class AutenticacaoSenha extends AbstractAutenticacao {

    @Override
    public Usuario verificarAutenticacao() {
        Scanner scan = new Scanner(System.in);
        BancoSimulator dao = new BancoSimulator();
        System.out.println("Digite seu nome de usuário: ");
        String nomeUsuario = scan.next();
        System.out.println("Digite sua senha: ");
        String senha = scan.next();
        var usuario = dao.findNomeUsuarioSenha(nomeUsuario, senha);
        if(usuario != null) {
            if(nextHandler == null) {
                usuario.setAutenticado(true);
                return usuario;
            }
            else
                return nextHandler.verificarAutenticacao();
        } else {
            System.out.println("Nome de usuário ou senha inválidos. Por favor, tente novamente.");
            return null;
            //usuario.setAutorizado(false);
        }     
    }
    
}
