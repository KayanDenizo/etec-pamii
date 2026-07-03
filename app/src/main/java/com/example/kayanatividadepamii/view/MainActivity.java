package com.example.kayanatividadepamii.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.kayanatividadepamii.AlterarDadosActivity;
import com.example.kayanatividadepamii.ApagarCliente;
import com.example.kayanatividadepamii.CadastroCliente;
import com.example.kayanatividadepamii.R;

public class MainActivity extends AppCompatActivity {
    Button btnCadastrar, btnAlterar, btnApagar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnCadastrar = findViewById(R.id.btn_cadastrar);
        btnAlterar = findViewById(R.id.btn_alterar);
        btnApagar = findViewById(R.id.btn_apagar);

        btnCadastrar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CadastroCliente.class);
            startActivity(intent);
        });

        btnAlterar.setOnClickListener(v -> {
            // Aqui normalmente passaria um objeto Cliente, mas para teste:
            Intent intent = new Intent(MainActivity.this, AlterarDadosActivity.class);
            startActivity(intent);
        });

        btnApagar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ApagarCliente.class);
            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}