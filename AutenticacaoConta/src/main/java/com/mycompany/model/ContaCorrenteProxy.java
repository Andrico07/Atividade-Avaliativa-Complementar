package com.mycompany.model;

import com.mycompany.model.proxy.ContaCorrente;


public interface ContaCorrenteProxy {
    
    
    public void depositar(double valor);
    
    public void sacar(double valor);
    
    public void pagar(double valor);
    
    public void transferir(double valor, ContaCorrente contaDestino);
    
    public void ativar();
    
    public void desativar();

    public String getNumero();

    public double getSaldo();

    public boolean isAtiva();

    public Usuario getUsuario();
    
}
