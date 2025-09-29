/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.model;

/**
 *
 * @author kirito
 */
public class Altenticador {
    private static boolean logado = false;

    public static boolean isLogado() {
        return logado;
    }

    public static void setLogado(boolean logado) {
        Altenticador.logado = logado;
    }
    
    
}
