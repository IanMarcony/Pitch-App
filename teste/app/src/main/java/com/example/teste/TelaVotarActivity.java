package com.example.teste;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import classesuteis.Equipe;
import classesuteis.Usuario;

public class TelaVotarActivity extends Activity {

    private Button btDecrease,btIncrement,btSubmit;
    private SeekBar rateBar;
    private ImageView stars;
    private TextView teamName;
    private TextView etValue;

    private float saldo, value;
    private int idEquipe,rate;
    private ArrayList equipeArray;

    private Equipe equipe;
    private Usuario user = MainActivity.user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_votar);
        getWindow().setNavigationBarColor(ContextCompat.getColor(this,R.color.tranparente));

        btDecrease = findViewById(R.id.botao_decrementar_id);
        btIncrement = findViewById(R.id.botao_acrescentar_id);
        btSubmit = findViewById(R.id.botao_submeter_voto_id);
        etValue=findViewById(R.id.valor_investir_id);
        etValue.setText(""+user.getSaldo());
        teamName = findViewById(R.id.textView);

        stars = findViewById(R.id.rate_equipe_ind_id);

        rateBar = findViewById(R.id.rate_voto_id);
        rateBar.setProgress(0);

        saldo = user.getSaldo();
        value = saldo;

        etValue.setText(""+value);



        equipeArray = TelaVotacaoListaActivity.equipes;
        idEquipe =TelaVotacaoListaActivity.positionEquipe;

        equipe = (Equipe) equipeArray.get(idEquipe);
        teamName.setText(equipe.getNome());

        actions();
    }

    public void actions(){
//        etValue.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
//
//            @Override
//            @SuppressLint("SetTextI18n")
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                value = Float.parseFloat(etValue.getText().toString());
//                etValue.setText(""+value);
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {}
//        });

        btDecrease.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(!(value<=0)){
                    value -= 1000;
                    etValue.setText(""+value);
                }
            }
        });

        btIncrement.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(!(value>=saldo)){
                    value += 1000;
                    etValue.setText(""+value);
                }
            }
        });

        rateBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                rate = rateBar.getProgress();

                switch (rateBar.getProgress()){
                    case 1:
                        stars.setImageResource(R.drawable.uma_estrela_votacao);
                        break;

                    case 2:
                        stars.setImageResource(R.drawable.duas_estrelas_votacao);
                        break;

                    case 3:
                        stars.setImageResource(R.drawable.tres_estrelas_votacao);
                        break;

                    case 4:
                        stars.setImageResource(R.drawable.quatro_estrelas_votacao);
                        break;

                    case 5:
                        stars.setImageResource(R.drawable.cinco_estrelas_votacao);
                        break;

                    default:
                        stars.setImageResource(R.drawable.zero_estrelas);
                        break;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setar doacao
                equipe.giveDonation(user.getRa(),value);
                user.setSaldo(saldo-value);

                //setar rate
                equipe.setImagemRate(rate);

                //confirmar voto
                equipe.setImagemCheck(1);
//                user.setVotos(rate,idEquipe);

                //firebase
                try{
                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
                    databaseReference.child("Equipes").child("Equipe"+idEquipe).setValue(equipe);
                        DatabaseReference usuarioReference = FirebaseDatabase.getInstance().getReference("Alunos");
                        usuarioReference.child("Aluno"+MainActivity.user.getPosicao()).setValue(user);
                    Intent intent = new Intent(TelaVotarActivity.this,TelaVotacaoListaActivity.class);
                    startActivity(intent);
                }catch (Exception err){
                    Toast.makeText(getApplicationContext(),err.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
