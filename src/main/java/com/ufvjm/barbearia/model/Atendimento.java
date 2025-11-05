/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.model;

import java.util.ArrayList;
import java.util.List;
import com.ufvjm.barbearia.utils.AtendimentoStatus;

/**
 *
 * @author kirito
 */
public class Atendimento {
    private int id;
    private static int cont;

    private AtendimentoStatus status;
    private int statusAtual = 0;
    
    private int reservaId;
    private Barbeiro barbeiro;
    private List <Servico> servicos = new ArrayList<Servico>();
    private List <Produto> produtos = new ArrayList<Produto>();
    
    
    public Atendimento(int reserva, AtendimentoStatus s){
        this.statusAtual = 0;
        this.id = ++cont;
        
        this.reservaId = reserva;
        this.status = s;
    }
    
    public int getId(){
        return id;
    }
    
    public AtendimentoStatus getStatus(){
        return status;
    }
    
    public void setStatus(AtendimentoStatus s){
        this.status = s;
    }
    
    public boolean cancelarAtendimento(){
        if (this.status.equals(AtendimentoStatus.CONCLUIDO)){
            return false;
        }
        
        this.status = AtendimentoStatus.CANCELADO;
        return true;
    }
    
    public Barbeiro getBarbeiro() {
        return barbeiro;
    }

    public void setBarbeiro(Barbeiro barbeiro) {
        this.barbeiro = barbeiro;
    }

    public int getReservaId() {
        return reservaId;
    }

    public void setReservaId(int reservaId) {
        this.reservaId = reservaId;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void addServico(Servico s) {
        this.servicos.add(s);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void addProduto(Produto p) {
        this.produtos.add(p);
    }
    

    @Override
    public String toString() {
        return "Atendimento{" + "id=" + id + ", status=" + status + ", statusAtual=" + statusAtual + ", barbeiro=" + barbeiro + ", reservaId=" + reservaId + '}';
    }
    
    
}
