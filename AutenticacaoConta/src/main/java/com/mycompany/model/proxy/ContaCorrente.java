package com.mycompany.model.proxy;

import com.mycompany.model.ContaCorrenteProxy;
import com.mycompany.model.Usuario;
import com.mycompany.model.chain.ProcessadorDeAutenticacao;


public class ContaCorrente implements ContaCorrenteProxy {
    
    private Usuario usuario;
    private final ContaCorrenteReal contaCorrenteReal;
    private ProcessadorDeAutenticacao processador;

    public ContaCorrente(Usuario usuario, String numero, double saldoInicial) {
        this.usuario = usuario;
        contaCorrenteReal = new ContaCorrenteReal(usuario, numero, saldoInicial);
        processador = new ProcessadorDeAutenticacao();
    }
    
    @Override
    public void depositar(double valor) {
        processador.verificarAutenticacao(usuario);
        if(usuario.isAutenticado())
            contaCorrenteReal.depositar(valor);
    }
    
    @Override
    public void sacar(double valor) {
        processador.verificarAutenticacao(usuario);
        if(usuario.isAutenticado() && valor <= contaCorrenteReal.getSaldo())
            contaCorrenteReal.sacar(valor);
    }
    
    @Override
    public void pagar(double valor) {
        processador.verificarAutenticacao(usuario);
        if(usuario.isAutenticado() && valor <= contaCorrenteReal.getSaldo())
            contaCorrenteReal.pagar(valor);
    }
    
    @Override
    public void transferir(double valor, ContaCorrente contaDestino) {
        processador.verificarAutenticacao(usuario);
        if(usuario.isAutenticado() && valor <= contaCorrenteReal.getSaldo())
            contaCorrenteReal.transferir(valor, contaDestino);
    }
    
    @Override
    public void ativar() {
        processador.verificarAutenticacao(usuario);
        if(usuario.isAutenticado())
            contaCorrenteReal.ativar();
    }
    
    @Override
    public void desativar() {
        processador.verificarAutenticacao(usuario);
        if(usuario.isAutenticado())
            contaCorrenteReal.desativar();
    }

    @Override
    public String getNumero() {
        processador.verificarAutenticacao(usuario);
        //if(usuario.isAutenticado())
            return contaCorrenteReal.getNumero();
    }

    @Override
    public double getSaldo() {
        processador.verificarAutenticacao(usuario);
        //if(usuario.isAutenticado())
            return contaCorrenteReal.getSaldo();
    }

    @Override
    public boolean isAtiva() {
        processador.verificarAutenticacao(usuario);
        //if(usuario.isAutenticado())
            return contaCorrenteReal.isAtiva();
    }

    @Override
    public Usuario getUsuario() {
        processador.verificarAutenticacao(usuario);
        if(usuario.isAutenticado())
            return contaCorrenteReal.getUsuario();
        else
            return null;
    }
    
}
