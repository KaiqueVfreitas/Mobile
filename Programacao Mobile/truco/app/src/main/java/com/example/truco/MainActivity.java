package com.example.truco;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView editTextNos;
    TextView editTextEles;
    Button buttonMaisNos;
    Button buttonMaisEles;
    Button buttonMenosNos;
    Button buttonMenosEles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNos = findViewById(R.id.edit_text_nos);
        editTextEles = findViewById(R.id.edit_text_eles);
        buttonMaisNos = findViewById(R.id.button_mais_nos);
        buttonMaisEles = findViewById(R.id.button_mais_eles);
        buttonMenosNos = findViewById(R.id.button_menos_nos);
        buttonMenosEles = findViewById(R.id.button_menos_eles);

        buttonMaisNos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementScore(editTextNos);
            }
        });

        buttonMaisEles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementScore(editTextEles);
            }
        });

        buttonMenosNos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementScore(editTextNos);
            }
        });

        buttonMenosEles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementScore(editTextEles);
            }
        });
    }

    private void incrementScore(TextView textView) {
        int score = Integer.parseInt(textView.getText().toString());
        score++;
        textView.setText(String.valueOf(score));
        if(score == 13){
                    Toast.makeText(MainActivity.this, "Pontuação máxima atingida", Toast.LENGTH_SHORT).show();
                    editTextEles.setText("" + 0);
                    editTextNos.setText("" + 0);
        }
    }


    private void decrementScore(TextView textView) {
        int score = Integer.parseInt(textView.getText().toString());
        if (score > 0){
            score--;
            textView.setText(String.valueOf(score));
        }
        else{
            Toast.makeText(MainActivity.this, "Nenhuma pontuação registrada", Toast.LENGTH_SHORT).show();
        }
    }
}
