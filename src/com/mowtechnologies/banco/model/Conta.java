package com.mowtechnologies.banco.model;

import com.mowtechnologies.banco.model.excecao.SaldoInsuficienteException;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Conta {

    private Pessoa titular;
    private int agencia;
    private int numero;
    private BigDecimal saldo = BigDecimal.ZERO;

    public Conta(){

    }

    public  Conta(Pessoa titular, int agencia, int numero){

        Objects.requireNonNull(titular);

        this.titular = titular;
        this.agencia = agencia;
        this.numero = numero;

    }

    public Pessoa getTitular() {
        return titular;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void depositar(BigDecimal valor){
        if (valor.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalStateException("Valor deve ser maior que 0");
        }
        saldo = saldo.add(valor);
    }

    public void sacar(BigDecimal valor){
        if (valor.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalStateException("Valor deve ser maior que 0");
        }
        if (getSaldoDisponivel().subtract(valor).compareTo(BigDecimal.ZERO)  < 0){
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }
        saldo = saldo.subtract(valor);
    }

    public void sacar (BigDecimal valor, BigDecimal taxaSaque){
        sacar(valor.add(taxaSaque));
    }

    public BigDecimal getSaldoDisponivel(){
        return getSaldo();
    }

    public abstract void debitarTarifaMensal();

}
