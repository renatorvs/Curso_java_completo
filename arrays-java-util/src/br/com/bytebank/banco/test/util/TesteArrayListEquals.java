package br.com.bytebank.banco.test.util;

import java.util.ArrayList;

import br.com.bitebank.banco.modelo.Conta;
import br.com.bitebank.banco.modelo.ContaCorrente;

public class TesteArrayListEquals {

        public static void main(String[] args) {

        //Generics
        ArrayList<Conta> lista = new ArrayList<Conta>();

        Conta cc = new ContaCorrente(22, 11);
        lista.add(cc);

        Conta cc2 = new ContaCorrente(22, 22);
        lista.add(cc2);

        boolean existe = lista.contains(cc2);

        System.out.println("J� existe? " + existe);

        for(Conta conta : lista) {
                System.out.println(conta);
        }
    }
        
}