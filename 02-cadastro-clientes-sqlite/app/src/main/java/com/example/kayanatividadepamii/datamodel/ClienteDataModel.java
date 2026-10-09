package com.example.kayanatividadepamii.datamodel;

public class ClienteDataModel {
    public static final String TABELA = "cliente";
    public static final String ID = "id";
    public static final String NOME = "nome";
    public static final String CEP = "cep";

    public static final String TELEFONE = "telefone";
    public static final String ENDERECO = "endereco";
    public static final String CIDADE = "cidade";
    public static final String ESTADO = "estado";
    public static final String EMAIL = "email";


    public static String criarTabela(){
        String query = "CREATE TABLE IF NOT EXISTS " + TABELA + "(";
        query += ID + " INTEGER PRIMARY KEY AUTOINCREMENT,";
        query += NOME + " TEXT,";
        query += CEP + " TEXT,";
        query += ENDERECO + " TEXT,";
        query += CIDADE + " TEXT,";
        query += ESTADO + " TEXT,";
        query += TELEFONE + " TEXT,";
        query += EMAIL + " TEXT";
        query += ")";

        return query;

    }
}
