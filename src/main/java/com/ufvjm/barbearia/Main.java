/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ufvjm.barbearia;
import com.ufvjm.barbearia.model.Cliente;
import com.ufvjm.barbearia.controller.ClienteController;
        
/**
 *
 * @author kirito
 */
public class Main {

    public static void main(String[] args) {
        Cliente c = new Cliente("Iago", "12305423254");
        
        System.out.println(c.toString());
        
        ClienteController cC = new ClienteController();
        cC.addNewCliente("Luiz", "12334455365");
        cC.addNewCliente("Italo", "12334455365");
        System.out.println(cC.toString());
        
    }
}
