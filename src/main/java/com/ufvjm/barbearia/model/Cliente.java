/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.model;

/**
 *
 * @author kirito
 */
public class Cliente extends Pessoa{
    private static int cont = 0;
    
    public Cliente(String nome, String cpf, String telefone, String email, String endereco) {
        super(nome, cpf, telefone, email, endereco);
        super.id = ++cont;
    }

    public Cliente(String nome, String cpf) {
        super(nome, cpf);
        super.id = ++cont;
    }
    
    
    
}
