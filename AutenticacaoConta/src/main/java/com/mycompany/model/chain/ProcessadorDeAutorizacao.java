package com.mycompany.model.chain;

import com.mycompany.model.AutorizacaoCliente;
import com.mycompany.model.AutorizacaoGerenteBanco;
import com.mycompany.model.Usuario;

public class ProcessadorDeAutorizacao {
    
    private IAutorizacaoHandler first;
    

    public ProcessadorDeAutorizacao() {
        this.first = new AutorizacaoCliente();
        addHandler(new AutorizacaoGerenteBanco());
    }    
    
    public void addHandler(IAutorizacaoHandler handler) {
        this.first.setNextHandler(handler);
    }
    
    public void verificarAutorizacao(Usuario usuario, String autorizacao) {
        this.first.verificarAutorizacao(usuario, autorizacao);
    }

    public void setFirst(IAutorizacaoHandler first) {
        this.first = first;
    }
    
}
