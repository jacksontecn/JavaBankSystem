package com.mowtechnologies.banco.app;

import com.mowtechnologies.banco.model.Banco;
import com.mowtechnologies.banco.model.Conta;

import java.util.Comparator;
import java.util.function.ToIntFunction;

public class PrincipalBancoTeste {

    public static void main(String[] args) {

        Banco banco = new Banco();

        ToIntFunction<Conta> function = (Conta conta) -> {
            return conta.getNumero();
        };

        banco.getContas().sort(Comparator.comparingInt(Conta::getNumero));


        for (Conta conta: banco.getContas()) {
            System.out.println(conta.getAgencia() + "/" + conta.getNumero());
        }

    }
}
