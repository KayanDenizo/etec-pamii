package com.example.whatsapplist.model;

/**
 * Modelo de um contato da lista.
 * A foto é um int porque as imagens ficam em res/drawable e
 * são localizadas pelo id gerado na classe R (ex.: R.drawable.usuario1).
 */
public class UsuarioModel {
    private int foto;
    private String nome;
    private String mensagem;

    public UsuarioModel(int foto, String nome, String mensagem) {
        this.foto = foto;
        this.nome = nome;
        this.mensagem = mensagem;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
