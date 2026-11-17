package com.example.whatsapplist;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsapplist.adapter.AdapterUsuario;
import com.example.whatsapplist.model.UsuarioModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    private final List<UsuarioModel> usuarioList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_usuarios);

        // LayoutManager: define o formato da lista (vertical, sem inverter a ordem)
        recyclerView.setLayoutManager(new LinearLayoutManager(
                MainActivity.this,
                LinearLayoutManager.VERTICAL,
                false
        ));

        // melhora a performance, já que o tamanho do RecyclerView não muda
        recyclerView.setHasFixedSize(true);

        // monta a lista antes de entregá-la ao adapter
        usuarios();

        AdapterUsuario adapterUsuario = new AdapterUsuario(usuarioList);
        recyclerView.setAdapter(adapterUsuario);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    /** Cria os usuários (de forma estática) e adiciona na lista. */
    public void usuarios() {
        usuarioList.add(new UsuarioModel(R.drawable.usuario1, "Fabio Claret", "Olá, como vai?"));
        usuarioList.add(new UsuarioModel(R.drawable.usuario2, "Mariana", "Oi, tudo bem?"));
        usuarioList.add(new UsuarioModel(R.drawable.usuario1, "Carlos", "Bom dia"));
        usuarioList.add(new UsuarioModel(R.drawable.usuario2, "Sueli Muniz", "E aí?"));
        usuarioList.add(new UsuarioModel(R.drawable.usuario1, "Paulo Rogério", "Vamos pra escola hoje?"));
        usuarioList.add(new UsuarioModel(R.drawable.usuario2, "Thiago", "Qual lab?"));
        usuarioList.add(new UsuarioModel(R.drawable.usuario1, "Bárbara", "O professor faltou"));
        usuarioList.add(new UsuarioModel(R.drawable.usuario1, "Giseli", "Ebaaa"));
        usuarioList.add(new UsuarioModel(R.drawable.usuario2, "Matheus", "Bora pro intervalo"));
        usuarioList.add(new UsuarioModel(R.drawable.usuario1, "Orion", "Já pode entregar?"));
        usuarioList.add(new UsuarioModel(R.drawable.usuario2, "Djila", "Dicas de normas ABNT para o TCC"));
    }
}
