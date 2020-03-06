package com.example.teste;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import classesuteis.Equipe;

public class TelaAdicionarEquipeActivity extends Activity {
    private TextView nomeProjeto, nomeLider;
    private Button btnSubmeter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_adicionar_equipe);
        getWindow().setNavigationBarColor(ContextCompat.getColor(this,R.color.tranparente));

        nomeProjeto = (TextView)findViewById(R.id.nome_projeto_id);
        nomeLider = (TextView)findViewById(R.id.nome_lider_id);
        btnSubmeter = (Button)findViewById(R.id.botao_submeter_equipe_id);

        btnSubmeter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Equipe equipe = new Equipe(nomeProjeto.getText().toString(),
                        nomeLider.getText().toString(),0,0,"",0,0);

                final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

                databaseReference.child("Equipes").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        long cont = dataSnapshot.getChildrenCount();

                        equipe.setIdEquipe(cont+1);
                        databaseReference.child("Equipes").child("Equipe"+(cont+1)).setValue(equipe);

                        Toast.makeText(getApplicationContext(),"Equipe Registrada",
                                Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(TelaAdicionarEquipeActivity.this,
                                TelaVotacaoListaActivity.class);

                        startActivity(intent);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {}
                });
            }
        });
    }
}
