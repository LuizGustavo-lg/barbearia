/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.controller;

import com.ufvjm.barbearia.model.Despesa;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author kirito
 */
public class DespesasController {
    List<Despesa> despesas = new ArrayList<>();
    
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
