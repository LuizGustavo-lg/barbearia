/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.model;

/**
 *
 * @author kirito
 */
public class Usuario extends Pessoa{
    private String password;
    private static int cont;

    public Usuario(String nome, String cpf, String telefone, String email, String endereco) {
        super(nome, cpf, telefone, email, endereco);
        super.id = ++cont;
    }
    
    public Usuario(String nome, String cpf) {
        super(nome, cpf);
        super.id = ++cont;
    }

    public boolean verifyPassword(String pass){
        return this.password.equals(pass);
    }

    public boolean setPassword(String oldPass, String newPass) {
        if (this.verifyPassword(oldPass)){
            this.password = newPass;
            return true;
        }
        return false;
    }
    
    public boolean adminAcess(){
        return false;
    }
}
