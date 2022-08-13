package com.mycompany.autenticacaoconta;

import com.mycompany.model.Usuario;
import com.mycompany.model.proxy.ContaCorrente;


public class Aplicacao {

    public static void main(String[] args) {
        
        Usuario mario = new Usuario("mario", "cliente", "mario", "bros");
        ContaCorrente conta1 = new ContaCorrente(mario, "1846", 10000);
        
        System.out.println(conta1.getSaldo());        
        conta1.sacar(100);
        System.out.println(conta1.getSaldo());
        conta1.depositar(1000);
        System.out.println(conta1.getSaldo());
        conta1.sacar(10000);
        System.out.println(conta1.getSaldo());
        conta1.sacar(10000);
        System.out.println(conta1.getSaldo());
    }
}
