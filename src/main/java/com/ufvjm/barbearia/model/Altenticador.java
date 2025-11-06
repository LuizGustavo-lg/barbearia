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
    private static Usuario user;
    private static boolean logado = false;
    

    public static boolean isLogado() {
        return Altenticador.logado;
    }

    public static boolean isAdmin() {
        if (Altenticador.logado) {
            return Altenticador.user.adminAcess();
        }
        return false;
    }
    
    public static void login(Usuario user) {
        Altenticador.user = user;
        logado = true;
    }
    
    public static void logout(){
        Altenticador.user = null;
        logado = false;
    }
    
}
