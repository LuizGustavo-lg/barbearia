/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.controller;

import com.ufvjm.barbearia.model.Estacao;

/**
 *
 * @author kirito
 */
public class EstacaoController {
    private Estacao[] estacoes = new Estacao[3];
    
    public EstacaoController(){
        estacoes[0] = new Estacao(1, "Lavagem e Secador");
        estacoes[1] = new Estacao(2, "Atividades Corriqueiras");
        estacoes[2] = new Estacao(3, "Atividades Corriqueiras");
    }

    public Estacao[] getEstacoes() {
        return estacoes;
    }
    
    public Estacao getEstacao(int num) {
        return estacoes[num-1];
    }

    @Override
    public String toString() {
        return "EstacaoController{" + "estacoes=" + estacoes + '}';
    }
}
