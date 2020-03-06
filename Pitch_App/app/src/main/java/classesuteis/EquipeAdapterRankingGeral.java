package classesuteis;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.teste.R;
import com.example.teste.*;

import java.util.ArrayList;

public class EquipeAdapterRankingGeral extends ArrayAdapter<Equipe> {
    private final Context context;
    private final ArrayList<Equipe> elementos;


    public EquipeAdapterRankingGeral(Context context, ArrayList<Equipe> elementos){
        super(context, R.layout.linha,elementos);
        this.context=context;
        this.elementos=elementos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View roview = inflater.inflate(R.layout.linha_ranking_geral, parent, false);
        TextView nomeEquipe =  (TextView) roview.findViewById(R.id.nome_equipe_id);
        TextView txtRanking = roview.findViewById(R.id.rankingLinha);

        txtRanking.setText("# "+(position+1)+"º");
        nomeEquipe.setText(elementos.get(position).getNome());


        return roview;

    }

}
