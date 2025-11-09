/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.controller;

import com.ufvjm.barbearia.model.Despesa;
import com.ufvjm.barbearia.model.JsonRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author kirito
 */
public class DespesasController {
    private List<Despesa> despesas = new ArrayList<>();
    private JsonRepository<Despesa> repo;
    
    public DespesasController() {
        repo = new JsonRepository<>("data/despesas.json", Despesa.class);
        this.carregar();
    }
    
    public void save(){
        repo.salvar(despesas);
    }
    
    public void carregar(){
        despesas.clear();
        despesas.addAll(repo.carregar());
    }
    
        
    public Despesa getDespesa(int id){
        for (Despesa d : despesas){
            if (d.getId() == id){
                return d;
            }
        }
        throw new ArrayIndexOutOfBoundsException("Id não encontrado");
    }
    
    public List<Despesa> getDespesas(){
        return Collections.unmodifiableList(despesas);
    }
    
    public void addDespesa(Despesa os){
        despesas.add(os);
    }
   
    public List<Despesa> buscarPorMes(int mes, int ano) {
        return despesas.stream()
                .filter(os -> os.getDatetime().getMonthValue() == mes &&
                              os.getDatetime().getYear() == ano)
                .toList();
    }
    

    public double calcularDespesas(int mes, int ano) {
        return buscarPorMes(mes, ano).stream()
                .mapToDouble(Despesa::getValor)
                .sum();
    }
}
