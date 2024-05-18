package com.example.listtarefa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText editTextNomeTarefa;
    Button buttonAdicionar;
    ListView listViewTarefas;
    ArrayList<String>  arrayListTarefas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,
                android.R.layout.simple_list_item_1, arrayListTarefas);
        editTextNomeTarefa = findViewById(R.id.edit_text_nova_tarefa);
        buttonAdicionar = findViewById(R.id.button_adicionar);
        listViewTarefas = findViewById(R.id.list_view_tarefas);
        listViewTarefas.setAdapter(adapter);

        listViewTarefas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                arrayListTarefas.remove(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });

        buttonAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayListTarefas.add(editTextNomeTarefa.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });

    }
}
