/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.controller;

import com.ufvjm.barbearia.model.JsonRepository;
import com.ufvjm.barbearia.model.Servico;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author kirito
 */
public class ServicoController {
    private List<Servico> servicos = new ArrayList<>();
    private JsonRepository<Servico> repo;
    
    public ServicoController(){
        repo = new JsonRepository<>("data/servicos.json", Servico.class);
        this.carregar();
    }
    
    
    public void save(){
        repo.salvar(servicos);
    }
    
    public void carregar(){
        servicos.clear();
        servicos.addAll(repo.carregar());
    }
    
    public void addNewServico(String nome, float valor, int pTempo){
        addNewServico(new Servico(nome, valor, pTempo));
    }
    
    public void addNewServico(Servico s){
        servicos.add(s);
    }
    
    public List<Servico> getServicos(){
        return Collections.unmodifiableList(servicos);
    }

    public Servico getServico(int id){
        return servicos.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElseThrow();
    }
    
    public void removeServico(int id){
        servicos.remove(getServico(id));
    }
    
    @Override
    public String toString() {
        return "ServicoController{" + "servicos=" + servicos + '}';
    }
}
