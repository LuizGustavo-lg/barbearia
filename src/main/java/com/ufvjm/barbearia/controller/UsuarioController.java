/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.controller;

import com.ufvjm.barbearia.model.Administrador;
import com.ufvjm.barbearia.model.Funcionario;
import com.ufvjm.barbearia.model.Usuario;
import java.util.ArrayList;
import java.util.Collections;
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
        return Collections.unmodifiableList(usuarios);
    }

    public Usuario getUsuario(int id){
        return usuarios.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElseThrow();
    }
    
    private long getQuantAdmins(){
        return usuarios.stream()
                .filter(u -> u.adminAcess() == true)
                .count();
    }
    
    public boolean removeUsuario(int id){
        Usuario u = getUsuario(id);
        if (getQuantAdmins() <= 1){
            return false;
        }
        usuarios.remove(u);
        return true;
    }

    @Override
    public String toString() {
        return "UsuarioController{" + "usuarios=" + usuarios + '}';
    }
    
}
