/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.model;

/**
 *
 * @author kirito
 */
public class Servico extends ItemVendavel{
    private static int cont = 0;

    public Servico(String nome) {
        super(nome);
        super.id = ++cont;
    }

    public Servico(String nome, float valor) {
        super(nome, valor);
        super.id = ++cont;
    }

    public Servico(String nome, float valor, String descricao) {
        super(nome, valor, descricao);
        super.id = ++cont;
    }
    
}
