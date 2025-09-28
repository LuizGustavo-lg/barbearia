/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.model;

/**
 *
 * @author kirito
 */
public class ItemVendavel {
    private String nome;
    private float valor;
    private String descricao;
    protected int id;
    
    public ItemVendavel(String nome) {
        this.nome = nome;
    }

    public ItemVendavel(String nome, float valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public ItemVendavel(String nome, float valor, String descricao) {
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ItemVendavel{" + "nome=" + nome + ", valor=" + valor + ", descricao=" + descricao + ", id=" + id + '}';
    }
}
