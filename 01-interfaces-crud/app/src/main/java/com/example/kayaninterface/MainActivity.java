package com.example.kayaninterface;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Cliente client = new Cliente();
    Fornecedor fornecedor = new Fornecedor();
    Produto produto = new Produto();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        client.setNome("Kayan Denizo");
        client.setEmail("kayan@gmail.com");
        client.incluir();

        fornecedor.setNome("Fornecedor ABC");
        fornecedor.setCnpj("12.345.678/0001-99");
        fornecedor.incluir();

        produto.setNome("Smartphone");
        produto.setFornecedor("Fornecedor ABC");
        produto.incluir();
    }
}