/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.controller;

import com.ufvjm.barbearia.model.Atendimento;
import com.ufvjm.barbearia.model.Produto;
import com.ufvjm.barbearia.model.Servico;
import com.ufvjm.barbearia.utils.AtendimentoStatus;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kirito
 */
public class AtendimentoController {
    private List<Atendimento> atendimentos = new ArrayList<>();
    
    public AtendimentoController(){}
    
 
    public void addAtendimento(Atendimento a){
        atendimentos.add(a);
    }
    
    public void addAtendimento(int reserva, AtendimentoStatus s){
        addAtendimento(new Atendimento(reserva, s));
    }
    
    public Atendimento getAtendimento(int id){
        for (Atendimento a: atendimentos){
            if(a.getId() == id){
                return a;
            }
        }
        return null;
    }
    
    public List<Atendimento> getAtendimentos(){
        return atendimentos;
    }
    
    public List<Atendimento> getAtendimentos(AtendimentoStatus s){
        List<Atendimento> atendimentosStatus = new ArrayList<>();
        for (Atendimento a : atendimentos){
            if (a.getStatus().equals(s)){
                atendimentosStatus.add(a);
            }
        }
        
        return atendimentosStatus;
    }

    public void setStatus(int id, AtendimentoStatus s){
        getAtendimento(id).setStatus(s);
    }
    
    public boolean cancelarAtendimento(int id){
        return getAtendimento(id).cancelarAtendimento();
    }
    
    
    public void addServico(int id, Servico s){
        getAtendimento(id).addServico(s);
    }
    
    public void addProduto(int id, Produto p){
        getAtendimento(id).addProduto(p);
    }
    
}
