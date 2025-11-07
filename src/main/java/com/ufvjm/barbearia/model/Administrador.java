/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.model;

/**
 *
 * @author kirito
 */
public class Administrador extends Usuario{

    public Administrador(String nome, String cpf, String telefone, String email, String endereco, String pass) {
        super(nome, cpf, telefone, email, endereco, pass);
    }

    public Administrador(String nome, String cpf) {
        super(nome, cpf);
    }

    public Administrador(String nome, String cpf, String telefone, String email, String endereco, int id) {
        super(nome, cpf, telefone, email, endereco, id);
    }
    
    public Administrador(){};
    
    @Override
    public boolean adminAcess(){
        return true;
    }
}
