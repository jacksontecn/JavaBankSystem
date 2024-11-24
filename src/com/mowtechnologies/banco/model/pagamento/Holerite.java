package com.mowtechnologies.banco.model.pagamento;

import com.mowtechnologies.banco.model.Pessoa;

import java.math.BigDecimal;

public class Holerite implements DocumentoPagavel{

    private Pessoa funcionario;
    private BigDecimal valorHora;
    private int quantidadeHoras;
    private boolean pago;

    public Holerite(Pessoa funcionario, BigDecimal valorHora, int quantidadeHoras) {
        this.funcionario = funcionario;
        this.valorHora = valorHora;
        this.quantidadeHoras = quantidadeHoras;
    }

    @Override
    public BigDecimal getValorTotal() {
        return valorHora.multiply(new BigDecimal(quantidadeHoras));
    }

    @Override
    public boolean estaPago() {
        return false;
    }

    @Override
    public void quitarPagamento() {

    }
}
