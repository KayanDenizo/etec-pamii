package com.example.kayanatividadepamii.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.kayanatividadepamii.datamodel.ClienteDataModel;
import com.example.kayanatividadepamii.datasource.AppDataBase;
import com.example.kayanatividadepamii.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteController extends AppDataBase {
    public ClienteController(Context context){
        super(context);
    }

    public boolean salvar(Cliente obj) {
        ContentValues values = new ContentValues();
        values.put(ClienteDataModel.NOME, obj.getNome());
        values.put(ClienteDataModel.EMAIL, obj.getEmail());
        values.put(ClienteDataModel.TELEFONE, obj.getTelefone());
        values.put(ClienteDataModel.ENDERECO, obj.getEndereco());
        values.put(ClienteDataModel.CIDADE, obj.getCidade());
        values.put(ClienteDataModel.ESTADO, obj.getEstado());

        return insert(ClienteDataModel.TABELA, values);
    }

    public boolean alterar(Cliente obj) {
        ContentValues values = new ContentValues();
        values.put(ClienteDataModel.ID, obj.getId());
        values.put(ClienteDataModel.NOME, obj.getNome());
        values.put(ClienteDataModel.EMAIL, obj.getEmail());
        values.put(ClienteDataModel.TELEFONE, obj.getTelefone());
        values.put(ClienteDataModel.ENDERECO, obj.getEndereco());
        values.put(ClienteDataModel.CIDADE, obj.getCidade());
        values.put(ClienteDataModel.ESTADO, obj.getEstado());

        return update(ClienteDataModel.TABELA, values);
    }

    public boolean deletar(int id) {
        return delete(ClienteDataModel.TABELA, id);
    }

    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();
        // Implementar busca se necessário, mas por enquanto vamos deixar a estrutura
        return lista;
    }
}
