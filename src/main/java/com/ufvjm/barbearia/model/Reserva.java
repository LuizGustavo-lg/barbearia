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
    private Cliente cliente;
    private Estacao estacao;
    private Barbeiro barbeiro;
    private LocalDateTime datetime;

    
    public Reserva(int id, Cliente cliente, Estacao estacao, LocalDateTime datetime, Barbeiro barbeiro) {
        this.id = id;
        this.cliente = cliente;
        this.estacao = estacao;
        this.datetime = datetime;
        this.barbeiro = barbeiro;
    }

    public Reserva(Cliente cliente, Estacao estacao, LocalDateTime datetime, Barbeiro barbeiro) {
        this.cliente = cliente;
        this.estacao = estacao;
        this.datetime = datetime;
        this.barbeiro = barbeiro;
        
        this.id = ++cont;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    public Barbeiro getBarbeiro() {
        return barbeiro;
    }

    public void setBarbeiro(Barbeiro barbeiro) {
        this.barbeiro = barbeiro;
    }

    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + ", cliente=" + cliente + ", estacao=" + estacao + ", datetime=" + datetime + '}';
    }
    
      
    
}
