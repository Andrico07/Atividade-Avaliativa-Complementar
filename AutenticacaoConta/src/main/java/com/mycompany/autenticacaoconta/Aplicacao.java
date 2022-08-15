package com.mycompany.autenticacaoconta;

import com.mycompany.model.AutorizacaoFacade;

import com.mycompany.model.Usuario;
import com.mycompany.model.DAO.BancoSimulator;
import com.mycompany.model.proxy.ContaCorrente;

public class Aplicacao {
    
    public static void main( String[] args ) {
        
        BancoSimulator dao = BancoSimulator.getInstancia();
        AutorizacaoFacade facade = new AutorizacaoFacade();
        
        Usuario mario = new Usuario("Mario", "Cliente", "mario", "bros");
        Usuario andrico = new Usuario("Andrico", "Cliente", "didico", "darksouls");
        Usuario clayton = new Usuario("Clayton", "GerenteDoBanco", "clayton", "gangof4");
        
        ContaCorrente conta1 = new ContaCorrente(mario, "1846", 5000);
        ContaCorrente conta2 = new ContaCorrente(andrico, "7593", 3000);
        
        dao.insert(mario);
        dao.insert(andrico);
        dao.insert(clayton);
        
        facade.adicionarAutorizacao(mario);
        facade.adicionarAutorizacao(andrico);
        facade.adicionarAutorizacao(clayton);
        
        
        System.out.println("Ativando conta1");
        conta1.ativar();
        System.out.println("Ativando conta2");
        conta2.ativar();
        
        System.out.println("Depositando 1000$ na conta2");        
        conta2.depositar(1000);
        System.out.println("Solicitando saldo conta2");
        System.out.println(conta2.getSaldo());
        System.out.println("Sacando 1000$ da conta1");
        conta1.sacar(1000);
        System.out.println("Solicitando saldo conta1");
        System.out.println(conta1.getSaldo());
        System.out.println("Transferindo 2765$ da conta2 para a conta1");
        conta2.transferir(2765, conta1);
        System.out.println("Solicitando saldo conta1");
        System.out.println(conta1.getSaldo());
        conta2.depositar(2000);
        System.out.println("Solicitando saldo conta1");
        System.out.println(conta1.getSaldo());
        
	}
}
