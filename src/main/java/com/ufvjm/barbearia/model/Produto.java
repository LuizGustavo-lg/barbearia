/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.model;

/**
 *
 * @author kirito
 */
public class Produto {
    private String nome;
    private float valor;
    private String descricao;
    private String code;

    public Produto(String nome) {
        this.nome = nome;
    }

    public Produto(String nome, String code) {
        this.nome = nome;
        this.code = code;
    }

    public Produto(String nome, float valor, String code) {
        this.nome = nome;
        this.valor = valor;
        this.code = code;
    }

    public Produto(String nome, float valor, String descricao, String code) {
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
        this.code = code;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Produto{" + "nome=" + nome + ", valor=" + valor + ", descricao=" + descricao + ", code=" + code + '}';
    }
    
}
