package com.example.kayanatividadepamii;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.Button;
import android.widget.Toast;

import com.example.kayanatividadepamii.controller.ClienteController;
import com.example.kayanatividadepamii.model.Cliente;

public class ApagarCliente extends AppCompatActivity {

    Button btnApagar, btnCancelar;
    Cliente cliente;
    ClienteController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_apagar_cliente);

        btnApagar = findViewById(R.id.btnApagar);
        btnCancelar = findViewById(R.id.btnCancelar);

        controller = new ClienteController(this);

        cliente = (Cliente) getIntent().getSerializableExtra("cliente");

        btnApagar.setOnClickListener(v -> {
            if (cliente != null && controller.deletar(cliente.getId())) {
                Toast.makeText(this, "Cliente apagado com sucesso!", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Erro ao apagar cliente!", Toast.LENGTH_SHORT).show();
            }
        });

        btnCancelar.setOnClickListener(v -> finish());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}