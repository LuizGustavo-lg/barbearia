/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.model;

import java.time.LocalDateTime;
        
/**
 *
 * @author kirito
 */
public class Reserva {
    private int id;
    private static int cont;
    private Atendimento atendimento;
    private Cliente cliente;
    private Servico servico;
    private Estacao estacao;
    private Barbeiro barbeiro;
    private LocalDateTime datetime;

    
    public Reserva(int id, Atendimento atendimento, Cliente cliente, Servico servico, Estacao estacao, LocalDateTime datetime, Barbeiro barbeiro) {
        this.id = id;
        this.atendimento = atendimento;
        this.cliente = cliente;
        this.servico = servico;
        this.estacao = estacao;
        this.datetime = datetime;
        this.barbeiro = barbeiro;
    }

    public Reserva(Atendimento atendimento, Cliente cliente, Servico servico, Estacao estacao, LocalDateTime datetime, Barbeiro barbeiro) {
        this.atendimento = atendimento;
        this.cliente = cliente;
        this.servico = servico;
        this.estacao = estacao;
        this.datetime = datetime;
        this.barbeiro = barbeiro;
        
        this.id = ++cont;
    }

    public int getId() {
        return id;
    }

    public Atendimento getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Estacao getEstacao() {
        return estacao;
    }

    public void setEstacao(Estacao estacao) {
        this.estacao = estacao;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + ", atendimento=" + atendimento + ", cliente=" + cliente + ", servico=" + servico + ", estacao=" + estacao + ", datetime=" + datetime + '}';
    }
    
      
    
}
