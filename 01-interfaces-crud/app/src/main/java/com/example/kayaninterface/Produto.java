package com.example.kayaninterface;

import android.util.Log;

public class Produto implements iCRUD{

    private String fornecedor;
    private String nome;


    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public void incluir() {
        Log.e(Api.TAG, "incluir: Produto");
    }

    @Override
    public void alterar() {
        Log.e(Api.TAG, "Alterar: Produto");
    }

    @Override
    public void deletar() {
        Log.e(Api.TAG, "Deletar: Produto");
    }

    @Override
    public void listar() {
        Log.e(Api.TAG, "Listar: Produto");
    }
}
