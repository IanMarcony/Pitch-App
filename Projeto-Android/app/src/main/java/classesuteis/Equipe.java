package classesuteis;
import android.app.Activity;

import com.fmm.ai3.votacao3ai.R;

public class Equipe {
    private String nome;
    private float media;
    private float valorInvestido;
    private int numeroVoto;
    private int imagemRate,imagemCheck;

    public Equipe(String nome, float media, int numeroVoto) {
        this.nome = nome;
        this.media = media;
        this.numeroVoto = numeroVoto;
    }
    public Equipe(String nome, float media) {
        this.nome = nome;
        this.media = media;

    }
    public Equipe(String nome) {
        this.nome = nome;


    }
    public Equipe() {
        this.nome = "";
        this.media = 0;
        this.numeroVoto = 0;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }

    public int getNumeroVoto() {
        return numeroVoto;
    }

    public void setNumeroVoto(int numeroVoto) {
        this.numeroVoto = numeroVoto;
    }

    public int getImagemRate() {
        return imagemRate;
    }

    public void setImagemRate(int imagemRate) {
       switch (imagemRate){
           case 0: this.imagemRate= R.drawable.zero_estrelas;
           break;
           case 1: this.imagemRate= R.drawable.uma_estrelas;
               break;
           case 2: this.imagemRate= R.drawable.duas_estrelas;
               break;
           case 3: this.imagemRate= R.drawable.tres_estrelas;
               break;
           case 4: this.imagemRate= R.drawable.quatro_estrelas;
               break;
           case 5: this.imagemRate= R.drawable.cinco_estrelas;
               break;
               default:this.imagemRate= R.drawable.zero_estrelas;
                   break;

       }

    }

    public int getImagemCheck() {
        return imagemCheck;
    }

    public void setImagemCheck(int imagemCheck) {
        switch (imagemCheck){
            case 0: this.imagemCheck= R.drawable.nao_votado;
                break;
            case 1: this.imagemCheck= R.drawable.sim_votado;
                break;
            default:this.imagemCheck= R.drawable.nao_votado;
                break;

        }
    }

    public float getValorInvestido() {
        return valorInvestido;
    }

    public void setValorInvestido(float valorInvestido) {
        this.valorInvestido = valorInvestido;
    }
}
