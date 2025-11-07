/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.model;

import java.time.LocalDateTime;
import com.ufvjm.barbearia.utils.ReservaStatus;
        
/**
 *
 * @author kirito
 */

public class Reserva {
    private int id;
    private static int cont;
    private Cliente cliente;
    private String descricao;
    private Estacao estacao;
    private LocalDateTime datetime;
    private ReservaStatus status;
    private Servico servicoPrevisto;

    
    public Reserva(int id, Cliente cliente, String descricao, Estacao estacao, LocalDateTime datetime, Servico servico) {
        this.id = id;
        this.cliente = cliente;
        this.datetime = datetime;
        this.descricao = descricao;
        this.servicoPrevisto = servico;
    }

    public Reserva(Cliente cliente, String descricao, Estacao estacao, LocalDateTime datetime, Servico servico) {
        this.cliente = cliente;
        this.datetime = datetime;
        this.descricao = descricao;
        this.servicoPrevisto = servico;
        
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public Estacao getEstacao() {
        return estacao;
    }

    public void setEstacao(Estacao estacao) {
        this.estacao = estacao;
    }

    public Servico getServicoPrevisto() {
        return servicoPrevisto;
    }

    public void setServicoPrevisto(Servico servicoPrevisto) {
        this.servicoPrevisto = servicoPrevisto;
    }
    

    public ReservaStatus getStatus() {
        return status;
    }

    public void setStatus(ReservaStatus status) {
        this.status = status;
    }

        
    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + ", cliente=" + cliente + ", descricao=" + descricao + ", estacao=" + estacao + ", datetime=" + datetime + ", status=" + status + ", servicoPrevisto=" + servicoPrevisto + '}';
    }

}
