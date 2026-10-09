package com.example.kayaninterface;

import android.util.Log;

public class Cliente implements iCRUD {

    private String nome;
    private String email;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void incluir() {
        Log.i(Api.TAG, "incluir: Cliente");

    }

    @Override
    public void alterar() {
        Log.i(Api.TAG, "Alterar: Cliente");
    }

    @Override
    public void deletar() {
        Log.i(Api.TAG, "Apagar: Cliente");
    }

    @Override
    public void listar() {
        Log.i(Api.TAG, "Listar: Cliente");
    }
}
