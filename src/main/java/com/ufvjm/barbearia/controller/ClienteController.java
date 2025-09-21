/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.controller;

import com.ufvjm.barbearia.model.Cliente;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsavel por controlar todos os clientes
 * @author Luiz Gustavo
 * 
 */
public class ClienteController {
    private List<Cliente> clientes = new ArrayList<>();
    
    public ClienteController(){}
    
    public void addNewCliente(String nome, String cpf){
        Cliente c = new Cliente(nome, cpf);
        clientes.add(c);
    }
    
    public List<Cliente> getClientes(){
        return clientes;
    }
    
    public Cliente getCliente(int id){
        return clientes.get(id);
    }
    
    public boolean setClienteName(int id, String name){
        if (id >= 0 && id < this.clientes.size()){
            clientes.get(id).setNome(name);
            return true;
        } 
        return false;
    }
    
    public boolean setClienteTelefone(int id, String tel){
        if (id >= 0 && id < this.clientes.size()){
            clientes.get(id).setTelefone(tel);
            return true;
        } 
        return false;
    }
    
    public boolean setClienteEndereco(int id, String end){
        if (id >= 0 && id < this.clientes.size()){
            clientes.get(id).setEndereco(end);
            return true;
        } 
        return false;
    }
    
    public boolean setClienteEmail(int id, String email){
        if (id >= 0 && id < this.clientes.size()){
            clientes.get(id).setEmail(email);
            return true;
        } 
        return false;
    }
    
        
    public boolean setClienteCpf(int id, String cpf){
        if (id >= 0 && id < this.clientes.size()){
            clientes.get(id).setCpf(cpf);
            return true;
        } 
        return false;
    }
    
    public boolean removeCliente(int id){
        if (id >= 0 && id < this.clientes.size()){
            clientes.remove(id);
            return true;
        } 
        return false;
    }
    
    
    
    @Override
    public String toString() {
        return "ClienteController{" + "clientes=" + clientes + '}';
    }
    
    
}
