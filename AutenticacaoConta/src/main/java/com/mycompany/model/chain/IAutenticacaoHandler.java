package com.mycompany.model.chain;

import com.mycompany.model.Usuario;


public interface IAutenticacaoHandler {
    
    public void verificarAutenticacao(Usuario usuario);
    
    public void setNextHandler(IAutenticacaoHandler handler);
    
}
