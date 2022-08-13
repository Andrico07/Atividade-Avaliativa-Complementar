package com.mycompany.model.chain;

import com.mycompany.model.AutenticacaoSenha;
import com.mycompany.model.Usuario;


public class ProcessadorDeAutenticacao {
    
    private IAutenticacaoHandler first;
    

    public ProcessadorDeAutenticacao() {
        this.first = new AutenticacaoSenha();
        //addHandler(new AutenticacaoToken());
    }    
    
    public void addHandler(IAutenticacaoHandler handler) {
        this.first.setNextHandler(handler);
    }
    
    public void verificarAutenticacao(Usuario usuario) {
        this.first.verificarAutenticacao(usuario);
    }

    public void setFirst(IAutenticacaoHandler first) {
        this.first = first;
    }
    
}
