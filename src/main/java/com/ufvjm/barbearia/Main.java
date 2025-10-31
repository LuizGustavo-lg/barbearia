/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ufvjm.barbearia;
import com.ufvjm.barbearia.controller.Agenda;
import java.time.LocalDateTime;
import com.ufvjm.barbearia.model.Cliente;
import com.ufvjm.barbearia.controller.ClienteController;
import com.ufvjm.barbearia.model.Barbeiro;
import com.ufvjm.barbearia.model.Estacao;
import com.ufvjm.barbearia.model.Produto;
import com.ufvjm.barbearia.model.Servico;
import java.time.LocalDate;
import java.time.Month;
        
/**
 *
 * @author kirito
 */
public class Main {

    public static void main(String[] args) {
        Agenda ag = new Agenda();
        System.out.println(ag.addReserva(new Cliente("Luiz", "123456789"), new Estacao(1, "Generica"), LocalDateTime.of(2025, Month.SEPTEMBER, 30, 12, 0), new Barbeiro("Vitin", "987654321"), 2));
        System.out.println(ag.addReserva(new Cliente("Luiz", "123456789"), new Estacao(1, "Generica"), LocalDateTime.of(2025, Month.SEPTEMBER, 30, 12, 30), new Barbeiro("Vitin", "987654321"), 1));
        System.out.println(ag.addReserva(new Cliente("Luiz", "123456789"), new Estacao(1, "Generica"), LocalDateTime.of(2025, Month.SEPTEMBER, 30, 11, 30), new Barbeiro("Vitin", "987654321"), 1));
        System.out.println(ag.getHorariosDisponiveisNoDia(LocalDate.of(2025, Month.SEPTEMBER, 30)));
        System.out.println(ag.toString());
    }
} 
