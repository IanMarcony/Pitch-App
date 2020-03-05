package com.example.teste;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import classesuteis.ComparadorEquipes;
import classesuteis.Equipe;

public class TelaRankingMainActivity extends Activity {

    private ProgressBar pgEquipe1,pgEquipe2,pgEquipe3;

    private Button botaoGeral;

    private TextView txtEquipe1, txtEquipe2, txtEquipe3,
            txtEquipe1p,txtEquipe2p,txtEquipe3p;

    private int idEquipe1,idEquipe2,idEquipe3;
    private ArrayList equipeArray;
    private Equipe equipe1,equipe2,equipe3;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_ranking_main);
        getWindow().setNavigationBarColor(ContextCompat.getColor(this,R.color.tranparente));

        botaoGeral=(Button)findViewById(R.id.botao_geral_id);

        txtEquipe1 = findViewById(R.id.textView7);
        txtEquipe1.setShadowLayer(2, 1, 1, Color.BLACK);
        txtEquipe1p = findViewById(R.id.textView8);
        txtEquipe1p.setShadowLayer(2, 1, 1, Color.BLACK);
        txtEquipe2 = findViewById(R.id.textView5);
        txtEquipe2.setShadowLayer(2, 1, 1, Color.BLACK);
        txtEquipe2p = findViewById(R.id.textView6);
        txtEquipe2p.setShadowLayer(2, 1, 1, Color.BLACK);
        txtEquipe3 = findViewById(R.id.textView9);
        txtEquipe3.setShadowLayer(2, 1, 1, Color.BLACK);
        txtEquipe3p = findViewById(R.id.textView10);
        txtEquipe3p.setShadowLayer(2, 1, 1, Color.BLACK);

        pgEquipe1 = findViewById(R.id.equipe1_progressbar_id2);
        pgEquipe2 = findViewById(R.id.equipe2_progressbar_id);
        pgEquipe3 = findViewById(R.id.equipe3_progressbar_id3);


        equipeArray = TelaVotacaoListaActivity.equipes;
        if(equipeArray.size()>=3) {
            Collections.sort(equipeArray, new ComparadorEquipes());
            if(equipeArray.size()>=1)equipe1 = (Equipe) equipeArray.get(0);
            if(equipeArray.size()>=2)equipe2 = (Equipe) equipeArray.get(1);
            if(equipeArray.size()>=3)equipe3 = (Equipe) equipeArray.get(2);


            if(equipeArray.size()>=1)txtEquipe1.setText(equipe1.getNome());
            if(equipeArray.size()>=2)txtEquipe2.setText(equipe2.getNome());
            if(equipeArray.size()>=3)txtEquipe3.setText(equipe3.getNome());

            if(equipeArray.size()>=1)txtEquipe1p.setText(pgEquipe1.getProgress() + "%");
            if(equipeArray.size()>=2)txtEquipe2p.setText(pgEquipe2.getProgress() + "%");
            if(equipeArray.size()>=3)txtEquipe3p.setText(pgEquipe3.getProgress() + "%");


        }

    }

    @Override
    protected void onResume() {
        super.onResume();



        if(equipeArray.size()>=1)txtEquipe1p.setText(pgEquipe1.getProgress()+"%");
        if(equipeArray.size()>=2)txtEquipe2p.setText(pgEquipe2.getProgress()+"%");
        if(equipeArray.size()>=3)txtEquipe3p.setText(pgEquipe3.getProgress()+"%");

    }

    public void actions(){
        botaoGeral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(TelaRankingMainActivity.this,TelaRankingGeralActivity.class);
                startActivity(intent);
            }
        });
    }

}
