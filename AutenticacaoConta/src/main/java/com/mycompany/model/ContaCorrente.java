package com.mycompany.model;


public class ContaCorrente {
    
    private String numero;
    private double saldo;
    private boolean ativa;
    private Usuario usuario;

    public ContaCorrente(Usuario usuario, String numero, double saldoInicial) {
        this.usuario = usuario;
        this.numero = numero;
        this.saldo = saldoInicial;
    }
    
    public void depositar(double valor) {
        this.saldo += valor;        
    }
    
    public void sacar(double valor) {
        this.saldo -= valor;
    }
    
    public void pagar(double valor) {
        this.saldo -= valor;
    }
    
    public void transferir(double valor, ContaCorrente contaDestino) {
        this.saldo -= valor;
        contaDestino.depositar(valor);        
    }
    
    public void ativar() {
        this.ativa = true;
    }
    
    public void desativar() {
        this.ativa = false;
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    private void verificaAtiva() {
        
    }
    
}
