/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.controller;

import com.ufvjm.barbearia.model.Barbeiro;
import com.ufvjm.barbearia.model.Estacao;

/**
 *
 * @author kirito
 */
public class EstacaoController {
    private Estacao[] estacoes = new Estacao[3];
    
    public EstacaoController(Barbeiro b1, Barbeiro b2, Barbeiro b3){
        estacoes[0] = new Estacao(b1, 1);
        estacoes[1] = new Estacao(b2, 2);
        estacoes[2] = new Estacao(b3, 3);
    }

    public EstacaoController() {}

    public Estacao[] getEstacoes() {
        return estacoes;
    }
    
    public Estacao getEstacao(int num) {
        return estacoes[num-1];
    }

    public void setEstacao(Barbeiro b, int num) {
        this.estacoes[num-1] = new Estacao(b, num);
    }

    @Override
    public String toString() {
        return "EstacaoController{" + "estacoes=" + estacoes + '}';
    }
}
