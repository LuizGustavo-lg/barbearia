/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.controller;

import com.ufvjm.barbearia.model.Atendimento;
import com.ufvjm.barbearia.model.Cliente;
import com.ufvjm.barbearia.model.Estacao;
import com.ufvjm.barbearia.model.JsonRepository;
import com.ufvjm.barbearia.model.Reserva;
import com.ufvjm.barbearia.model.Servico;
import com.ufvjm.barbearia.utils.ReservaStatus;
import com.ufvjm.barbearia.utils.AtendimentoStatus;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author kirito
 */
public class Agenda {
    private List<Reserva> agendamentos = new ArrayList<>();
     private Queue<Reserva> filaEspera = new LinkedList<>();
    private JsonRepository<Reserva> repo;

    public Agenda() {
        repo = new JsonRepository<>("data/agendamentos.json", Reserva.class);
        this.carregar();
    }
    
    public void save(){
        repo.salvar(agendamentos);
    }
    
    public void carregar(){
        agendamentos.clear();
        agendamentos.addAll(repo.carregar());
    }
    
    private void validarHorario(LocalDateTime datetime){
        if (!(0 == datetime.getMinute() || datetime.getMinute() == 30)) {
            throw new IllegalArgumentException("Minutos fora do espaco de tempo");
        }
    }
    
    public boolean addReserva(Cliente cliente, String descricao, Estacao estacao, LocalDateTime datetime, Servico s){
        return addReserva(new Reserva(cliente, descricao, estacao, datetime, s));
    }
    
    public boolean addReserva(Reserva r){
        this.validarHorario(r.getDatetime());
        
        if (this.verificarHorarioAgenda(r.getDatetime(), r.getEstacao(), r.getServicoPrevisto().getPassosTempo())) {
            r.setStatus(ReservaStatus.AGENDADO);
            agendamentos.add(r);
            return true;
        }
        
        return false;
    }
    
    public void addPilhaDeEspera(Reserva r){
        r.setStatus(ReservaStatus.ESPERA);
        filaEspera.add(r);
    }
      
    
    public boolean verificarHorarioAgenda(LocalDateTime datetime, Estacao estacao, int passosTempo){
        LocalDateTime inicioNova = datetime;
        LocalDateTime fimNova = datetime.plusMinutes(passosTempo * 30);

        for (Reserva r : agendamentos) {
            if (r.getStatus().equals(ReservaStatus.AGENDADO)){
                if (r.getEstacao().getNumero() == estacao.getNumero()) {
                    LocalDateTime inicioExistente = r.getDatetime();
                    LocalDateTime fimExistente = r.getDatetime().plusMinutes(r.getServicoPrevisto().getPassosTempo() * 30);

                    boolean sobrepoe = (fimNova.isAfter(inicioExistente) && inicioNova.isBefore(fimExistente));
                    if (sobrepoe) {
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
    
    public Reserva getReserva(int id){
        return agendamentos.stream()
                    .filter(r -> r.getId() == id)
                    .findFirst()
                    .orElseThrow();
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
    
    
    public boolean horarioJaPassou(LocalDateTime horario) {
        return horario.isBefore(LocalDateTime.now());
    }
    
    public Atendimento cancelarReserva(int id){
        Reserva r = getReserva(id);
        float retencao = (float) r.calcularRetencaoPorCancelamento();
        float reembolso = (float)  r.calcularReembolsoPorCancelamento();
        
        r.setStatus(ReservaStatus.CANCELADO);
        
        
        if (!filaEspera.isEmpty()){
            Reserva newR = filaEspera.poll();

            newR.setDatetime(r.getDatetime());
            addReserva(newR);
            
            System.out.println(newR.getCliente().getNome() + "foi promovido da fila de espera.");
        }
        
        
        System.out.println("Cancelamento realizado.");
        System.out.println("Valor retido: R$ " + retencao);
        System.out.println("Valor reembolsado ao cliente: R$ " + reembolso);
        
        Atendimento a = new Atendimento(-1, r.getId(), AtendimentoStatus.CANCELADO);
        a.addServico(new Servico(-1, "Serviço Cancelado", retencao, "", 0));
        return a;
    }   
    
    @Override
    public String toString() {
        return "Agenda{" + "\nagendamentos=" + agendamentos + " \nagendSecundario=" + filaEspera + '}';
    }
}
