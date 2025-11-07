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

public class JsonRepository<T> {
    private final String caminho;
    private final Class<T> tipo;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

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
            return lista != null ? lista : new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}