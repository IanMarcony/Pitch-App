package com.example.teste;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
import java.util.Iterator;

import classesuteis.Equipe;
import classesuteis.EquipeAdpter;

public class TelaVotacaoListaActivity extends Activity {
    private ListView listaEquipes;
    public  ArrayList<Equipe> equipes;
    public  int positionEquipe;

    private Button botaoAdicionar,botaoRanking,botaoLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_votacao_lista);
        getWindow().setNavigationBarColor(ContextCompat.getColor(this,R.color.tranparente));

        listaEquipes = findViewById(R.id.lista_equipes_geral_id);

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        DatabaseReference equipesReference=databaseReference.child("Equipes");

        equipesReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                System.out.println("Entrou na função para pegar do banco");

                int i=0;
                equipes = new ArrayList<Equipe>();
                for(DataSnapshot dados: dataSnapshot.getChildren()){
                    Equipe equipe = dados.getValue(Equipe.class);
                    System.out.println(dados.getValue());
                    equipes.add(equipe);
                    System.out.println(equipes);


                    i++;
                }

                ArrayAdapter<Equipe> adapter = new EquipeAdpter(getApplicationContext(),equipes);
                listaEquipes.setAdapter(adapter);

                System.out.println("Finalizou oesquisa no bacpesqui");
                DatabaseReference databaseReference_aux = FirebaseDatabase.getInstance().getReference();
                DatabaseReference usuariosReference = databaseReference_aux.child("Alunos");

                for(int j =1;j<=i;j++) {
                    usuariosReference.child("Aluno" + MainActivity.user.getPosicao()).child("Votos").child("Voto" + j).setValue(0);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Failed to read value."+ error.toException(),Toast.LENGTH_LONG).show();
            }
        });

        listaEquipes.setLongClickable(true);
        listaEquipes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TelaVotacaoListaActivity.this,TelaVotarActivity.class);

                intent.putExtra("Equipes",equipes);
                intent.putExtra("Posicao",position);
                startActivity(intent);
            }
        });

//        listaEquipes.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(TelaVotacaoListaActivity.this,TelaVotarActivity.class);
//
//                intent.putExtra("Equipes",equipes);
//                intent.putExtra("Posicao",position);
//                startActivity(intent);
//                return true;
//            }
//        });

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
                intent.putExtra("Equipes",equipes);
                startActivity(intent);
            }
        });

        botaoLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(TelaVotacaoListaActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });







    }



}
