package com.example.teste;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class TelaRankingVisaoGeralActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_ranking_visao_geral);
        getWindow().setNavigationBarColor(ContextCompat.getColor(this,R.color.tranparente));
    }
}
