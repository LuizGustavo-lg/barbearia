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

    public Servico(String nome) {
        super(nome);
    }

    public Servico(String nome, float valor) {
        super(nome, valor);
    }

    public Servico(String nome, float valor, String descricao) {
        super(nome, valor, descricao);
    }
    
}
