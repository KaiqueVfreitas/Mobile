package com.example.listaavaliacaofilmes;

import androidx.annotation.NonNull;

public class FilmeModel {
    int id;
    String nome;
    String genero;
    String tipo;
    double nota;

    @NonNull
    @Override
    public String toString(){
        return nome + "-" + genero + " - " + nota;

    }
}
