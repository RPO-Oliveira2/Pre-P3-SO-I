package com.example.prep3prova;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etEntrada;
    private Button buttonInicia;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etEntrada = findViewById(R.id.etEntrada);
        buttonInicia = findViewById(R.id.buttonInicia);
        tvResult = findViewById(R.id.tvResult);
        buttonInicia.setOnClickListener(op -> calc());

    }
    private void calc(){
        float input = Float.parseFloat(etEntrada.getText().toString());
        float result=0;

        if(input >0 && input<20){
            for(float i = 1; i<=input; i++) {
                result = result + 1 / i;
            }
            String res = getString(R.string.result)+ result;
            tvResult.setText(res);
        }else {
                input = Float.parseFloat(etEntrada.getText().toString());
                tvResult.setText(R.string.erro);
            }

        }
    }
