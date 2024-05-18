package com.example.primenota2sm;

public class LivroModel {
    private String genero;
    private String nome;
    private int nota;
    private String tipo;
    private int id;

    public LivroDao(){

    }

    public LivroModel(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public LivroModel(String genero, int nota, String tipo) {
        this.genero = genero;
        this.nota = nota;
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getGenero() {
        return genero;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }




}
