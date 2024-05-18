package com.example.primenota2sm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import androidx.activity.EdgeToEdge;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editTextProcurar;
    Spinner spinnerGenero;
    ListView listViewLivros;
    Button btnAdicionar;
    Button btnDeletar;

    // Array que utilizo para ter opções de generos
    ArrayList<String> genero = new ArrayList<>();
    ArrayAdapter<String> adapter;

<<<<<<< HEAD
=======

>>>>>>> b2d8e5dbfb2b9e170f5a1c3c054b301cbeda117e
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Recebendo ID do xml
        editTextProcurar = findViewById(R.id.edit_text_procurar);
        spinnerGenero = findViewById(R.id.spinner_genero); // Correção aqui
        listViewLivros = findViewById(R.id.listView_livros);
        btnAdicionar = findViewById(R.id.button_adicionar);
        btnDeletar = findViewById(R.id.button_deletar);

        // Ação que abre a tela de cadastrado
        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CadActivity.class);
                startActivity(intent);
            }
        });

        // Ação que abre a tela de exclusão
        btnDeletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DelActivity.class);
                startActivity(intent);
            }
        });

        Generos();
<<<<<<< HEAD
        ListaLivros();
    }

    // Método que lista os livros
    public void ListaLivros(){
        // Aqui você pode implementar a lógica para listar os livros
        // que seriam recuperados do banco de dados, mas como o LivroDao foi removido,
        // você precisa substituir essa lógica com outra implementação.
        // Por exemplo, você pode criar uma lista de livros dummy para exibir na ListView.
        ArrayList<String> listaDummy = new ArrayList<>();
        listaDummy.add("Livro 1");
        listaDummy.add("Livro 2");
        listaDummy.add("Livro 3");

=======
        //ListaLivros(); // Não há necessidade de chamar este método aqui


    }

    // Método de consulta no banco de dados
    /*public void ListaLivros(){
>>>>>>> b2d8e5dbfb2b9e170f5a1c3c054b301cbeda117e
        ArrayAdapter adapter = new ArrayAdapter(
                MainActivity.this, android.R.layout.simple_list_item_1, listaDummy
        );

        listViewLivros.setAdapter(adapter);
    }*/

<<<<<<< HEAD
=======

>>>>>>> b2d8e5dbfb2b9e170f5a1c3c054b301cbeda117e
    // Generos que podem ser adicionados no aplicativo
    public void Generos() {
        genero.add("Procura por gênero:");
        genero.add("Ação");
        genero.add("Comédia");
        genero.add("Drama");
        genero.add("Ficção");
        genero.add("Mistério");
        genero.add("Não ficção");
        genero.add("Romance");
        genero.add("Terror");

        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, genero);
        spinnerGenero.setAdapter(adapter);
    }
}
