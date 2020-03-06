package com.example.teste;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

import classesuteis.ComparadorEquipes;
import classesuteis.Equipe;
import classesuteis.EquipeAdapterRankingGeral;
import classesuteis.EquipeAdpter;

public class TelaRankingGeralActivity extends Activity {
    private ListView listaEquipes;
    public static ArrayList<Equipe> equipes;
    public static int positionEquipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_ranking_geral);
        getWindow().setNavigationBarColor(ContextCompat.getColor(this,R.color.tranparente));

        equipes=TelaRankingMainActivity.equipeArray;
        Collections.sort(equipes, new ComparadorEquipes());

        listaEquipes = (ListView)findViewById(R.id.lista_equipes_geral_id);

        ArrayAdapter<Equipe> adapter = new EquipeAdapterRankingGeral(getApplicationContext(),equipes);
        listaEquipes.setAdapter(adapter);
        positionEquipe = 0;

        listaEquipes.setLongClickable(true);
        listaEquipes.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(TelaRankingGeralActivity.this,TelaRankingVisaoGeralActivity.class);
            positionEquipe = position;
            startActivity(intent);
            return true;
            }
        });
    }
}
