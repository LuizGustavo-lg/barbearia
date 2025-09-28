/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.controller;

import com.ufvjm.barbearia.model.Servico;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kirito
 */
public class ServicoController {
    private List<Servico> servicos = new ArrayList<>();
    
    public ServicoController(){}
    
    
    public void addNewServico(String nome){
        Servico p = new Servico(nome);
        servicos.add(p);
    }
    
    
    public void addNewServico(String nome, float valor, String code){
        Servico p = new Servico(nome, valor);
        servicos.add(p);
    }
    

    public Servico getServico(int id){
        return servicos.get(id);        
    }
    
    public Boolean removeServico(int id){
        if (id < 0 || id >= this.servicos.size()){
            return false;
        } 
        servicos.remove(id);
        return true;
    }
    
    @Override
    public String toString() {
        return "ServicoController{" + "servicos=" + servicos + '}';
    }
}
