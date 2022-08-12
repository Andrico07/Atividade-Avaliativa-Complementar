package com.mycompany.model.proxy;

import com.mycompany.model.ContaCorrenteProxy;
import com.mycompany.model.Usuario;


class ContaCorrenteReal implements ContaCorrenteProxy {
    
    private String numero;
    private double saldo;
    private boolean ativa;
    private Usuario usuario;

    public ContaCorrenteReal(Usuario usuario, String numero, double saldoInicial) {
        this.usuario = usuario;
        this.numero = numero;
        this.saldo = saldoInicial;
        this.ativa = false;
    }
    
    @Override
    public void depositar(double valor) {
        this.saldo += valor;        
    }
    
    @Override
    public void sacar(double valor) {
        this.saldo -= valor;
    }
    
    @Override
    public void pagar(double valor) {
        this.saldo -= valor;
    }
    
    @Override
    public void transferir(double valor, ContaCorrente contaDestino) {
        this.saldo -= valor;
        contaDestino.depositar(valor);        
    }
    
    @Override
    public void ativar() {
        this.ativa = true;
    }
    
    @Override
    public void desativar() {
        this.ativa = false;
    }

    @Override
    public String getNumero() {
        return numero;
    }

    @Override
    public double getSaldo() {
        return saldo;
    }

    @Override
    public boolean isAtiva() {
        return ativa;
    }

    @Override
    public Usuario getUsuario() {
        return usuario;
    }
    
    private void verificaAtiva() {
        
    }
    
}
