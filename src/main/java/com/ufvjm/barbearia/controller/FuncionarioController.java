/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.controller;

import com.ufvjm.barbearia.model.Funcionario;
import java.util.ArrayList;
import java.util.List;


/**
 * Classe responsavel por controlar todos os clientes
 * @author Luiz Gustavo
 */
public class FuncionarioController {
    private List<Funcionario> funcionarios = new ArrayList<>();
    
    public FuncionarioController(){}

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public Funcionario getFuncionario(int id){
        return funcionarios.get(id);
    }
    
    public boolean setFuncionarioPass(int id, String pass){
        if (id >= 0 && id < this.funcionarios.size()){
            funcionarios.get(id).setPassword(pass);
            return true;
        } 
        return false;
    }
    
    public boolean setFuncionarioName(int id, String name){
        if (id >= 0 && id < this.funcionarios.size()){
            funcionarios.get(id).setNome(name);
            return true;
        } 
        return false;
    }
    
    public boolean setFuncionarioTelefone(int id, String tel){
        if (id >= 0 && id < this.funcionarios.size()){
            funcionarios.get(id).setTelefone(tel);
            return true;
        }
        return false;
    }
    
    public boolean setFuncionarioEndereco(int id, String end){
        if (id >= 0 && id < this.funcionarios.size()){
            funcionarios.get(id).setEndereco(end);
            return true;
        } 
        return false;
    }
    
    public boolean setFuncionarioEmail(int id, String email){
        if (id >= 0 && id < this.funcionarios.size()){
            funcionarios.get(id).setEmail(email);
            return true;
        } 
        return false;
    }
    
        
    public boolean setFuncionarioCpf(int id, String cpf){
        if (id >= 0 && id < this.funcionarios.size()){
            funcionarios.get(id).setCpf(cpf);
            return true;
        } 
        return false;
    }
    
    public boolean removeFuncionario(int id){
        if (id >= 0 && id < this.funcionarios.size()){
            funcionarios.remove(id);
            return true;
        } 
        return false;
    }

    @Override
    public String toString() {
        return "FuncionarioController{" + "funcionarios=" + funcionarios + '}';
    }
    
}
