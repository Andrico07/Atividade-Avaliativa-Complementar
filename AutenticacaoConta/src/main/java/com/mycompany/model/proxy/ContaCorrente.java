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
            if(usuarioAcesso.isAutorizado() && contaCorrenteReal.isAtiva()) {
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
            if(usuarioAcesso.isAutorizado() && usuarioAcesso.equals(usuarioConta) && valor <= contaCorrenteReal.getSaldo() && contaCorrenteReal.isAtiva()) {
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
            if(usuarioAcesso.isAutorizado() && usuarioAcesso.equals(usuarioConta) && contaCorrenteReal.getSaldo() >= valor && contaCorrenteReal.isAtiva()) {
                contaCorrenteReal.pagar(valor);
                System.out.println("Valor de " + valor + " pago com sucesso.");
            } else if(contaCorrenteReal.getSaldo() >= valor)
                System.out.println("Usuário não autorizado.");
            else
                System.out.println("Saldo insuficiente");        
        }
    }
    
    @Override
    public void transferir(double valor, ContaCorrente contaDestino) {
        usuarioAcesso = processadorAutenticacao.verificarAutenticacao();
        if(usuarioAcesso != null) {
            processadorAutorizacao.verificarAutorizacao(usuarioAcesso, "transferir");
            if(usuarioAcesso.isAutorizado() && usuarioAcesso.equals(usuarioConta) && contaCorrenteReal.getSaldo() >= valor && contaCorrenteReal.isAtiva()) {
                contaCorrenteReal.transferir(valor, contaDestino);
                contaCorrenteReal.sacar(valor);
                System.out.println("Valor de " + valor + " transferido com sucesso.");
        } else if(contaCorrenteReal.getSaldo() >= valor)
            System.out.println("Usuário não autorizado.");
        else
            System.out.println("Saldo insuficiente");
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
            processadorAutorizacao.verificarAutorizacao(usuarioAcesso, "desativar");
            if(usuarioAcesso.isAutorizado()) {
                contaCorrenteReal.ativar();
                System.out.println("Conta ativada com sucesso.");  
            } else
                System.out.println("Usuario não autorizado.");
        }
    }

    @Override
    public String getNumero() {
        usuarioAcesso = processadorAutenticacao.verificarAutenticacao();
        if(usuarioAcesso != null) {
            processadorAutorizacao.verificarAutorizacao(usuarioAcesso, "getNumero");
            if(usuarioAcesso.isAutorizado() && (usuarioAcesso.equals(usuarioConta) || usuarioAcesso.getPerfil().equalsIgnoreCase("GerenteDoBanco"))) {
                return contaCorrenteReal.getNumero();
            } else {
                System.out.println("Usuário não autorizado");
                return null;
            }
        }
        return null;
    }

    @Override
    public double getSaldo() {
        usuarioAcesso = processadorAutenticacao.verificarAutenticacao();
        if(usuarioAcesso != null) {
            processadorAutorizacao.verificarAutorizacao(usuarioAcesso, "getSaldo");
            if(usuarioAcesso.isAutorizado() && (usuarioAcesso.equals(usuarioConta) || usuarioAcesso.getPerfil().equalsIgnoreCase("GerenteDoBanco"))) {
                return contaCorrenteReal.getSaldo();
            }
            else {
                System.out.println("Usuário não autorizado.");
                return -1;
            }
        }
        else{
            System.out.println("Usuário não autorizado.");
            return -1;
        }
    }

    @Override
    public boolean isAtiva() {
        usuarioAcesso = processadorAutenticacao.verificarAutenticacao();
        if(usuarioAcesso != null) {
            processadorAutorizacao.verificarAutorizacao(usuarioAcesso, "isAtiva");
            if(usuarioAcesso.isAutorizado()) {
                return contaCorrenteReal.isAtiva();
            } else {
                System.out.println("Usuário não autorizado");
                return false;
            }
        }
        return false;
    }

    @Override
    public Usuario getUsuario() {
        usuarioAcesso = processadorAutenticacao.verificarAutenticacao();
        if(usuarioAcesso != null) {
            processadorAutorizacao.verificarAutorizacao(usuarioAcesso, "getUsuario");
            if(usuarioAcesso.isAutorizado()) {
                return contaCorrenteReal.getUsuario();
            } else {
                System.out.println("Usuário não autorizado");
                return null;
            }
        }
        return null;
    }
    
}
