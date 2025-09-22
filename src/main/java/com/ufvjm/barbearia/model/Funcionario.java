/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.model;

/**
 *
 * @author kirito
 */
public class Funcionario extends Pessoa{
    private String password;
    private String cargo;
    
    public Funcionario(String nome, String cpf, String telefone, String email, String endereco, String cargo) {
        super(nome, cpf, telefone, email, endereco);
        this.cargo = cargo;
    }
    
    public Funcionario(String nome, String cpf, String telefone, String email, String endereco) {
        super(nome, cpf, telefone, email, endereco);
    }
    
    public Funcionario(String nome, String cpf) {
        super(nome, cpf);
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean adminAcess(){
        return false;
    }
}
