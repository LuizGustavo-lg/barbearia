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
public class Despesa extends EntidadeBaseId{
    private String nome;
    private double valor;
    private LocalDateTime datetime;
    private String descricao;


    public Despesa(String nome, double valor, LocalDateTime datetime, String descricao) {
        super();
        this.nome = nome;
        this.valor = valor;
        this.datetime = datetime;
        this.descricao = descricao;

    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Despesa{" + "id=" + id + ", nome=" + nome + ", valor=" + valor + ", datetime=" + datetime + ", descricao=" + descricao + '}';
    }
    
}
