/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.model;

/**
 *
 * @author kirito
 */
public class PagamentoCartao implements Pagamento{

    @Override
    public void processarPagamento(double valor) {
        System.out.printf("Pagamento Cartão processado no valor de R$ %.2f \n", valor);
    }

}