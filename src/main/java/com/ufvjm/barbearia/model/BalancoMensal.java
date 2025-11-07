/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.model;

/**
 *
 * @author kirito
 */
public class BalancoMensal extends EntidadeBaseId{
    private int mes;
    private int ano;
    private double receitas;
    private double despesas;
    private double lucroLiquido;

    public BalancoMensal(int mes, int ano, double receitas, double despesas) {
        super();
        this.mes = mes;
        this.ano = ano;
        this.receitas = receitas;
        this.despesas = despesas;
        this.lucroLiquido = receitas - despesas;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public double getReceitas() {
        return receitas;
    }

    public double getDespesas() {
        return despesas;
    }

    public double getLucroLiquido() {
        return lucroLiquido;
    }
}
