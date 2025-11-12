/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.utils;

import java.util.List;

/**
 *
 * @author kirito
 */
public class PrintUtils {
    public static void printTitulo(String titulo) {
        System.out.println("\n===== " + titulo.toUpperCase() + " =====");
    }
    
    public static void printMenu(String... menuItens){
        for (int i = 0; i < menuItens.length; i++){
            System.out.printf("%2d - %s \n", (i+1), menuItens[i]);
        }
        System.out.println(" 0 - Sair");
    }

    public static void printLinha() {
        System.out.println("-------------------------------------------------------------");
    }
    
    
     public static void printTable(String[] headers, List<String[]> rows) throws IllegalArgumentException {
        if (headers == null || headers.length == 0) {
            throw new IllegalArgumentException("Headers não pode ser nulo");
        }

        int[] colWidths = new int[headers.length];
        for (int i = 0; i < headers.length; i++) {
            colWidths[i] = headers[i].length();
        }

        for (String[] row : rows) {
            for (int i = 0; i < row.length; i++) {
                if (row[i] != null && row[i].length() > colWidths[i]) {
                    colWidths[i] = row[i].length();
                }
            }
        }

        PrintUtils.printBorder(colWidths, "=");

        PrintUtils.printRow(headers, colWidths);

        PrintUtils.printBorder(colWidths, "-");

        for (String[] row : rows) {
            PrintUtils.printRow(row, colWidths);
        }

        PrintUtils.printBorder(colWidths, "=");
    }

    private static void printBorder(int[] colWidths, String borderChar) {
        StringBuilder sb = new StringBuilder();
        sb.append(borderChar.repeat(2));
        for (int w : colWidths) {
            sb.append(borderChar.repeat(w + 3));
        }
        System.out.println(sb);
    }

    private static void printRow(String[] values, int[] colWidths) {
        StringBuilder sb = new StringBuilder();
        sb.append("| ");
        for (int i = 0; i < colWidths.length; i++) {
            String value = (i < values.length && values[i] != null) ? values[i] : "";
            sb.append(String.format("%-" + colWidths[i] + "s | ", value));
        }
        System.out.println(sb);
    }
}
