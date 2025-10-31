/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.model;

/**
 *
 * @author kirito
 */
public class Atendimento {
    private int id;
    private static int cont;
    
    private String status[] = {"Pendente", "Em Espera", "Em Atendimento", "Concluído", "Cancelado"};
    private int statusAtual;
    private int reservaId;
    
    public Atendimento(int reserva){
        this.statusAtual = 0;
        this.id = ++cont;
        
        this.reservaId = reserva;
    }
    
    public String getStatus(){
        return status[statusAtual];
    }
    
    public boolean proximaAtualizacao(){
        if (statusAtual >= 3){ 
            return false; 
        }
        
        ++this.statusAtual;
        return true;
    }
    
    public void cancelarAtendimento(){
        this.statusAtual = 4;
    }
    
    public boolean statusEqual(int s){
        return statusAtual == s;
    }
    
    public boolean statusEqual(String s){
        return status.equals(s);
    }

    @Override
    public String toString() {
        return "Atendimento{" + "id=" + id + ", status=" + status + ", statusAtual=" + statusAtual + '}';
    }
    
    
}
