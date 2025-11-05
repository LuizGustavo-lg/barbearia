/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.comparator.cliente;

import com.ufvjm.barbearia.model.Cliente;
import java.util.Comparator;

/**
 *
 * @author kirito
 */
public class ClienteNomeComparator implements Comparator<Cliente>{

    @Override
    public int compare(Cliente c1, Cliente c2) {
        return c1.getNome().compareToIgnoreCase(c2.getNome());
    }
}
