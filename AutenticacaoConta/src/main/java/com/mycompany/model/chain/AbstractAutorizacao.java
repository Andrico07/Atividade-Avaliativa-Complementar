package com.mycompany.model.chain;


public abstract class AbstractAutorizacao implements IAutorizacaoHandler {
    
    protected IAutorizacaoHandler nextHandler;
    
    @Override
    public void setNextHandler(IAutorizacaoHandler nextHandler) {
        if(this.nextHandler == null)
            this.nextHandler = nextHandler;
        else
            this.nextHandler.setNextHandler(nextHandler);
    }
    
}
