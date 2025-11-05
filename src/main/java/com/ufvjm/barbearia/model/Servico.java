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
    private int passosTempo;

    public Servico(String nome, float valor, int passosTempo) {
        super(nome, valor);
        super.id = ++cont;
        this.passosTempo = passosTempo;
    }

    public Servico(String nome, float valor, String descricao, int passosTempo) {
        super(nome, valor, descricao);
        super.id = ++cont;
        this.passosTempo = passosTempo;
    }

    public int getPassosTempo() {
        return passosTempo;
    }

    public void setPassosTempo(int passosTempo) {
        this.passosTempo = passosTempo;
    }
}
