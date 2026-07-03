package com.example.kayanatividadepamii.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.kayanatividadepamii.api.AppUtil;
import com.example.kayanatividadepamii.datamodel.ClienteDataModel;
import com.example.kayanatividadepamii.datamodel.UsuarioDataModel;

public class AppDataBase extends SQLiteOpenHelper {
    public static final String NAME = "etim.db";
    public static int version = 2;

    SQLiteDatabase db;
    public AppDataBase(Context context) {
        super(context, NAME, null, version);
        this.db = getWritableDatabase();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(AppUtil.TAG,"Criando a tabela "+ ClienteDataModel.TABELA);
        db.execSQL(ClienteDataModel.criarTabela());

        Log.i(AppUtil.TAG,"Criando a tabela "+ UsuarioDataModel.TABELA);
        db.execSQL(UsuarioDataModel.criarTabela());
    }

    public boolean insert(String tabela, ContentValues values) {
        try {
            return db.insert(tabela, null, values) > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean update(String tabela, ContentValues values) {
        try {
            int id = values.getAsInteger("id");
            return db.update(tabela, values, "id=?", new String[]{Integer.toString(id)}) > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean delete(String tabela, int id) {
        try {
            return db.delete(tabela, "id=?", new String[]{Integer.toString(id)}) > 0;
        } catch (Exception e) {
            return false;
        }
    }

}
