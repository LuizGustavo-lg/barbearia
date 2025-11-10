/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.model;

import org.mindrot.jbcrypt.BCrypt;


/**
 *
 * @author kirito
 */
public class Usuario extends Pessoa{
    private String password;
    private String username;
    
    public Usuario(){
    }
    
    public Usuario(String nome, String cpf, String telefone, String email, String endereco, String pass, String username) {
        super(nome, cpf, telefone, email, endereco);
        this.password = gerarHash(pass);
        this.username = username;
    }
    
    public Usuario(String nome, String cpf) {
        super(nome, cpf);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String gerarHash(String senha) {
        return BCrypt.hashpw(senha, BCrypt.gensalt()); // Gera o hash seguro
    }
    
    public boolean verifyPassword(String pass){
        return BCrypt.checkpw(pass, this.password);
    }

    public boolean setPassword(String oldPass, String newPass) {
        if (this.verifyPassword(oldPass)){
            this.password = gerarHash(newPass);
            return true;
        }
        return false;
    }
    
    public boolean adminAcess(){
        return false;
    }
}
