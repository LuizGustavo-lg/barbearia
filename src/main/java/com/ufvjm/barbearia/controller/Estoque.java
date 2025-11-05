/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.controller;

import com.ufvjm.barbearia.model.Produto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author kirito
 */
public class Estoque {
    private List<Produto> produtos = new ArrayList<>();
    
    public Estoque(){}
    
    
    public void addNewProduto(String nome){
        this.addNewProduto(new Produto(nome));
    }
    
    
    public void addNewProduto(String nome, float valor, String descr){
        this.addNewProduto(new Produto(nome, valor, descr));
    }
    
    public void addNewProduto(Produto p){
        produtos.add(p);
    }

    public List<Produto> getProdutos(){
        return Collections.unmodifiableList(produtos);
    }
    
    public Produto getProduto(int id){
        return produtos.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow();
    }
    
    public void removeProduto(int id){
        produtos.remove(getProduto(id));
    }

    @Override
    public String toString() {
        return "Estoque{" + "produtos=" + produtos + '}';
    }

}
