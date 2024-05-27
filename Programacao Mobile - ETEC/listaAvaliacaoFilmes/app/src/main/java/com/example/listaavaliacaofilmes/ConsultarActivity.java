package com.example.listaavaliacaofilmes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ConsultarActivity extends AppCompatActivity {
    EditText editTextNome;
    ListView listViewFilmes;
    Button buttonNovoFilme;
    ArrayList<FilmeModel> listFilme = new ArrayList<>();
    ArrayAdapter adapter;




    public void Declaracao(){
        editTextNome = findViewById(R.id.edit_text_pesquisar_nome);
        listViewFilmes = findViewById(R.id.list_view_filmes);
        buttonNovoFilme = findViewById(R.id.button_novo_filme);
    }





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);
        Declaracao();

        FilmeDao dao = new FilmeDao(ConsultarActivity.this);
        listFilme = dao.consultarTodos();
        adapter = new ArrayAdapter(ConsultarActivity.this,
                android.R.layout.simple_list_item_1, listFilme);
        listViewFilmes.setAdapter(adapter);

        buttonNovoFilme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConsultarActivity.this,
                        MainActivity.class);
                startActivity(intent);
            }
        });


    }








}