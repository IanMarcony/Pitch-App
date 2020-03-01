package com.fmm.ai3.votacao3ai;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


import classesuteis.Equipe;
import classesuteis.EquipeAdpter;

public class TelaVotacaoListaActivity extends Activity {
    private ListView listaEquipes;
    public static ArrayList<Equipe> equipes;
    public static int positionEquipe;

    private Button botaoAdicionar,botaoRanking,botaoLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_votacao_lista);
        listaEquipes =(ListView)findViewById(R.id.lista_equipes_geral_id);
        equipes = retornarEquipes();
        ArrayAdapter<Equipe> adapter = new EquipeAdpter(getApplicationContext(),equipes);
        listaEquipes.setAdapter(adapter);
        positionEquipe=0;

        botaoAdicionar=(Button)findViewById(R.id.botao_add_equipe_id);//colocar condição para verificar se é aluno ou professor
        if(true)botaoAdicionar.setEnabled(true);
        else botaoAdicionar.setEnabled(false);
        botaoRanking=(Button)findViewById(R.id.botao_ranking_id);//idem de cima
        if(true)botaoRanking.setEnabled(true);
            else botaoRanking.setEnabled(false);
        botaoLogout= (Button)findViewById(R.id.botao_logout_id);

        //Funções de click dos botões

        botaoAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(TelaVotacaoListaActivity.this,TelaAdicionarEquipeActivity.class);
                startActivity(intent);
            }
        });

        botaoRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(TelaVotacaoListaActivity.this,TelaRankingMainActivity.class);
                startActivity(intent);
            }
        });

        botaoLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                    CRIAR CODE FIREBASE PARA FAZER LOGOUT DA CONTA LOGADA
                 */
                Intent intent= new Intent(TelaVotacaoListaActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        listaEquipes.setLongClickable(true);
        listaEquipes.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TelaVotacaoListaActivity.this,TelaVotarActivity.class);
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
