package com.mowtechnologies.banco.app;


import com.mowtechnologies.banco.model.ContaEspecial;
import com.mowtechnologies.banco.model.ContaInvestimento;
import com.mowtechnologies.banco.model.Pessoa;
import com.mowtechnologies.banco.model.TipoPessoa;
import com.mowtechnologies.banco.model.atm.CaixaEletronico;
import com.mowtechnologies.banco.model.excecao.SaldoInsuficienteException;
import com.mowtechnologies.banco.model.pagamento.Boleto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        Pessoa titular1 = new Pessoa();

        titular1.setNome("Jackson Souza");
        titular1.setDocumento("12312323");
        titular1.setRendimentoAnual(new BigDecimal("15000"));
        titular1.setTipo(TipoPessoa.JURIDICA);

//        titular1.setDataUltimaAtualizacao(LocalDateTime.parse("2024-11-09T10:00:05"));
        System.out.println(titular1.getDataUltimaAtualizacao());

        Pessoa titular2 = new Pessoa();

        titular2.setNome("Aline Marques");
        titular2.setDocumento("435435435");

        CaixaEletronico caixaEletronico = new CaixaEletronico();

        ContaEspecial conta = new ContaEspecial(titular1, 1234, 987654,new BigDecimal("1000"));


        conta.depositar(new BigDecimal("15000"));


        ContaInvestimento conta1 = new ContaInvestimento(titular2, 1222, 9875554);


        conta1.depositar(new BigDecimal("700"));

//        caixaEletronico.imprimirSaldo(conta);

        System.out.println();

        caixaEletronico.imprimirSaldo(conta1);

        System.out.println();
//        System.out.println();

//        conta.sacar(15_500);
//        conta1.sacar(3_000);
        conta1.creditarRendimentos(new BigDecimal("0.8"));


//        caixaEletronico.imprimirSaldo(conta);

        System.out.println();

//        caixaEletronico.imprimirSaldo(conta1);
//        System.out.println();
//        conta1.debitarTarifaMensal();
//        caixaEletronico.imprimirSaldo(conta1);

        Boleto boleto = new Boleto(titular2,new BigDecimal("800"));
        try{
            System.out.println(boleto.estaPago());
            caixaEletronico.pagar(boleto, conta1);
            System.out.println(boleto.estaPago());
            caixaEletronico.imprimirSaldo(conta1);
        }catch (SaldoInsuficienteException e){
            System.out.println("Operação não realizada: " + e.getMessage());
        }

        System.out.println();
        System.out.println(boleto.estaPago());

        try {
            caixaEletronico.estornarPagamento(boleto, conta1);
            System.out.println(boleto.estaPago());
        }catch (IllegalStateException e){
            System.out.println("Impossivel estornar boleto: " + e.getMessage());
        }
        System.out.println();
        caixaEletronico.imprimirSaldo(conta1);




    }

}
