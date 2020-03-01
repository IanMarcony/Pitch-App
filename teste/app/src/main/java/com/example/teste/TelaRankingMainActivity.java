package com.example.teste;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaRankingMainActivity extends Activity {

    private Button botaoGeral;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_ranking_main);
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
