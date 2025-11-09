/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.controller;

import com.ufvjm.barbearia.model.Pagamento;
import com.ufvjm.barbearia.model.PagamentoFactory.PagamentoCartaoFactory;
import com.ufvjm.barbearia.model.PagamentoFactory.PagamentoDinheiroFactory;
import com.ufvjm.barbearia.model.PagamentoFactory.PagamentoFactory;
import com.ufvjm.barbearia.model.PagamentoFactory.PagamentoPixFactory;

/**
 *
 * @author kirito
 */
public class PagamentoController {
    
    public Pagamento getPagamento(int tipo){
        PagamentoFactory factory;
        
        switch (tipo) {
            case 1 -> factory = new PagamentoDinheiroFactory();
            case 2 -> factory = new PagamentoPixFactory();
            case 3 -> factory = new PagamentoCartaoFactory();
            default -> {
                throw new IllegalArgumentException("Tipo de pagamento nao aceito!");
            }
        }
        
        Pagamento pagamento = factory.criarPagamento();
        return pagamento;
    }
}
