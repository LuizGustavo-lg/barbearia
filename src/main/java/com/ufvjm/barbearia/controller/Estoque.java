/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.controller;

import com.ufvjm.barbearia.model.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kirito
 */
public class Estoque {
    private List<Produto> produtos = new ArrayList<>();
    
    public Estoque(){}
    
    
    public void addNewProduto(String nome){
        Produto p = new Produto(nome);
        produtos.add(p);
    }
    
    
    public void addNewProduto(String nome, float valor, String code){
        Produto p = new Produto(nome, valor);
        produtos.add(p);
    }

    public List<Produto> getProdutos(){
        return produtos;
    }
    
    public Produto getProduto(int id){
        return produtos.get(id);        
    }
    
    public Boolean removeProduto(int id){
        if (id < 0 || id >= this.produtos.size()){
            return false;
        } 
        produtos.remove(id);
        return true;
    }

    @Override
    public String toString() {
        return "Estoque{" + "produtos=" + produtos + '}';
    }

}
