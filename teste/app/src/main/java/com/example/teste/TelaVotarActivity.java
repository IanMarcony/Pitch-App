package com.example.teste;

import android.app.Activity;
import android.os.Bundle;

import androidx.core.content.ContextCompat;

public class TelaVotarActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_votar);
        getWindow().setNavigationBarColor(ContextCompat.getColor(this,R.color.tranparente));
    }
}
