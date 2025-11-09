/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.controller;

import com.ufvjm.barbearia.model.JsonRepository;
import com.ufvjm.barbearia.model.OrdemDeServico;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author kirito
 */
public class OrdemDeServicoController {
    private List<OrdemDeServico> ordensDeServico = new ArrayList<>();
    private JsonRepository<OrdemDeServico> repo;

    public OrdemDeServicoController() {
        repo = new JsonRepository<>("data/ordensdeservico.json", OrdemDeServico.class);
        this.carregar();
    }
    
    public OrdemDeServico getOrdemDeServico(int id){
        return ordensDeServico.stream()
                .filter(o -> o.getId() == id)
                .findFirst()
                .orElseThrow();
    }
    
    public void save(){
        repo.salvar(ordensDeServico);
    }
    
    public void carregar(){
        ordensDeServico.clear();
        ordensDeServico.addAll(repo.carregar());
    }
    
    
    public List<OrdemDeServico> getOrdensDeServico(){
        return Collections.unmodifiableList(ordensDeServico);
    }
    
    public void addOrdemDeServico(OrdemDeServico os){
        ordensDeServico.add(os);
    }
    
    
    public List<OrdemDeServico> buscarPorCliente(int idCliente) {
        return ordensDeServico.stream()
                .filter(os -> os.getCliente().getId() == idCliente)
                .toList();
    }

    
    public List<OrdemDeServico> buscarPorMes(int mes, int ano) {
        return ordensDeServico.stream()
                .filter(os -> os.getDatetime().getMonthValue() == mes &&
                              os.getDatetime().getYear() == ano)
                .toList();
    }
    
    public List<OrdemDeServico> buscarPorDia(int dia, int mes, int ano) {
        return ordensDeServico.stream()
                .filter(os -> os.getDatetime().getDayOfMonth() == dia &&
                              os.getDatetime().getMonthValue() == mes &&
                              os.getDatetime().getYear() == ano)
                .toList();
    }
    

    public double calcularFaturamento(int mes, int ano) {
        return buscarPorMes(mes, ano).stream()
                .mapToDouble(OrdemDeServico::getValorTotal)
                .sum();
    }
    
    
    
}
