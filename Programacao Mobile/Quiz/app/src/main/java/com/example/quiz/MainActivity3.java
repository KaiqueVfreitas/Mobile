package com.example.quiz;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.util.ULocale;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    RadioButton radioButtonCorreto;
    Button buttonResponder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        radioButtonCorreto = findViewById(R.id.radio_button_d_q3);
        buttonResponder = findViewById(R.id.button_responder_q3);

        buttonResponder.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(radioButtonCorreto.isChecked()){
                    Toast.makeText(MainActivity3.this,"Correto",Toast.LENGTH_SHORT);
                    Util.pontos++;
                }
                else{
                    Toast.makeText(MainActivity3.this,"Você errou feio",Toast.LENGTH_SHORT);
                }
                Toast.makeText(MainActivity3.this, "Pontos: " + Util.pontos, Toast.LENGTH_LONG). show();
            }

        });
    }
}