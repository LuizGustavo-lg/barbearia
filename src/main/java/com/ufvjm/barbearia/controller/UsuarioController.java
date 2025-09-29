/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.controller;

import com.ufvjm.barbearia.model.Administrador;
import com.ufvjm.barbearia.model.Funcionario;
import com.ufvjm.barbearia.model.Usuario;
import java.util.ArrayList;
import java.util.List;


/**
 * Classe responsavel por controlar todos os usuarios
 * @author Luiz Gustavo
 */
public class UsuarioController {
    private List<Usuario> usuarios = new ArrayList<>();
    
    public UsuarioController(){}

    public void addNewFuncionario(String nome, String cpf){
        Usuario f = new Funcionario(nome, cpf);
        usuarios.add(f);
    }
    
    public void addNewAdministrador(String nome, String cpf){
        Usuario f = new Administrador(nome, cpf);
        usuarios.add(f);
    }
    
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public Usuario getUsuario(int id){
        return usuarios.get(id);
    }
    
    public boolean setUsuarioPass(int id, String oldPass, String newPass){
        if (id < 0 || id >= this.usuarios.size()){
            return false;
        } 
        return usuarios.get(id).setPassword(oldPass, newPass);
    }
    
    public boolean setUsuarioName(int id, String name){
        if (id >= 0 && id < this.usuarios.size()){
            usuarios.get(id).setNome(name);
            return true;
        } 
        return false;
    }
    
    public boolean setUsuarioTelefone(int id, String tel){
        if (id >= 0 && id < this.usuarios.size()){
            usuarios.get(id).setTelefone(tel);
            return true;
        }
        return false;
    }
    
    public boolean setUsuarioEndereco(int id, String end){
        if (id >= 0 && id < this.usuarios.size()){
            usuarios.get(id).setEndereco(end);
            return true;
        } 
        return false;
    }
    
    public boolean setUsuarioEmail(int id, String email){
        if (id >= 0 && id < this.usuarios.size()){
            usuarios.get(id).setEmail(email);
            return true;
        } 
        return false;
    }
    
        
    public boolean setUsuarioCpf(int id, String cpf){
        if (id >= 0 && id < this.usuarios.size()){
            usuarios.get(id).setCpf(cpf);
            return true;
        } 
        return false;
    }
    
    public boolean removeUsuario(int id){
        if (id >= 0 && id < this.usuarios.size()){
            usuarios.remove(id);
            return true;
        } 
        return false;
    }

    @Override
    public String toString() {
        return "UsuarioController{" + "usuarios=" + usuarios + '}';
    }
    
}
