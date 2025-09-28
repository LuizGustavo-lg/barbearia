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
    private static int cont = 0;
    
    public Produto(String nome) {
        super(nome);
        super.id = ++cont;
    }

    public Produto(String nome, float valor) {
        super(nome, valor);
        super.id = ++cont;
    }

    public Produto(String nome, float valor, String descricao) {
        super(nome, valor, descricao);
        super.id = ++cont;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
