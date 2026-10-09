package com.example.kayanatividadepamii;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kayanatividadepamii.controller.ClienteController;
import com.example.kayanatividadepamii.model.Cliente;

public class CadastroCliente extends AppCompatActivity {

    EditText editNome, editEmail, editTelefone;
    Button btnSalvar;
    ClienteController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastro_cliente);

        editNome = findViewById(R.id.edtNome);
        editEmail = findViewById(R.id.edtEmail);
        editTelefone = findViewById(R.id.edtTelefone);
        btnSalvar = findViewById(R.id.btnSalvar);

        controller = new ClienteController(this);

        btnSalvar.setOnClickListener(v -> {
            Cliente cliente = new Cliente();
            cliente.setNome(editNome.getText().toString());
            cliente.setEmail(editEmail.getText().toString());
            cliente.setTelefone(editTelefone.getText().toString());

            if (controller.salvar(cliente)) {
                Toast.makeText(this, "Cliente cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Erro ao cadastrar cliente!", Toast.LENGTH_SHORT).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}