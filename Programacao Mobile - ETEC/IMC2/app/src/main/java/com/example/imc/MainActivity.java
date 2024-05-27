package com.example.imc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.imc.R;

public class MainActivity extends AppCompatActivity {

    EditText editTextPeso, editTextAlt;
    RadioGroup radioGroupSex;
    Button buttonCalculate;
    TextView textViewResult;
    RadioButton masculino, feminino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPeso = findViewById(R.id.editTextPeso);
        editTextAlt = findViewById(R.id.editTextAlt);
        radioGroupSex = findViewById(R.id.radioGroupSex);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textViewResult = findViewById(R.id.textViewResult);
        masculino = findViewById(R.id.btnMasc);
        feminino = findViewById(R.id.btnFem);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularIMC();
            }
        });
    }

    private void calcularIMC() {
        String pesoStr = editTextPeso.getText().toString();
        String altStr = editTextAlt.getText().toString();
        float peso = Float.parseFloat(pesoStr);
        float altura = Float.parseFloat(altStr);
        float imc = peso / (altura * altura);

        if (pesoStr.isEmpty() && altStr.isEmpty()) {
            textViewResult.setText("Por favor, insira peso e/ou altura");
            return;
        }
        if (masculino.isChecked()) {
            if (imc <= 18) {
                RadioButton selectedSexButton = findViewById(radioGroupSex.getCheckedRadioButtonId());
                String sexo = selectedSexButton.getText().toString();

                String resultado = String.format("Você está muito magro");
                textViewResult.setText(resultado);
            } else if (imc >= 21 && imc <= 25) {
                RadioButton selectedSexButton = findViewById(radioGroupSex.getCheckedRadioButtonId());
                String sexo = selectedSexButton.getText().toString();

                String resultado = String.format("Você está no peso ideal");
                textViewResult.setText(resultado);
            } else  {
                RadioButton selectedSexButton = findViewById(radioGroupSex.getCheckedRadioButtonId());
                String sexo = selectedSexButton.getText().toString();

                String resultado = String.format("Você está gordo");
                textViewResult.setText(resultado);
            }
        } else if (feminino.isChecked()) {
            if (imc <= 17) {
                RadioButton selectedSexButton = findViewById(radioGroupSex.getCheckedRadioButtonId());
                String sexo = selectedSexButton.getText().toString();

                String resultado = String.format("Você está muito magro");
                textViewResult.setText(resultado);
            } else if (imc >= 18 && imc <= 24) {
                RadioButton selectedSexButton = findViewById(radioGroupSex.getCheckedRadioButtonId());
                String sexo = selectedSexButton.getText().toString();

                String resultado = String.format("Você está no peso ideal");
                textViewResult.setText(resultado);
            } else {
                RadioButton selectedSexButton = findViewById(radioGroupSex.getCheckedRadioButtonId());
                String sexo = selectedSexButton.getText().toString();

                String resultado = String.format("Você está gordo");
                textViewResult.setText(resultado);
            }
        }
    }
}