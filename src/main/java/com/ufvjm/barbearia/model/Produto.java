/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.model;

/**
 *
 * @author kirito
 */
public class Produto extends ItemVendavel{
    private int quantidade;
    
    public Produto(String nome) {
        super(nome);
    }

    public Produto(String nome, float valor) {
        super(nome, valor);
    }

    public Produto(String nome, float valor, String descricao) {
        super(nome, valor, descricao);
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
