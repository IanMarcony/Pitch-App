package classesuteis;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String RA;
    private int Posicao;
    private float Saldo;

    private List<Equipe> Equipes;
    private boolean Logado;

    public Usuario() {

        this.Equipes= new ArrayList<>();
    }

    public Usuario(String ra, float saldo) {
        this.RA = ra;
        this.Saldo = saldo;

        this.Equipes= new ArrayList<>();
    }

    public String getRa() {
        return RA;
    }

    public void setRa(String ra) {
        this.RA = ra;
    }

    public Equipe getEquipes(int index) {
        return Equipes.get(index);
    }

    public List<Equipe> setEquipesArray(List<Equipe> e){return this.Equipes=e;}

    public List<Equipe> getEquipesArray() {
        return Equipes;
    }



    public float getSaldo() {
        return Saldo;
    }

    public void setSaldo(float saldo) {
        this.Saldo = saldo;
    }



    public int getPosicao() {
        return Posicao;
    }

    public void setPosicao(int posicao) {
        this.Posicao = posicao;
    }

    public boolean isLogado() {
        return Logado;
    }

    public void setLogado(boolean logado) {
        this.Logado = logado;
    }



}
