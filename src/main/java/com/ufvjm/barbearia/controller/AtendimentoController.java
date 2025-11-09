/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.controller;

import com.ufvjm.barbearia.model.Atendimento;
import com.ufvjm.barbearia.model.JsonRepository;
import com.ufvjm.barbearia.model.Produto;
import com.ufvjm.barbearia.model.Servico;
import com.ufvjm.barbearia.utils.AtendimentoStatus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author kirito
 */
public class AtendimentoController {
    private List<Atendimento> atendimentos = new ArrayList<>();
    private JsonRepository<Atendimento> repo;
    
    public AtendimentoController(){
        repo = new JsonRepository<>("data/atendimentos.json", Atendimento.class);
        this.carregar();
    }
        
    public void save(){
        repo.salvar(atendimentos);
    }
    
    public void carregar(){
        atendimentos.clear();
        atendimentos.addAll(repo.carregar());
    }
    
    public void addAtendimento(Atendimento a){
        atendimentos.add(a);
    }
    
    public void addAtendimento(int reserva, AtendimentoStatus s){
        addAtendimento(new Atendimento(reserva, s));
    }
    
    public Atendimento getAtendimento(int id){
        return atendimentos.stream()
            .filter(a -> a.getId() == id)
            .findFirst()
            .orElseThrow();
    }
    
    public List<Atendimento> getAtendimentos(){
        return Collections.unmodifiableList(atendimentos);
    }
    
    public List<Atendimento> getAtendimentos(AtendimentoStatus s){
        return atendimentos.stream()
            .filter(a -> a.getStatus() == s)
            .toList();
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
