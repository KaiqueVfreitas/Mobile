package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button radioButtonCorreto;
    Button buttonResponder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioButtonCorreto = findViewById(R.id.radio_button_b);
        buttonResponder = findViewById(R.id.button_responder_q1);

        buttonResponder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radioButtonCorreto.createAccessibilityNodeInfo().isChecked()){
                    Toast.makeText(MainActivity.this, "Correto", Toast.LENGTH_SHORT).show();
                    //abrir nova tela (TelaAtual.this, TelaAAbrir.class)
                    Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, "Errado", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}