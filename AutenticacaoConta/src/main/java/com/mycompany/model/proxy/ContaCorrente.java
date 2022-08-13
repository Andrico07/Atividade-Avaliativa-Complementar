package com.mycompany.model.proxy;

import com.mycompany.model.ContaCorrenteProxy;
import com.mycompany.model.Usuario;
import com.mycompany.model.chain.ProcessadorDeAutenticacao;
import com.mycompany.model.chain.ProcessadorDeAutorizacao;


public class ContaCorrente implements ContaCorrenteProxy {
    
    private Usuario usuarioConta;
    private Usuario usuarioAcesso;
    private final ContaCorrenteReal contaCorrenteReal;
    private ProcessadorDeAutenticacao processadorAutenticacao;
    private ProcessadorDeAutorizacao processadorAutorizacao;

    public ContaCorrente(Usuario usuario, String numero, double saldoInicial) {
        this.usuarioConta = usuario;
        contaCorrenteReal = new ContaCorrenteReal(usuario, numero, saldoInicial);
        processadorAutenticacao = new ProcessadorDeAutenticacao();
        processadorAutorizacao = new ProcessadorDeAutorizacao();
    }
    
    @Override
    public void depositar(double valor) {
        usuarioAcesso = processadorAutenticacao.verificarAutenticacao();
        if(usuarioAcesso != null) {
            processadorAutorizacao.verificarAutorizacao(usuarioAcesso, "depositar");
            if(usuarioAcesso.isAutorizado()) {
                contaCorrenteReal.depositar(valor);
                System.out.println("Valor de " + valor + " depositado com sucesso.");
            }
            else
                System.out.println("Usuário não autorizado.");
        }
    }
    
    @Override
    public void sacar(double valor) {
        usuarioAcesso = processadorAutenticacao.verificarAutenticacao();
        if(usuarioAcesso != null) {
            processadorAutorizacao.verificarAutorizacao(usuarioAcesso, "sacar");
            if(usuarioAcesso.isAutorizado() && usuarioAcesso.equals(usuarioConta) && valor <= contaCorrenteReal.getSaldo()) {
                contaCorrenteReal.sacar(valor);
                System.out.println("Valor de " + valor + " sacado com sucesso.");
            } else if(valor <= contaCorrenteReal.getSaldo())
                System.out.println("Usuário não autorizado.");
            else
                System.out.println("Saldo insuficiente");
        }
    }
    
    @Override
    public void pagar(double valor) {
        usuarioAcesso = processadorAutenticacao.verificarAutenticacao();
        if(usuarioAcesso != null) {
            processadorAutorizacao.verificarAutorizacao(usuarioAcesso, "pagar");
            if(usuarioAcesso.isAutorizado() && usuarioAcesso.equals(usuarioConta) && contaCorrenteReal.getSaldo() <= 0) {
                contaCorrenteReal.pagar(valor);
                System.out.println("Valor de " + valor + " pago com sucesso.");
            } else if(contaCorrenteReal.getSaldo() <= 0)
                System.out.println("Usuário não autorizado.");
            else
                System.out.println("Saldo insuficiente (0 ou negativo)");        
        }
    }
    
    @Override
    public void transferir(double valor, ContaCorrente contaDestino) {
        usuarioAcesso = processadorAutenticacao.verificarAutenticacao();
        if(usuarioAcesso != null) {
            processadorAutorizacao.verificarAutorizacao(usuarioAcesso, "transferir");
            if(usuarioAcesso.isAutorizado() && usuarioAcesso.equals(usuarioConta) && contaCorrenteReal.getSaldo() <= 0) {
                contaCorrenteReal.transferir(valor, contaDestino);
                System.out.println("Valor de " + valor + " pago com sucesso.");
        } else if(contaCorrenteReal.getSaldo() <= 0)
            System.out.println("Usuário não autorizado.");
        else
            System.out.println("Saldo insuficiente (0 ou negativo)");
        }
    }
    
    @Override
    public void ativar() {
        usuarioAcesso = processadorAutenticacao.verificarAutenticacao();
        if(usuarioAcesso != null) {
            processadorAutorizacao.verificarAutorizacao(usuarioAcesso, "ativar");
            if(usuarioAcesso.isAutorizado()) {
                contaCorrenteReal.ativar();
                System.out.println("Conta ativada com sucesso.");  
            } else
                System.out.println("Usuario não autorizado.");
        }
    }
        
    
    @Override
    public void desativar() {
        usuarioAcesso = processadorAutenticacao.verificarAutenticacao();
        if(usuarioAcesso != null) {
            processadorAutorizacao.verificarAutorizacao(usuarioAcesso, "ativar");
            if(usuarioAcesso.isAutorizado()) {
                contaCorrenteReal.ativar();
                System.out.println("Conta ativada com sucesso.");  
            } else
                System.out.println("Usuario não autorizado.");
        }
    }

    @Override
    public String getNumero() {
            return contaCorrenteReal.getNumero();
    }

    @Override
    public double getSaldo() {
        usuarioAcesso = processadorAutenticacao.verificarAutenticacao();
        if(usuarioAcesso != null)
            return contaCorrenteReal.getSaldo();
        else
            return -1;
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
