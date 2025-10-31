/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.controller;

import com.ufvjm.barbearia.model.Atendimento;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kirito
 */
public class AtendimentoController {
    private List<Atendimento> atendimentos = new ArrayList<>();
    
    public AtendimentoController(){}
    
    public List<Atendimento> getAtendimentos(){
        return atendimentos;
    }
    
    public List<Atendimento> getAtendimentosByStatus(int s){
        List<Atendimento> atendimentosStatus = new ArrayList<>();
        for (Atendimento a : atendimentos){
            if (a.statusEqual(s)){
                atendimentosStatus.add(a);
            }
        }
        
        return atendimentosStatus;
    }

    
    
}
