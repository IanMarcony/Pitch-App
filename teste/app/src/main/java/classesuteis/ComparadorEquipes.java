package classesuteis;

import java.util.Comparator;

public class ComparadorEquipes implements Comparator<Equipe> {
    public  int compare(Equipe e1, Equipe e2){
        if(e1.getValorInvestido()<e2.getValorInvestido())return -1;
        else if(e1.getValorInvestido()>e2.getValorInvestido())return 1;
        else return 0;
    }

}