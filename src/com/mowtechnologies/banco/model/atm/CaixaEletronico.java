package com.mowtechnologies.banco.model.atm;

import com.mowtechnologies.banco.model.Conta;
import com.mowtechnologies.banco.model.pagamento.DocumentoEstornavel;
import com.mowtechnologies.banco.model.pagamento.DocumentoPagavel;

public class CaixaEletronico {

    public void imprimirSaldo(Conta conta){
        System.out.println("Conta: " + conta.getAgencia() +"/"+ conta.getNumero());
        System.out.println("Titular: " + conta.getTitular().getNome());
        System.out.println("Saldo: " + conta.getSaldo());
        System.out.println("Saldo disponível: " + conta.getSaldoDisponivel());
    }

    public void pagar(DocumentoPagavel documentoPagavel, Conta conta){
        conta.sacar(documentoPagavel.getValorTotal());
        documentoPagavel.quitarPagamento();
    }

    public void estornarPagamento(DocumentoEstornavel documentoEstornavel, Conta conta){
        if (!documentoEstornavel.estaPago()){
            throw new IllegalStateException("Documento não está pago");
        }
        conta.depositar(documentoEstornavel.getValorTotal());
        documentoEstornavel.estornarPagamento();
    }

}
