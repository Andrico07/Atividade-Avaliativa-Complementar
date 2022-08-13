package com.mycompany.model.chain;


public abstract class AbstractAutenticacao implements IAutenticacaoHandler {
    
    protected IAutenticacaoHandler nextHandler;
    
    @Override
    public void setNextHandler(IAutenticacaoHandler nextHandler) {
        if(this.nextHandler == null)
            this.nextHandler = nextHandler;
        else
            this.nextHandler.setNextHandler(nextHandler);
    }
    
}
