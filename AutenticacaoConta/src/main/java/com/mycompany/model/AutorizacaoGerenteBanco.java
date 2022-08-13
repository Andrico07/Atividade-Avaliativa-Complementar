package com.mycompany.model;

import com.mycompany.model.chain.AbstractAutorizacao;


public class AutorizacaoGerenteBanco extends AbstractAutorizacao {

    @Override
    public void verificarAutorizacao(Usuario usuario, String autorizacao) {
        if(usuario.getPerfil().equals("GerenteDoBanco")) {
            for(String autoriza : usuario.getAutorizacoes())
                if(autoriza.equals(autorizacao))
                    usuario.setAutorizado(true);            
        } else if(nextHandler == null)
            usuario.setAutorizado(false);
        else
            nextHandler.verificarAutorizacao(usuario, autorizacao);
    }
    
}
