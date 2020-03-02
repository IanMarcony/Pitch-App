package com.example.teste;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import classesuteis.Equipe;

public class TelaAdicionarEquipeActivity extends Activity {
    private TextView nomeProjeto, nomeLider;
    private Button btnSubmeter;
    private int qEquipes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_adicionar_equipe);

        nomeProjeto=(TextView)findViewById(R.id.nome_projeto_id);
        nomeLider=(TextView)findViewById(R.id.nome_lider_id);
        btnSubmeter=(Button)findViewById(R.id.botao_submeter_equipe_id);

        btnSubmeter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Equipe equipe = new Equipe(nomeProjeto.getText().toString(),nomeLider.getText().toString(),0,0,"",0,0);

                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
                databaseReference.child("Equipes").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        qEquipes= (int)dataSnapshot.getChildrenCount();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                System.out.println("Quantidade de Equipes: "+qEquipes);
                qEquipes++;
                databaseReference.child("Equipes").child("Equipe"+qEquipes).setValue(equipe);
                Toast.makeText(getApplicationContext(),"Equipe Registrada",Toast.LENGTH_LONG).show();

            }
        });


    }
}
