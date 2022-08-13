package com.mycompany.model.proxy;

import com.mycompany.model.ContaCorrenteProxy;
import com.mycompany.model.Usuario;


public class ContaCorrente implements ContaCorrenteProxy {


    private final ContaCorrenteReal contaCorrenteReal;

    public ContaCorrente(Usuario usuario, String numero, double saldoInicial) {
        contaCorrenteReal = new ContaCorrenteReal(usuario, numero, saldoInicial);
    }
    
    @Override
    public void depositar(double valor) {
        contaCorrenteReal.depositar(valor);
    }
    
    @Override
    public void sacar(double valor) {
        if(valor <= contaCorrenteReal.getSaldo())
            contaCorrenteReal.sacar(valor);
    }
    
    @Override
    public void pagar(double valor) {
        if(valor <= contaCorrenteReal.getSaldo())
            contaCorrenteReal.pagar(valor);
    }
    
    @Override
    public void transferir(double valor, ContaCorrente contaDestino) {
        if(valor <= contaCorrenteReal.getSaldo())
            contaCorrenteReal.transferir(valor, contaDestino);
    }
    
    @Override
    public void ativar() {
        contaCorrenteReal.ativar();
    }
    
    @Override
    public void desativar() {
        contaCorrenteReal.desativar();
    }

    @Override
    public String getNumero() {
        return contaCorrenteReal.getNumero();
    }

    @Override
    public double getSaldo() {
        return contaCorrenteReal.getSaldo();
    }

    @Override
    public boolean isAtiva() {
        return contaCorrenteReal.isAtiva();
    }

    @Override
    public Usuario getUsuario() {
        return contaCorrenteReal.getUsuario();
    }
    
}
