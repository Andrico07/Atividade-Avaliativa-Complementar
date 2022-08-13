package com.mycompany.model.chain;

import com.mycompany.model.Usuario;


public interface IAutenticacaoHandler {
    
    public Usuario verificarAutenticacao();
    
    public void setNextHandler(IAutenticacaoHandler handler);
    
}
