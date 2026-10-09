package com.example.kayanatividadepamii.model;

import java.io.Serializable;

public class Usuario implements Serializable {
    private int id ;
    private String nome;
    private String senha;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
