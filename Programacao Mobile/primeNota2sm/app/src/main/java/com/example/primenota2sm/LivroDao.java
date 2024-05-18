package com.example.primenota2sm;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class LivroDao extends SQLiteOpenHelper {

    private final String  TABELA = "TB_LIVRO";
    public LivroDao(@Nullable Context context) {
        super(context,  "DB_LIVRO", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String comando = "CREATE TABLE " + TABELA + "(" +
                "ID INTEGER PRIMARY KEY," +
                "NOME VARCHAR(100) NOT NULL," +
                "GENERO VARCHAR(30) NOT NULL," +
                "NOTA DECIMAL(3,1) NOT NULL," +
                "TIPO CHAR(15) NOT NULL)";
        db.execSQL(comando); // Alteração feita aqui

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public long inserir(LivroModel livroModel){
        ContentValues values = new ContentValues();
        values.put("NOME", livroModel.getNome());
        values.put("GENERO", livroModel.getGenero());
        values.put("NOTA", livroModel.getNota());
        values.put("TIPO", livroModel.getTipo());


        return getWritableDatabase().insert(TABELA, null, values); // Alteração feita aqui
    }
}
