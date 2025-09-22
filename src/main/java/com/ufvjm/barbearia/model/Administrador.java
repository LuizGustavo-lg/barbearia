/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.model;

/**
 *
 * @author kirito
 */
public class Administrador extends Funcionario{
    
    public Administrador(String nome, String cpf, String telefone, String email, String endereco) {
        super(nome, cpf, telefone, email, endereco, "Administrador");
    }

    public Administrador(String nome, String cpf) {
        super(nome, cpf);
    }
    

    @Override
    public boolean adminAcess(){
        return true;
    }
}
