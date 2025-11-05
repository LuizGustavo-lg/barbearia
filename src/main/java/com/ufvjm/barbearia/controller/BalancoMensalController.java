/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.controller;

import com.ufvjm.barbearia.model.BalancoMensal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kirito
 */
public class BalancoMensalController {
    List<BalancoMensal> balancos = new ArrayList<>();
    
    public void addBalanco(BalancoMensal bm) throws IllegalStateException {
        if (buscarBalanco(bm.getMes(), bm.getAno()) == null){
            throw new IllegalStateException("Balanço já existente para esse mês!");
        }
        balancos.add(bm);
    }
    
    public void atualizarBalanco(BalancoMensal bm){
        balancos.remove(buscarBalanco(bm.getMes(), bm.getAno()));
        addBalanco(bm);
    }
      
    public BalancoMensal buscarBalanco(int mes, int ano){
        return balancos.stream()
                .filter(bm -> bm.getMes() == mes && bm.getAno() == ano)
                .findFirst()
                .orElse(null);
    }
}
