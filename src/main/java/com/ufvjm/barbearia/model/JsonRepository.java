/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufvjm.barbearia.model;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.*;
import com.fatboyindustrial.gsonjavatime.Converters;


public class JsonRepository<T> {
    private final String caminho;
    private final Class<T> tipo;
    private Gson gson = Converters.registerAll(new GsonBuilder())
    .setPrettyPrinting()
    .create();

    public JsonRepository(String caminho, Class<T> tipo) {
        this.caminho = caminho;
        this.tipo = tipo;
    }

    public void salvar(List<T> lista) {
        try (FileWriter writer = new FileWriter(caminho)) {
            gson.toJson(lista, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<T> carregar() {
        try (FileReader reader = new FileReader(caminho)) {
            Type listType = TypeToken.getParameterized(List.class, tipo).getType();
            List<T> lista = gson.fromJson(reader, listType);
            
            if (lista == null) {
                lista = new ArrayList<>();
            }
            
            
            if (!lista.isEmpty() && lista.get(0) instanceof EntidadeBaseId entidade) {
                // pega o maior ID na lista
                int maxId = lista.stream()
                        .mapToInt(obj -> ((EntidadeBaseId) obj).getId())
                        .max()
                        .orElse(0);
                // atualiza o contador global
                IdGenerator.sincronizarClasse(tipo, maxId);
            }
            
            return lista;
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}