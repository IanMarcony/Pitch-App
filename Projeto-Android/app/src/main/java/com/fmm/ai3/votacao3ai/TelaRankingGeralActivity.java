package com.fmm.ai3.votacao3ai;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import classesuteis.Equipe;
import classesuteis.EquipeAdpter;

public class TelaRankingGeralActivity extends Activity {
    private ListView listaEquipes;
    public static ArrayList<Equipe> equipes;
    public static int positionEquipe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_ranking_geral);
        listaEquipes =(ListView)findViewById(R.id.lista_equipes_geral_id);
        equipes = retornarEquipes();
        ArrayAdapter<Equipe> adapter = new EquipeAdpter(getApplicationContext(),equipes);
        listaEquipes.setAdapter(adapter);
        positionEquipe=0;


        listaEquipes.setLongClickable(true);
        listaEquipes.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TelaRankingGeralActivity.this,TelaVotarActivity.class);
                positionEquipe=position;
                startActivity(intent);
                return true;
            }
        });
    }

    public ArrayList<Equipe> retornarEquipes(){
        ArrayList<Equipe> elementos= new ArrayList<>();
    /*
        RECUPERAR EQUIPES DO FIREBASE - TODO CODE
     */
        return elementos;
    }
}
