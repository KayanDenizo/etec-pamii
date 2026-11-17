package com.example.whatsapplist.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsapplist.R;
import com.example.whatsapplist.model.UsuarioModel;

import java.util.List;

/**
 * O adapter é o "cérebro" da lista: adapta os dados (lista de UsuarioModel)
 * para as visualizações (usuario_item.xml) exibidas pelo RecyclerView.
 */
public class AdapterUsuario extends RecyclerView.Adapter<AdapterUsuario.UsuarioViewHolder> {

    private final List<UsuarioModel> usuarioList;

    public AdapterUsuario(List<UsuarioModel> usuarioList) {
        this.usuarioList = usuarioList;
    }

    /** Cria a visualização de um item a partir do layout usuario_item. */
    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemLista = layoutInflater.inflate(R.layout.usuario_item, parent, false);
        return new UsuarioViewHolder(itemLista);
    }

    /** Exibe os dados do usuário da posição atual dentro do item. */
    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {
        UsuarioModel usuario = usuarioList.get(position);
        holder.foto.setImageResource(usuario.getFoto());
        holder.nome.setText(usuario.getNome());
        holder.mensagem.setText(usuario.getMensagem());
    }

    /** Tamanho total da lista. */
    @Override
    public int getItemCount() {
        return usuarioList.size();
    }

    /** Guarda as referências dos componentes de um item da lista. */
    public static class UsuarioViewHolder extends RecyclerView.ViewHolder {
        ImageView foto;
        TextView nome;
        TextView mensagem;

        public UsuarioViewHolder(@NonNull View itemView) {
            super(itemView);
            foto = itemView.findViewById(R.id.usuario_foto);
            nome = itemView.findViewById(R.id.nome_usuario);
            mensagem = itemView.findViewById(R.id.mensagem);
        }
    }
}
