package com.mowtechnologies.banco.app;

import com.mowtechnologies.banco.model.Banco;
import com.mowtechnologies.banco.model.Conta;

import java.util.Optional;

public class PrincipalTesteOptional {

    public static void main(String[] args) {
        Banco banco = new Banco();

        Optional<Conta> contaEncontrada = banco.buscar(123, 333);

        contaEncontrada.ifPresent(conta -> System.out.println(conta.getSaldo()));

//        Conta contaTeste = contaEncontrada.get();
//        System.out.println(contaTeste.getSaldo());

    }

}
