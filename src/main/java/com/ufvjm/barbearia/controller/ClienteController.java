/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.controller;

import com.ufvjm.barbearia.model.Cliente;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kirito
 */
public class ClienteController {
    private List<Cliente> clientes = new ArrayList<>();
    
    public ClienteController(){}
    
    public void addNewCliente(String nome, String cpf){
        Cliente c = new Cliente(nome, cpf);
        clientes.add(c);
    }

    
    
    @Override
    public String toString() {
        return "ClienteController{" + "clientes=" + clientes + '}';
    }
    
    
}
