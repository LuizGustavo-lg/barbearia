/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.model;

/**
 *
 * @author kirito
 */
public class Autenticador {
    private static Usuario user;
    private static boolean logado = false;
    

    public static boolean isLogado() {
        return Autenticador.logado;
    }

    public static boolean isAdmin() {
        if (Autenticador.logado) {
            return Autenticador.user.adminAcess();
        }
        return false;
    }
    
    public static void login(Usuario user) {
        Autenticador.user = user;
        logado = true;
    }
    
    public static void logout(){
        Autenticador.user = null;
        logado = false;
    }
    
}
