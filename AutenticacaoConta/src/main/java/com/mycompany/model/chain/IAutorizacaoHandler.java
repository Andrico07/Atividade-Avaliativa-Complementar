package com.mycompany.model.chain;

import com.mycompany.model.Usuario;


public interface IAutorizacaoHandler {
    
    public void verificarAutorizacao(Usuario usuario, String autorizacao);
    
    public void setNextHandler(IAutorizacaoHandler handler);
    
}
