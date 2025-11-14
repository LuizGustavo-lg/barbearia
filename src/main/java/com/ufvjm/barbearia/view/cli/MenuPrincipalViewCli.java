/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.view.cli;

import com.ufvjm.barbearia.controller.ClienteController;
import com.ufvjm.barbearia.controller.UsuarioController;
import com.ufvjm.barbearia.model.Autenticador;
import com.ufvjm.barbearia.utils.PrintUtils;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author kirito
 */
public class MenuPrincipalViewCli {
    private Scanner scanner = new Scanner(System.in);

    private UsuarioViewCli usuarioView;
    private ClienteViewCli clienteView;
    private LoginView loginView;

    public MenuPrincipalViewCli(UsuarioController userContr, ClienteController cliContr) {
        this.usuarioView = new UsuarioViewCli(userContr);
        this.clienteView = new ClienteViewCli(cliContr);
        this.loginView = new LoginView(userContr);
    }

    public void exibirMenu() {
        loginView.mostrarTelaLogin();
        if (!Autenticador.isLogado()) { return; }
        
        int opcao;
        
        do {
            PrintUtils.printTitulo("Barbearia");
            PrintUtils.printMenu("Clientes", "Agenda", "Atendimento", "Produtos e Servicos", "Usuarios", "Financeiro");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> clienteView.menu();
//                case 3 -> financeiroView.menu();
                case 5 -> usuarioView.menu();
                case 0 -> System.out.println("Encerrando sistema...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
}