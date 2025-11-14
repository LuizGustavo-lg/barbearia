/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.model.PagamentoFactory;

import com.ufvjm.barbearia.utils.PagamentoStatus;

/**
 *
 * @author kirito
 */
public class PagamentoCartao implements Pagamento{
    private PagamentoStatus status = PagamentoStatus.PENDENTE;


    @Override
    public void processarPagamento(double valor) {
        status = PagamentoStatus.PAGO;
        System.out.printf("Pagamento Cartão processado no valor de R$ %.2f \n", valor);
    }

    @Override
    public PagamentoStatus getStatusPagamento() {
        return status;
    }

}