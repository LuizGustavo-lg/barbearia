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
    private int qntServicosRealizados;
    private int qntProdutosVendidos;

    public BalancoMensal(int mes, int ano, double receitas, double despesas) {
        super();
        this.mes = mes;
        this.ano = ano;
        this.receitas = receitas;
        this.despesas = despesas;
        this.lucroLiquido = receitas - despesas;
    }

    public BalancoMensal(int mes, int ano, double receitas, double despesas, int qntServicosRealizados, int qntProdutosVendidos) {
        super();
        this.mes = mes;
        this.ano = ano;
        this.receitas = receitas;
        this.despesas = despesas;
        this.qntServicosRealizados = qntServicosRealizados;
        this.qntProdutosVendidos = qntProdutosVendidos;
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

    public int getQntServicosRealizados() {
        return qntServicosRealizados;
    }

    public int getQntProdutosVendidos() {
        return qntProdutosVendidos;
    }

    @Override
    public String toString() {
        return "BalancoMensal{" + "mes=" + mes + ", ano=" + ano + ", receitas=" + receitas + ", despesas=" + despesas + ", lucroLiquido=" + lucroLiquido + ", qntServicosRealizados=" + qntServicosRealizados + ", qntProdutosVendidos=" + qntProdutosVendidos + '}';
    }
    
    
}
