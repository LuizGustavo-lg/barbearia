/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.model.PagamentoFactory;

import com.ufvjm.barbearia.model.Pagamento;
import com.ufvjm.barbearia.model.PagamentoCartao;

/**
 *
 * @author kirito
 */
public class PagamentoCartaoFactory extends PagamentoFactory{

    @Override
    public Pagamento criarPagamento() {
        return new PagamentoCartao();
    }
    
}
