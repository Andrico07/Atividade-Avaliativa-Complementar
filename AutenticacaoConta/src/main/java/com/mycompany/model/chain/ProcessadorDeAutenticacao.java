package com.mycompany.model.chain;

import com.mycompany.model.AutenticacaoSenha;
import com.mycompany.model.Usuario;

public class ProcessadorDeAutenticacao {
    
    private IAutenticacaoHandler first;
    

    public ProcessadorDeAutenticacao() {
        this.first = new AutenticacaoSenha();
        //addHandler(new AutenticacaoSMS());
    }    
    
    public void addHandler(IAutenticacaoHandler handler) {
        this.first.setNextHandler(handler);
    }
    
    public Usuario verificarAutenticacao() {
        return this.first.verificarAutenticacao();
    }

    public void setFirst(IAutenticacaoHandler first) {
        this.first = first;
    }
    
}
