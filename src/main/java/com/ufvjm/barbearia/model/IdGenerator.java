/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.model;

/**
 *
 * @author kirito
 */
import java.util.HashMap;
import java.util.Map;

public class IdGenerator {
    private static final String FILE_PATH = "data/ids.json";
    private static Map<String, Integer> contadores = new HashMap<>();


    /**
     * Gera o próximo ID sequencial com suporte a herança.
     * Se a classe tiver uma superclasse "base" (ex: Usuario),
     * ela compartilha o mesmo contador da superclasse.
     */
    public static synchronized int nextId(Class<?> clazz) {
        // Define o grupo de contagem
        String key = getGrupoDeClasse(clazz);
        int id = contadores.getOrDefault(key, 0) + 1;
        contadores.put(key, id);
        return id;
    }

    public static synchronized void sincronizarClasse(Class<?> clazz, int maiorIdEncontrado) {
        String key = getGrupoDeClasse(clazz);
        int atual = contadores.getOrDefault(key, 0);
        if (maiorIdEncontrado > atual) {
            contadores.put(key, maiorIdEncontrado);
        }
    }
    
    
    /**
     * Determina qual grupo de contagem usar.
     * Por exemplo:
     *  - Funcionario e Administrador usam "Usuario"
     *  - Cliente usa "Cliente"
     */
    private static String getGrupoDeClasse(Class<?> clazz) {
        // se for subclass de Usuario, usar "Usuario" como grupo
        if (Usuario.class.isAssignableFrom(clazz)) {
            return "Usuario";
        }
        // senão, usa o nome da própria classe
        return clazz.getSimpleName();
    }
}