package com.example.kayanatividadepamii.view;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.kayanatividadepamii.R;
import com.example.kayanatividadepamii.controller.UsuarioController;
import com.example.kayanatividadepamii.model.Usuario;

public class UsuarioActivity extends AppCompatActivity {
    UsuarioController usuarioController;
    EditText editUsuario, editSenha;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_usuario);
        
        usuarioController = new UsuarioController(this);

        editUsuario = findViewById(R.id.edit_usuario);
        editSenha = findViewById(R.id.edit_senha);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editUsuario.getText().toString();
                String senha = editSenha.getText().toString();

                if (TextUtils.isEmpty(nome) || TextUtils.isEmpty(senha)) {
                    Toast.makeText(UsuarioActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                } else {
                    Usuario usuario = new Usuario();
                    usuario.setNome(nome);
                    usuario.setSenha(senha);
                    
                    if (usuarioController.salvar(usuario)) {
                        Toast.makeText(UsuarioActivity.this, "Usuário salvo com sucesso!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(UsuarioActivity.this, "Erro ao salvar usuário", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}