/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.model;

/**
 *
 * @author kirito
 */
public class Funcionario extends Usuario{
    public Funcionario(String nome, String cpf, String telefone, String email, String endereco, String pass, String username) {
        super(nome, cpf, telefone, email, endereco, pass, username);
    }
    
    public Funcionario(String nome, String cpf) {
        super(nome, cpf);
    }

    public Funcionario(){}
}
