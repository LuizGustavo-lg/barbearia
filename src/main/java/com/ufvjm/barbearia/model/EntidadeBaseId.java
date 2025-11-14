/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.model;

/**
 *
 * @author kirito
 */
public abstract class EntidadeBaseId {
    protected int id;

    public EntidadeBaseId() {
        this.id = IdGenerator.nextId(this.getClass());
    }
    
    public EntidadeBaseId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}