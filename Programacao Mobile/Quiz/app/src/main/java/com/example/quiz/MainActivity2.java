package com.example.quiz;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    RadioButton radioButtonCorreto;
    Button buttonResponder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        radioButtonCorreto = findViewById(R.id.radio_button_b_q2);
        buttonResponder = findViewById(R.id.button_responder_q2);

        buttonResponder.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(radioButtonCorreto.isChecked()){
                    Toast.makeText(MainActivity2.this,"Correto",Toast.LENGTH_SHORT);
                    Util.pontos++;
                }
                else{
                    Toast.makeText(MainActivity2.this,"Você errou feio",Toast.LENGTH_SHORT);
                }
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            }


        });
    }
}