/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.controller;

import com.ufvjm.barbearia.model.Barbeiro;
import com.ufvjm.barbearia.model.Cliente;
import com.ufvjm.barbearia.model.Estacao;
import com.ufvjm.barbearia.model.Reserva;
import com.ufvjm.barbearia.model.Servico;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
    
    
    private boolean validarHorario(LocalDateTime datetime){
        return (0 == datetime.getMinute() || datetime.getMinute() == 30);
    }
    
    public boolean addReserva(Cliente cliente, Servico servico, Estacao estacao, LocalDateTime datetime, Barbeiro barbeiro){
        
        if (!this.validarHorario(datetime)){
            return false;
        }
        
        if (!this.verificarHorarioAgenda(datetime, estacao)) {
            return false;
        }
        
        agendamentos.add(new Reserva(cliente, servico, estacao, datetime, barbeiro));
        return true;
    }
    
    
    public boolean verificarHorarioAgenda(LocalDateTime datetime, Estacao estacao){
        return !agendamentos.stream().anyMatch((Reserva a) -> a.getDatetime().equals(datetime) && a.getEstacao().getNumero() == estacao.getNumero());
    }
    
    
    public List<List<LocalTime>> getHorariosDisponiveisNoDia(){
        
        LocalDate dataAtual = LocalDate.now();

        return getHorariosDisponiveisNoDia(dataAtual);
    }
    
    public List<List<LocalTime>> getHorariosDisponiveisNoDia(LocalDate data){
        
        EstacaoController estacoes = new EstacaoController();
        List<List<LocalTime>> horariosDisp = new ArrayList<>();
        
        for (Estacao e : estacoes.getEstacoes()){
            List<LocalTime> horariosDispEstacao = new ArrayList<>();
            for (int h = 8; h<20; h++){
                for (int m = 0; m<60; m=m+30){
                    LocalTime t = LocalTime.of(h, m);

                    if(verificarHorarioAgenda(data.atTime(t), e)){
                        horariosDispEstacao.add(t);
                    }
                }
            }
            horariosDisp.add(horariosDispEstacao);
        }
        return horariosDisp;
    }
    
    @Override
    public String toString() {
        return "Agenda{" + "\nagendamentos=" + agendamentos + " \nagendSecundario=" + agendSecundario + '}';
    }
}
