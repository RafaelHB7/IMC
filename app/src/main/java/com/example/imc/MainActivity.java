package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText peso;
    EditText altura;
    TextView saida;
    ImageView imagem;
    SeekBar barra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        peso = findViewById(R.id.Peso);
        altura = findViewById(R.id.Altura);
        saida = findViewById(R.id.imc);
        imagem = findViewById(R.id.imagem);
        barra = findViewById(R.id.seekBar);
    }

    public float CalcularIMC(float peso, float altura){
        return peso/(altura*altura);
    }

    public void imc(View view) {
        float peso = Float.parseFloat(this.peso.getText().toString());
        float altura = Float.parseFloat(this.altura.getText().toString());
        float resultado = CalcularIMC(peso, altura);

        saida.setText(String.format("%.2f", resultado));
        barra.setProgress((int) (resultado));

        if (resultado < 18.5) {
            imagem.setImageResource(R.drawable.abaixopeso);
        } else if (resultado < 25) {
            imagem.setImageResource(R.drawable.normal);
        } else if (resultado < 30) {
            imagem.setImageResource(R.drawable.sobrepeso);
        } else if (resultado < 35) {
            imagem.setImageResource(R.drawable.obesidade1);
        } else if (resultado < 40) {
            imagem.setImageResource(R.drawable.obesidade2);
        } else {
            imagem.setImageResource(R.drawable.obesidade3);
        }
    }
}
