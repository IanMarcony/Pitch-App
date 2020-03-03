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

import java.util.Iterator;

import classesuteis.Usuario;


public class MainActivity extends Activity {
    private TextView raField;
    private Button botaoLogin;
    public static Usuario user;
    private int qEquipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setNavigationBarColor(ContextCompat.getColor(this,R.color.tranparente));

        raField=(TextView)findViewById(R.id.ra_aluno_id);
        botaoLogin=(Button)findViewById(R.id.botao_login_id);
        qEquipes=0;
        DatabaseReference equipesReference = FirebaseDatabase.getInstance().getReference("Equipes");
        equipesReference.child("Equipes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Iterator<DataSnapshot> it=dataSnapshot.getChildren().iterator();

                while(it.hasNext()){
                    qEquipes++;
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        System.out.println("Quantidade de equipes: "+qEquipes);
        botaoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user = new Usuario();
                user.setRa(raField.getText().toString());
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();//Aponta pro Banco de dados
                final DatabaseReference usuariosReference = databaseReference.child("Alunos");

                usuariosReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        boolean hasFound = false;

                        for(int i=1;i<38;i++)
                            if(dataSnapshot.child("Aluno"+i).child("RA").getValue().toString().equals(user.getRa())){

                                String ra_t=dataSnapshot.child("Aluno"+i).child("RA").getValue().toString();
                                float saldo_t=Float.parseFloat(dataSnapshot.child("Aluno"+i).child("Saldo").getValue().toString());
                              user.setPosicao(i);
                                user.setSaldo(saldo_t);
                                user.setLogado(true);
                                hasFound = true;
                                if(user.isLogado()) {
                                    Toast.makeText(getApplicationContext(), "Acesso liberado", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(MainActivity.this, TelaVotacaoListaActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                                break;
                            }

                            if (!hasFound){
                                Toast.makeText(getApplicationContext(),"Acesso negado!\nVerifique se o RA foi escrito corretamente",Toast.LENGTH_SHORT).show();
                            }
                        }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });

    }
}
