package com.mycompany.model.proxy;

import com.mycompany.model.ContaCorrenteProxy;
import com.mycompany.model.Usuario;
import com.mycompany.model.chain.ProcessadorDeAutenticacao;


public class ContaCorrente implements ContaCorrenteProxy {
    
    private Usuario usuarioConta;
    private Usuario usuarioAcesso;
    private final ContaCorrenteReal contaCorrenteReal;
    private ProcessadorDeAutenticacao processador;

    public ContaCorrente(Usuario usuario, String numero, double saldoInicial) {
        this.usuarioConta = usuario;
        contaCorrenteReal = new ContaCorrenteReal(usuario, numero, saldoInicial);
        processador = new ProcessadorDeAutenticacao();
    }
    
    @Override
    public void depositar(double valor) {
        usuarioAcesso = processador.verificarAutenticacao();
        if(usuarioAcesso != null && usuarioAcesso.isAutenticado())
            contaCorrenteReal.depositar(valor);
    }
    
    @Override
    public void sacar(double valor) {
        usuarioAcesso = processador.verificarAutenticacao();
        if(usuarioAcesso != null && usuarioAcesso.isAutenticado() && valor <= contaCorrenteReal.getSaldo())
            contaCorrenteReal.sacar(valor);
    }
    
    @Override
    public void pagar(double valor) {
        usuarioAcesso = processador.verificarAutenticacao();
        if(usuarioAcesso != null && usuarioAcesso.isAutenticado() && valor <= contaCorrenteReal.getSaldo())
            contaCorrenteReal.pagar(valor);
    }
    
    @Override
    public void transferir(double valor, ContaCorrente contaDestino) {
        usuarioAcesso = processador.verificarAutenticacao();
        if(usuarioAcesso != null && usuarioAcesso.isAutenticado() && valor <= contaCorrenteReal.getSaldo())
            contaCorrenteReal.transferir(valor, contaDestino);
    }
    
    @Override
    public void ativar() {
        usuarioAcesso = processador.verificarAutenticacao();
        if(usuarioAcesso != null && usuarioAcesso.isAutenticado())
            contaCorrenteReal.ativar();
    }
    
    @Override
    public void desativar() {
        usuarioAcesso = processador.verificarAutenticacao();
        if(usuarioAcesso != null && usuarioAcesso.isAutenticado())
            contaCorrenteReal.desativar();
    }

    @Override
    public String getNumero() {
        usuarioAcesso = processador.verificarAutenticacao();
        //if(usuarioAcesso != null && usuario.isAutenticado())
            return contaCorrenteReal.getNumero();
    }

    @Override
    public double getSaldo() {
        usuarioAcesso = processador.verificarAutenticacao();
        //if(usuarioAcesso != null && usuario.isAutenticado())
            return contaCorrenteReal.getSaldo();
    }

    @Override
    public boolean isAtiva() {
        usuarioAcesso = processador.verificarAutenticacao();
        //if(usuarioAcesso != null && usuario.isAutenticado())
            return contaCorrenteReal.isAtiva();
    }

    @Override
    public Usuario getUsuario() {
        usuarioAcesso = processador.verificarAutenticacao();
        if(usuarioAcesso != null && usuarioAcesso.isAutenticado())
            return contaCorrenteReal.getUsuario();
        else
            return null;
    }
    
}
