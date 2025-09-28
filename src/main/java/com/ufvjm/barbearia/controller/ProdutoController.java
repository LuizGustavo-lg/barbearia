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
public class ProdutoController {
    private List<Produto> produtos = new ArrayList<>();
    
    public ProdutoController(){}
    
    
    public void addNewProduto(String nome){
        Produto p = new Produto(nome);
        produtos.add(p);
    }
    
    public void addNewProduto(String nome, String code){
        Produto p = new Produto(nome, code);
        produtos.add(p);
    }
    
    
    public void addNewProduto(String nome, float valor, String code){
        Produto p = new Produto(nome, valor, code);
        produtos.add(p);
    }

    
    
    
    @Override
    public String toString() {
        return "ProdutoController{" + "produtos=" + produtos + '}';
    }
    
}
