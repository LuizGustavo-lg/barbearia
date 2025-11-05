/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.comparator.reserva;

import com.ufvjm.barbearia.model.Reserva;
import java.util.Comparator;

/**
 *
 * @author kirito
 */
public class ReservaDateComparator implements Comparator<Reserva>{

    @Override
    public int compare(Reserva r1, Reserva r2) {
        return r1.getDatetime().compareTo(r2.getDatetime());
    }
    
}
