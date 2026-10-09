package com.example.kayaninterface;

import android.util.Log;

public class Fornecedor implements iCRUD {
    private String nome;
    private String cnpj;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public void incluir() {
        Log.e(Api.TAG, "incluir: Fornecedor");
    }

    @Override
    public void alterar() {
        Log.e(Api.TAG, "alterar: Fornecedor");
    }

    @Override
    public void deletar() {
        Log.e(Api.TAG, "deletar: Fornecedor");
    }

    @Override
    public void listar() {
        Log.e(Api.TAG, "listar: Fornecedor");
    }
}
