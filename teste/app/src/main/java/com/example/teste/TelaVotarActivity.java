package com.example.teste;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;

import androidx.core.content.ContextCompat;

import classesuteis.Usuario;

public class TelaVotarActivity extends Activity {

    private Button btDecrease,btIncrement,btSubmit;
    private SeekBar rateBar;
    private ImageView stars;

    private Float saldo, value;

    private Usuario user = MainActivity.user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_votar);
        getWindow().setNavigationBarColor(ContextCompat.getColor(this,R.color.tranparente));

        btDecrease = findViewById(R.id.botao_decrementar_id);
        btIncrement = findViewById(R.id.botao_acrescentar_id);
        btSubmit = findViewById(R.id.botao_submeter_voto_id);

        stars = findViewById(R.id.rate_equipe_ind_id);

        rateBar = findViewById(R.id.rate_voto_id);
        rateBar.setProgress(0);

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

        rateBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                switch (rateBar.getProgress()){
                    case 1:
                        stars.setImageResource(R.drawable.uma_estrela_votacao);
                        break;

                    case 2:
                        stars.setImageResource(R.drawable.duas_estrelas_votacao);
                        break;

                    case 3:
                        stars.setImageResource(R.drawable.tres_estrelas_votacao);
                        break;

                    case 4:
                        stars.setImageResource(R.drawable.quatro_estrelas_votacao);
                        break;

                    case 5:
                        stars.setImageResource(R.drawable.cinco_estrelas_votacao);
                        break;

                    default:
                        stars.setImageResource(R.drawable.zero_estrelas);
                        break;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
