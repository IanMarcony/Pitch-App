package com.example.teste;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.core.content.ContextCompat;

import classesuteis.Usuario;

public class TelaVotarActivity extends Activity {

    private Button btDecrease,btIncrement;

    private Float saldo, value;

    private Usuario user = MainActivity.user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_votar);
        getWindow().setNavigationBarColor(ContextCompat.getColor(this,R.color.tranparente));

        btDecrease = findViewById(R.id.botao_decrementar_id);
        btIncrement = findViewById(R.id.botao_acrescentar_id);

        saldo = user.getSaldo();
        value = saldo;

        actions();
    }

    public void actions(){
        btDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(value<=0)){
                    value -= 100f;
                }
            }
        });

        btIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(value>=saldo)){
                    value += 100f;
                }
            }
        });
    }
}
