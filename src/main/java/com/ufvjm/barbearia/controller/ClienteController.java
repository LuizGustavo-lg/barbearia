/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.controller;

import com.ufvjm.barbearia.model.Cliente;
import com.ufvjm.barbearia.comparator.cliente.ClienteNomeComparator;
import com.ufvjm.barbearia.model.JsonRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe responsavel por controlar todos os clientes
 * @author Luiz Gustavo
 * 
 */
public class ClienteController {
    private List<Cliente> clientes = new ArrayList<>();
    private JsonRepository<Cliente> repo;
    
    public ClienteController(){
        repo = new JsonRepository<>("data/clientes.json", Cliente.class);
        this.carregar();
    }
        
    public void save(){
        repo.salvar(clientes);
    }
    
    public void carregar(){
        clientes.clear();
        clientes.addAll(repo.carregar());
    }
    
    public void addNewCliente(String nome, String cpf){
        this.addNewCliente(new Cliente(nome, cpf));
    }
    
    public void addNewCliente(Cliente c){
        clientes.add(c);
    }
    
    public List<Cliente> getClientes(){
        Collections.sort(clientes, new ClienteNomeComparator());
        return Collections.unmodifiableList(clientes);
    }
    
    
    
    public Cliente getCliente(int id){
        return clientes.stream().
                filter(c -> c.getId() == id)
                .findFirst()
                .orElseThrow();
    }
    
    @Override
    public String toString() {
        return "ClienteController{" + "clientes=" + clientes + '}';
    }
    
    
}
