package classesuteis;

import android.widget.TextView;
import android.app.Activity;

import com.fmm.ai3.votacao3ai.MainActivity;
import com.fmm.ai3.votacao3ai.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Usuario {
    private String ra;
    private float saldo;
    private int voto;
    private boolean logado;

    public Usuario() {
    }

    public Usuario(String ra, float saldo, int voto) {
        this.ra = ra;
        this.saldo = saldo;
        this.voto = voto;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    public boolean isLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }



}
