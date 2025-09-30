/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.controller;

import com.ufvjm.barbearia.model.Atendimento;
import com.ufvjm.barbearia.model.Barbeiro;
import com.ufvjm.barbearia.model.Cliente;
import com.ufvjm.barbearia.model.Estacao;
import com.ufvjm.barbearia.model.Reserva;
import com.ufvjm.barbearia.model.Servico;
import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 *
 * @author kirito
 */
public class Agenda {
    private List<Reserva> agendamentos = new ArrayList<>();
    private Deque<Reserva> agendSecundario = new ArrayDeque<>();

    public Agenda() {
    }
    
    public boolean addReserva(Atendimento atendimento, Cliente cliente, Servico servico, Estacao estacao, LocalDateTime datetime, Barbeiro barbeiro){
        if (this.verificarHorario(datetime)) {
            return false;
        }
        agendamentos.add(new Reserva(atendimento, cliente, servico, estacao, datetime, barbeiro));
        return true;
    }
    
    
    public boolean verificarHorario(LocalDateTime datetime){
        return !agendamentos.stream().anyMatch(a -> a.getDatetime().equals(datetime));
    }
}