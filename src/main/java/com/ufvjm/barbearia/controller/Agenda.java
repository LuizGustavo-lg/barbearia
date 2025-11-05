/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.controller;

import com.ufvjm.barbearia.model.Atendimento;
import com.ufvjm.barbearia.model.Cliente;
import com.ufvjm.barbearia.model.Estacao;
import com.ufvjm.barbearia.model.Reserva;
import com.ufvjm.barbearia.model.Servico;
import com.ufvjm.barbearia.utils.ReservaStatus;
import com.ufvjm.barbearia.utils.AtendimentoStatus;
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
    
    public boolean addReserva(Cliente cliente, String descricao, Estacao estacao, LocalDateTime datetime, Servico s){
        return addReserva(new Reserva(cliente, descricao, estacao, datetime, s));
    }
    
    public boolean addReserva(Reserva r){
        if (!this.validarHorario(r.getDatetime())){
            return false;
        }
        
        if (this.verificarHorarioAgenda(r.getDatetime(), r.getEstacao(), r.getServicoPrevisto().getPassosTempo())) {
            agendamentos.add(r);
            r.setStatus(ReservaStatus.AGENDADO);
            
        } else {
            agendSecundario.add(r);
            r.setStatus(ReservaStatus.ESPERA);           
            
        }
        
        return true;
    }
    
    
    public boolean verificarHorarioAgenda(LocalDateTime datetime, Estacao estacao, int passosTempo){
        LocalDateTime inicioNova = datetime;
        LocalDateTime fimNova = datetime.plusMinutes(passosTempo * 30);

        for (Reserva r : agendamentos) {
            if (r.getEstacao().getNumero() == estacao.getNumero()) {
                LocalDateTime inicioExistente = r.getDatetime();
                LocalDateTime fimExistente = r.getDatetime().plusMinutes(r.getServicoPrevisto().getPassosTempo() * 30);

                boolean sobrepoe = (fimNova.isAfter(inicioExistente) && inicioNova.isBefore(fimExistente));
                if (sobrepoe) {
                    return false;
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
    
    public Reserva getReserva(int id){
        for (Reserva r : agendamentos){
            if (r.getId() == id){
                return r;
            }
        }
        return null;
        
    }
    
    public Atendimento iniciarAtendimento(int id) throws IllegalStateException{
        Reserva r = getReserva(id);
        
        if (!r.getStatus().equals(ReservaStatus.AGENDADO)){
            throw new IllegalStateException("Não é possível iniciar o atendimento. A reserva não está AGENDADA.");
        }
            
        r.setStatus(ReservaStatus.EM_ATENDIMENTO);
        Atendimento a = new Atendimento(r.getId(), AtendimentoStatus.EM_ATENDIMENTO);
        a.addServico(r.getServicoPrevisto());
        return a;
    }
    
    @Override
    public String toString() {
        return "Agenda{" + "\nagendamentos=" + agendamentos + " \nagendSecundario=" + agendSecundario + '}';
    }
}
