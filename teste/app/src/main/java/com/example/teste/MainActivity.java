package com.example.teste;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import classesuteis.Usuario;


public class MainActivity extends Activity {
    private TextView raField;
    private Button botaoLogin;
    public static Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        raField=(TextView)findViewById(R.id.ra_aluno_id);
        botaoLogin=(Button)findViewById(R.id.botao_login_id);

        botaoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user = new Usuario();
                user.setRa(raField.getText().toString());
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();//Aponta pro Banco de dados
                DatabaseReference usuariosReference = databaseReference.child("Alunos");

                usuariosReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        int i=1;
                        boolean achou=false;



                        while(achou!=true){
                            if(dataSnapshot.child("Aluno"+i).child("RA").getValue().toString().equals(user.getRa())){

                                String ra_t=dataSnapshot.child("Aluno"+i).child("RA").getValue().toString();
                                float saldo_t=Float.parseFloat(dataSnapshot.child("Aluno"+i).child("Saldo").getValue().toString());
                                int voto_t=Integer.parseInt(dataSnapshot.child("Aluno"+i).child("Voto").getValue().toString());

                                user.setSaldo(saldo_t);
                                user.setVoto(voto_t);
                                user.setLogado(true);
                                achou=true;
                            }

                            i++;
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                if(user.isLogado()) {
                    Intent intent = new Intent(MainActivity.this, TelaVotacaoListaActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }
}
