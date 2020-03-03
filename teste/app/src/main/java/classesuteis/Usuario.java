package classesuteis;

import java.util.List;

public class Usuario {
    private String ra;
    private int posicao;
    private float saldo;
    private List<Integer> votos;
    private boolean logado;

    public Usuario() {
    }

    public Usuario(String ra, float saldo, List<Integer> votos) {
        this.ra = ra;
        this.saldo = saldo;
        this.votos = votos;
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

    public List<Integer> getVotos() {
        return votos;
    }

    public void setVotos(int voto,int index) {
        this.votos.set(index,voto);
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public boolean isLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }



}
