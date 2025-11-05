/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kirito
 */
public class OrdemDeServico {
    private int id;
    static int count;
    private Cliente cliente;
    private Barbeiro barbeiro;
    private List<ItemVendavel> servicos;
    private List<ItemVendavel> produtos;
    private double valorTotal;
    private LocalDateTime datetime;
    private String formaPagamento;

    public OrdemDeServico(int id, Cliente cliente, Barbeiro barbeiro, List<Servico> servicos, List<Produto> produtos, double valorTotal, LocalDateTime datetime, String formaPagamento) {
        this.id = id;
        this.cliente = cliente;
        this.barbeiro = barbeiro;
        this.servicos = new ArrayList<>(servicos);
        this.produtos = new ArrayList<>(produtos);
        this.valorTotal = valorTotal;
        this.datetime = datetime;
        this.formaPagamento = formaPagamento;
    }

    public OrdemDeServico(Cliente cliente, Barbeiro barbeiro, List<Servico> servicos, List<Produto> produtos, double valorTotal, LocalDateTime datetime, String formaPagamento) {
        this.cliente = cliente;
        this.barbeiro = barbeiro;
        this.servicos = new ArrayList<>(servicos);
        this.produtos = new ArrayList<>(produtos);
        this.valorTotal = valorTotal;
        this.datetime = datetime;
        this.formaPagamento = formaPagamento;
        
        this.id = ++count;
    }

    public OrdemDeServico(Cliente cliente, Barbeiro barbeiro, List<Servico> servicos, List<Produto> produtos, String formaPagamento) {
        this.cliente = cliente;
        this.barbeiro = barbeiro;
        this.servicos = new ArrayList<>(servicos);
        this.produtos = new ArrayList<>(produtos);
        this.formaPagamento = formaPagamento;
        
        this.datetime = LocalDateTime.now();
        this.id = ++count;
        this.calcularValorTotal();
    }

    
    private double calcularItemVendavel(List<ItemVendavel> itens){
       double val = 0;
       for (ItemVendavel i : itens){
           val += i.getValor();
       }
       return val;
    }
    
    public void calcularValorTotal(){
        this.valorTotal = calcularItemVendavel(servicos) + calcularItemVendavel(produtos);
    }
    
    
    public int getId() {
        return id;
    }

    
    public void addServico(Servico s){
        servicos.add(s);
    }
    
    public void addProduto(Produto p){
        produtos.add(p);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Barbeiro getBarbeiro() {
        return barbeiro;
    }

    public void setBarbeiro(Barbeiro barbeiro) {
        this.barbeiro = barbeiro;
    }

    public List<ItemVendavel> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = new ArrayList<>(servicos);
    }

    public List<ItemVendavel> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = new ArrayList<>(produtos);
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    

    @Override
    public String toString() {
        return "OrdemDeServico{" + "id=" + id + ", cliente=" + cliente + ", barbeiro=" + barbeiro + ", servicos=" + servicos + ", produtos=" + produtos + ", valorTotal=" + valorTotal + ", datetime=" + datetime + ", formaPagamento=" + formaPagamento + '}';
    }
}
