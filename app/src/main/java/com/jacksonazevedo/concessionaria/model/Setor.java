package com.jacksonazevedo.concessionaria.model;

import com.google.gson.annotations.SerializedName;

public class Setor {

    public int id;

    public String nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    @Override
    public String toString() {
        return "nome: "+getNome();
    }

    public Setor(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
