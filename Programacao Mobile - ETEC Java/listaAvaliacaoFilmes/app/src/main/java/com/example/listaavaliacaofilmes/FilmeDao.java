package com.example.listaavaliacaofilmes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class FilmeDao extends SQLiteOpenHelper {


    public FilmeDao(Context context){
        super(context, "db_filme", null, 1);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String comando = "create table tb_filme(" +
                "id integer primary key," + //por padrão já é autoincrement
                "nome varchar(200) not null," +
                "genero varchar(30) not null," +
                "nota decimal(3,1) not null," +
                "tipo char(5) not null)";
        db.execSQL(comando);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int l, int i1) {
        //alterar as estruturas fisicas das tabelas
        //é chamado quando a versão atual do DB é superior à instalada

        String comando = "alter table tb_filme add column nova_coluna integer";
        db.execSQL(comando);
    }

    public void inserir(FilmeModel filme){
        //ContentValues associa o nome da coluna ao seu valor
        ContentValues values = new ContentValues();
        values.put("nome", filme.nome);
        values.put("genero", filme.genero);
        values.put("nota", filme.nota);
        values.put("tipo", filme.tipo);

        getWritableDatabase().insertOrThrow("tb_filme", null, values);
    }

    public ArrayList<FilmeModel> consultarTodos(){
        String comando = "select *  from tb_filme";
        Cursor cursor = getReadableDatabase().rawQuery(comando,null);
        ArrayList<FilmeModel> listFilmes = new ArrayList<>();

        while (cursor.moveToNext()){
            FilmeModel filmeModel = new FilmeModel();
            filmeModel.id = cursor.getInt(0);
            filmeModel.nome = cursor.getString(1);
            filmeModel.genero = cursor.getString(2);
            filmeModel.nota = cursor.getDouble(3);
            filmeModel.tipo = cursor.getString(4);
            listFilmes.add(filmeModel);
        }
        return listFilmes;
    }
}
