package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText peso;
    EditText altura;
    Button botaoCalcular;
    TextView saida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        peso = findViewById(R.id.Peso);
        altura = findViewById(R.id.Altura);
        botaoCalcular = findViewById(R.id.BotaoCalcular);
        saida = findViewById(R.id.imc);
    }

    public float CalcularIMC(float peso, float altura){
        return peso/(altura*altura);
    }

    public void imc(View view) {
        float peso = Float.parseFloat(this.peso.getText().toString());
        float altura = Float.parseFloat(this.altura.getText().toString());
        float resultado = CalcularIMC(peso, altura);
        saida.setText(String.format("%.2f",resultado));
    }
}
