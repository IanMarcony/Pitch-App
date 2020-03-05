package classesuteis;

import com.example.teste.R;

public class Equipe {
    private String nome, nomeLider;
    private long idEquipe;
    private float media;
    private int positionRanking;
    private String raInvestidor;
    private float maiorInvestimento;
    private float valorInvestido;
    private int numeroVoto;
    private int imagemRate,imagemCheck;

    public Equipe(String nome, String nomeLider, float media, int positionRanking, String raInvestidor, float valorInvestido, int numeroVoto) {
        this.nome = nome;
        this.nomeLider = nomeLider;
        this.media = media;
        this.positionRanking = positionRanking;
        this.raInvestidor = raInvestidor;
        this.valorInvestido = valorInvestido;
        this.numeroVoto = numeroVoto;
    }

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

    public long getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(long idEquipe) {
        this.idEquipe = idEquipe;
    }

    public String getNomeLider() {
        return nomeLider;
    }

    public void setNomeLider(String nomeLider) {
        this.nomeLider = nomeLider;
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

    public void giveDonation(String raInvestidor, float donation){
        float maiorDonation = getMaiorInvestimento();

        if(donation>maiorDonation){
            setRaInvestidor(raInvestidor);
            setMaiorInvestimento(donation);
        }

        setValorInvestido(getValorInvestido()+donation);
    }

    public int getPositionRanking() {
        return positionRanking;
    }

    public void setPositionRanking(int positionRanking) {
        this.positionRanking = positionRanking;
    }

    public String getRaInvestidor() {
        return raInvestidor;
    }

    public void setRaInvestidor(String raInvestidor) {
        this.raInvestidor = raInvestidor;
    }

    public float getMaiorInvestimento() {
        return maiorInvestimento;
    }

    public void setMaiorInvestimento(float maiorInvestimento) {
        this.maiorInvestimento = maiorInvestimento;
    }
}
