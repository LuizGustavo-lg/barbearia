/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.utils;

/**
 *
 * @author kirito
 */
public enum AtendimentoStatus {
    PENDENTE,        // Agendamento marcado para o horário
    EM_ATENDIMENTO,  // Atendimento foi iniciado
    CONCLUIDO,       // Serviço finalizado
    CANCELADO        // Cliente cancelou / vaga liberada
}
