package com.example.listaavaliacaofilmes;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editTextNome;
    Spinner spinnerGenero;
    RatingBar ratingBarNota;
    RadioButton radioButtonFilme;
    RadioButton radioButtonSerie;
    Button buttonInclusao;
    ArrayList<String> generos = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        associaJavaXml();
        carregaGeneros();

        buttonInclusao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validarFormulario() == true) {
                    FilmeModel filmeModel = new FilmeModel();
                    filmeModel.nome = editTextNome.getText().toString();
                    filmeModel.genero = spinnerGenero.getSelectedItem().toString();
                    filmeModel.nota = ratingBarNota.getRating();

                    //operador ternario ==> condicaoBooleana ? valorSeVdd : valorSeFalse
                    filmeModel.tipo = radioButtonFilme.isChecked() ? "Filme" : "Série";

                    FilmeDao filmeDao = new FilmeDao(MainActivity.this);
                    filmeDao.inserir(filmeModel);
                    Toast.makeText(MainActivity.this, "Inserido com sucesso!!!", Toast.LENGTH_LONG);
                }
            }
        });
    }

    private void limparFormulario(){
        editTextNome.setText("");
        spinnerGenero.setSelection(0);
        ratingBarNota.setRating(0);
        radioButtonSerie.setChecked(false);
        radioButtonFilme.setChecked(false);
    }

    private boolean validarFormulario() {
        String nome = editTextNome.getText().toString().trim();
        if (nome.isEmpty()) {
            editTextNome.setError("Digite o nome do filme");
            return false;
        }

        int indiceGenero = spinnerGenero.getSelectedItemPosition();
        if (indiceGenero == 0) {
            Toast.makeText(MainActivity.this, "Escolha um gênero!", Toast.LENGTH_SHORT).show();
            return false;
        }

        float nota = ratingBarNota.getRating();

        if (nota == 0) {
            Toast.makeText(MainActivity.this, "Nota deve ser maior que 0", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!radioButtonFilme.isChecked() && !radioButtonSerie.isChecked()) {
            Toast.makeText(MainActivity.this, "Escolha ao menos um tipo", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void carregaGeneros() {
        generos.add("Escolha o Gênero:");
        generos.add("Ação");
        generos.add("Comédia");
        generos.add("Drama");
        generos.add("Ficção");
        generos.add("Romance");
        generos.add("Terror");

        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, generos);
        spinnerGenero.setAdapter(adapter);
    }

    private void associaJavaXml() {
        editTextNome = findViewById(R.id.edit_text_nome_inclusao);
        ratingBarNota = findViewById(R.id.rating_bar_nota_inclusao);
        radioButtonFilme = findViewById(R.id.radio_tipo_filme);
        radioButtonSerie = findViewById(R.id.radio_tipo_serie);
        buttonInclusao = findViewById(R.id.button_inclusao);
        spinnerGenero = findViewById(R.id.spinner_genero_inclusao);

    }
}
