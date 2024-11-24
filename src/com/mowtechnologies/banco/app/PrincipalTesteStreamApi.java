package com.mowtechnologies.banco.app;

import com.mowtechnologies.banco.model.Banco;
import com.mowtechnologies.banco.model.Conta;
import com.mowtechnologies.banco.model.Pessoa;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrincipalTesteStreamApi {
    public static void main(String[] args) {

        Banco banco = new Banco();

        Stream<Conta> stream = banco.getContas().stream();

        List<Pessoa> titulares = banco.getContas().stream()
                        .map(Conta::getTitular)
                        .distinct()
                        .toList();

        System.out.println();

        System.out.println(titulares);

        System.out.println();

        System.out.println("-----------------------------------------------------");

        System.out.println();

        BigDecimal saldoTotal = banco.getContas().stream()
                .map(Conta::getSaldo)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(saldoTotal);

        System.out.println();

        System.out.println("-----------------------------------------------------");

        System.out.println();

        banco.getContas().stream()
                .filter(conta -> conta.getSaldo().compareTo(new BigDecimal("50")) > 0)
                .filter(conta -> conta.getNumero() > 200)
                .map(Conta::getTitular)
                .distinct()
                .forEach(System.out::println);

        System.out.println();

        System.out.println("-----------------------------------------------------");

        System.out.println();

        stream.forEach(conta -> {
//            conta.depositar(new BigDecimal("10"));
            System.out.println(conta.getAgencia() + "/" + conta.getNumero() + " = " + conta.getSaldo());
        });

    }
}
