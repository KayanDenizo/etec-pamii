package com.example.kayanatividadepamii.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.kayanatividadepamii.datamodel.UsuarioDataModel;
import com.example.kayanatividadepamii.datasource.AppDataBase;
import com.example.kayanatividadepamii.model.Usuario;

public class UsuarioController extends AppDataBase {
    public UsuarioController(Context context) {
        super(context);
    }

    public boolean salvar(Usuario obj) {
        ContentValues values = new ContentValues();
        values.put(UsuarioDataModel.NOME, obj.getNome());
        values.put(UsuarioDataModel.SENHA, obj.getSenha());

        return insert(UsuarioDataModel.TABELA, values);
    }

    public boolean autenticar(String usuario, String senha) {
        return true;
    }
}
