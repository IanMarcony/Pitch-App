package classesuteis;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fmm.ai3.votacao3ai.R;

import java.util.ArrayList;

public class EquipeAdpter extends ArrayAdapter<Equipe> {
    private final Context context;
    private final ArrayList<Equipe> elementos;

    public EquipeAdpter(Context context, ArrayList<Equipe> elementos){
        super(context, R.layout.linha,elementos);
        this.context=context;
        this.elementos=elementos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater  inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View roview = inflater.inflate(R.layout.linha, parent, false);
        TextView nomeEquipe = (TextView) roview.findViewById(R.id.nome_equipe_id);
        ImageView votado_check = (ImageView) roview.findViewById(R.id.votado_check_id);
        ImageView rate = (ImageView)roview.findViewById(R.id.rate_equipe_id);
        TextView investimento = (TextView)roview.findViewById(R.id.valor_investido_equipe_id);

        nomeEquipe.setText(elementos.get(position).getNome());
        votado_check.setImageResource(elementos.get(position).getImagemCheck());
        rate.setImageResource(elementos.get(position).getImagemRate());
        investimento.setText("R$ "+elementos.get(position).getValorInvestido());

        return roview;

    }



}
