package com.example.teste;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import classesuteis.Equipe;
import classesuteis.EquipeAdpter;
import classesuteis.Usuario;

public class TelaVotacaoListaActivity extends Activity {
    private ListView listaEquipes;
    public  static ArrayList<Equipe> equipes;
    public  static int positionEquipe;
    public static Usuario user_aux=MainActivity.user;
    private Button botaoAdicionar,botaoRanking,botaoLogout;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_votacao_lista);

        Window window = this.getWindow();

        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.statusBar));
        window.setNavigationBarColor(ContextCompat.getColor(this,R.color.tranparente));

        listaEquipes = findViewById(R.id.lista_equipes_geral_id);
        positionEquipe=0;

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        DatabaseReference equipesReference=databaseReference.child("Equipes");

        equipesReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int i = 0;

                equipes = new ArrayList<Equipe>();
                for(DataSnapshot dados: dataSnapshot.getChildren()){
                    Equipe equipe = dados.getValue(Equipe.class);
                    equipe.setIdEquipe(i + 1);
                    equipes.add(equipe);
                    i++;
                }

                user_aux.setEquipesArray(equipes);
                ArrayAdapter<Equipe> adapter = new EquipeAdpter(getApplicationContext(),equipes);
                listaEquipes.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Failed to read value."+
                        error.toException(),Toast.LENGTH_LONG).show();
            }
        });

        listaEquipes.setLongClickable(true);
        listaEquipes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(TelaVotacaoListaActivity.this,TelaVotarActivity.class);
            positionEquipe = position;
            startActivity(intent);
            }
        });

        //Validate user type (professor or student)
        botaoAdicionar = (Button)findViewById(R.id.botao_add_equipe_id);
        if(MainActivity.user.getRa().equals("admin")) botaoAdicionar.setEnabled(true);
        else botaoAdicionar.setEnabled(false);

        botaoRanking = (Button)findViewById(R.id.botao_ranking_id);
        botaoLogout = (Button)findViewById(R.id.botao_logout_id);

        botaoAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(TelaVotacaoListaActivity.this,
                    TelaAdicionarEquipeActivity.class);
            startActivity(intent);
            }
        });

        botaoRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(TelaVotacaoListaActivity.this,
                    TelaRankingMainActivity.class);
            startActivity(intent);
            }
        });

        botaoLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(TelaVotacaoListaActivity.this,
                    MainActivity.class);
            startActivity(intent);
            finish();
            }
        });
    }
}
