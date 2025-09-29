/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.model;

/**
 * Classe modelo da estacao de trabalho
 * @author Luiz Gustavo
 */
public class Estacao {
    private Barbeiro barbeiroResponsavel;
    private int numero;

    public Estacao(Barbeiro barbeiroResponsavel, int numero) {
        this.barbeiroResponsavel = barbeiroResponsavel;
        this.numero = numero;
    }

    public Barbeiro getBarbeiroResponsavel() {
        return barbeiroResponsavel;
    }

    public void setBarbeiroResponsavel(Barbeiro barbeiroResponsavel) {
        this.barbeiroResponsavel = barbeiroResponsavel;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Estacao{" + "barbeiroResponsavel=" + barbeiroResponsavel + ", numero=" + numero + '}';
    }
        
}
