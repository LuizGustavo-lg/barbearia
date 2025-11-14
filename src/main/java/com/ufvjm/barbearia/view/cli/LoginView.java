/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.view.cli;

import com.ufvjm.barbearia.controller.UsuarioController;
import com.ufvjm.barbearia.utils.PrintUtils;
import java.util.Scanner;

/**
 *
 * @author kirito
 */
public class LoginView{
    private Scanner scanner = new Scanner(System.in);
    UsuarioController controllerUser;

    public LoginView(UsuarioController controllerUser) {
        this.controllerUser = controllerUser;
    }
    


    public void mostrarTelaLogin() {
        String usuario;
        String senha;
        boolean logado = false;


        do {
            PrintUtils.printTitulo("LOGIN SISTEMA");


            System.out.print("Usuário: ");
            usuario = scanner.nextLine();


            System.out.print("Senha: ");
            senha = scanner.nextLine();


            logado = controllerUser.login(usuario, senha);

            if (!logado) {
                System.out.println("Usuário ou senha incorretos.\nDeseja Tentar novamente? [y/n]");
                if (scanner.nextLine().toLowerCase().equals("n")) {
                    return;
                }
            }


        } while (!logado);

        System.out.println("Login realizado com sucesso!");
    }
}