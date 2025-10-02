/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.controller;

import com.ufvjm.barbearia.model.Barbeiro;
import com.ufvjm.barbearia.model.Cliente;
import com.ufvjm.barbearia.model.Estacao;
import com.ufvjm.barbearia.model.Reserva;
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
    
    public boolean addReserva(Cliente cliente, Estacao estacao, LocalDateTime datetime, Barbeiro barbeiro, int passosTempo){
        
        if (!this.validarHorario(datetime)){
            return false;
        }
        
        if (!this.verificarHorarioAgenda(datetime, estacao, passosTempo)) {
            return false;
        }
        
        agendamentos.add(new Reserva(cliente, estacao, datetime, barbeiro, passosTempo));
        return true;
    }
    
    
    public boolean verificarHorarioAgenda(LocalDateTime datetime, Estacao estacao, int passosTempo){
        for (int p = 0; p<passosTempo; p++){
            for (Reserva r : agendamentos){
                for (int i = 0; i<r.getPassosTempo(); i++){
                    if (r.getDatetime().plusMinutes(i*30).equals(datetime.plusMinutes(p*30)) && r.getEstacao().getNumero() == estacao.getNumero()){
                        return false;
                    }
                }
            }
        }
        return true;
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

                    if(verificarHorarioAgenda(data.atTime(t), e, 1)){
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
