package com.example.teste;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.core.content.ContextCompat;

public class TelaRankingMainActivity extends Activity {

    private Button botaoGeral;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_ranking_main);
        getWindow().setNavigationBarColor(ContextCompat.getColor(this,R.color.tranparente));

        botaoGeral=(Button)findViewById(R.id.botao_geral_id);

        botaoGeral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(TelaRankingMainActivity.this,TelaRankingGeralActivity.class);
                startActivity(intent);
            }
        });
    }

}
