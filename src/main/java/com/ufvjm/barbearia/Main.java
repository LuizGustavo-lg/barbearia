/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ufvjm.barbearia;

import com.ufvjm.barbearia.controller.Agenda;
import com.ufvjm.barbearia.controller.AtendimentoController;
import com.ufvjm.barbearia.controller.BalancoMensalController;
import com.ufvjm.barbearia.controller.ClienteController;
import com.ufvjm.barbearia.controller.DespesasController;
import com.ufvjm.barbearia.controller.OrdemDeServicoController;
import com.ufvjm.barbearia.controller.PagamentoController;
import com.ufvjm.barbearia.controller.ServicoController;
import com.ufvjm.barbearia.controller.UsuarioController;
import com.ufvjm.barbearia.view.cli.MenuPrincipalViewCli;


/**
 *
 * @author kirito
 */
public class Main {
    public static void main(String[] args) {
        ClienteController clientesController = new ClienteController();
        UsuarioController usuariosController = new UsuarioController();
        MenuPrincipalViewCli menu = new MenuPrincipalViewCli(usuariosController, clientesController);

        menu.exibirMenu();
    }
}