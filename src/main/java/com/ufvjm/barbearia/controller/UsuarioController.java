/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.controller;

import com.ufvjm.barbearia.model.Administrador;
import com.ufvjm.barbearia.model.Autenticador;
import com.ufvjm.barbearia.model.Funcionario;
import com.ufvjm.barbearia.model.Usuario;
import com.ufvjm.barbearia.model.JsonRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Classe responsavel por controlar todos os usuarios
 * @author Luiz Gustavo
 */
public class UsuarioController {
    private List<Usuario> usuarios = new ArrayList<>();
    private JsonRepository<Funcionario> repoF;
    private JsonRepository<Administrador> repoA;
    
    public UsuarioController(){
        repoF = new JsonRepository<>("data/funcionarios.json", Funcionario.class);
        repoA = new JsonRepository<>("data/administradores.json", Administrador.class);
        
        this.carregar();
        if (getQuantAdmins() < 1) {
            usuarios.add(new Administrador("Admin", null, null, null, null, "admin", "admin"));
        }
    }
    
    public void addNewUsuario(Usuario u){
        usuarios.add(u);
    }
    
    
    public void save(){
        List<Funcionario> f = new ArrayList<>();
        List<Administrador> a = new ArrayList<>();

        
        for (Usuario u: usuarios){
            if(u instanceof Administrador admin){
                a.add(admin);
            } else if (u instanceof Funcionario func){
                f.add(func);
            }
        }
        
        repoA.salvar(a);
        repoF.salvar(f);
    }
    
    public void carregar(){
        usuarios.clear();
        usuarios.addAll(repoA.carregar());
        usuarios.addAll(repoF.carregar());
    }
    
    public List<Usuario> getUsuarios() {
        return Collections.unmodifiableList(usuarios);
    }
    
    public List<Usuario> getUsuarios(String nome) {
        return usuarios.stream()
                .filter(u -> u.getNome().contains(nome))
                .toList();
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
        if (u.adminAcess()){
            if (getQuantAdmins() <= 1){
                return false;
            }        
        }
        
        usuarios.remove(u);
        save();
        return true;
    }

    public boolean login(String username, String senha) {
    Usuario encontrado = usuarios.stream()
            .filter(u -> u.getUsername().equals(username) && u.verifyPassword(senha))
            .findFirst()
            .orElse(null);

        if (encontrado == null) {
            return false;
        }
        Autenticador.login(encontrado);
        return true;
    }
    
    @Override
    public String toString() {
        return "UsuarioController{" + "usuarios=" + usuarios + '}';
    }
   
}
