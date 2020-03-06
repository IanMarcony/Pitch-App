package com.example.teste;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import classesuteis.ComparadorEquipes;
import classesuteis.Equipe;
import classesuteis.Usuario;

public class TelaRankingMainActivity extends Activity {
    private Button botaoGeral;
    private ProgressBar pgEquipe1,pgEquipe2,pgEquipe3;
    public static ArrayList equipeArray;
    private Equipe equipe1,equipe2,equipe3;
    private TextView txtEquipe1, txtEquipe2, txtEquipe3,
            txtEquipe1p,txtEquipe2p,txtEquipe3p;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_ranking_main);

        Window window = this.getWindow();

        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.statusBar));
        window.setNavigationBarColor(ContextCompat.getColor(this,R.color.tranparente));

        botaoGeral = (Button)findViewById(R.id.botao_geral_id);

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
        Collections.sort(equipeArray, new ComparadorEquipes());

        if(equipeArray.contains( equipeArray.get(0))){
            equipe1 = (Equipe) equipeArray.get(0);
            txtEquipe1.setText(equipe1.getNome());
            pgEquipe1.setProgress(equipe1.getNumeroVoto());
            txtEquipe1p.setText(pgEquipe1.getProgress() + "%");
        }

        if(equipeArray.contains( equipeArray.get(1))){
            equipe2 = (Equipe) equipeArray.get(1);
            txtEquipe2.setText(equipe2.getNome());
            pgEquipe2.setProgress(equipe2.getNumeroVoto());
            txtEquipe2p.setText(pgEquipe2.getProgress() + "%");
        }

        if(equipeArray.contains( equipeArray.get(2))){
            equipe3 = (Equipe) equipeArray.get(2);
            txtEquipe3.setText(equipe3.getNome());
            pgEquipe3.setProgress(equipe3.getNumeroVoto());
            txtEquipe3p.setText(pgEquipe3.getProgress() + "%");
        }

        //Buttons action
        actions();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if(equipeArray.contains( equipeArray.get(0)))pgEquipe1.setProgress(equipe1.getNumeroVoto());
        if(equipeArray.contains( equipeArray.get(1)))pgEquipe2.setProgress(equipe2.getNumeroVoto());
        if(equipeArray.contains( equipeArray.get(2)))pgEquipe3.setProgress(equipe3.getNumeroVoto());
    }

    public void actions(){
        botaoGeral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(TelaRankingMainActivity.this,TelaRankingGeralActivity.class);
            startActivity(intent);
            }
        });
    }
}
