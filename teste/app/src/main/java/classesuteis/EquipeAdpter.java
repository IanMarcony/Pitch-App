package classesuteis;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.teste.MainActivity;
import com.example.teste.R;
import com.example.teste.TelaVotacaoListaActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class EquipeAdpter extends ArrayAdapter<Equipe> {
    private final Context context;
    private final ArrayList<Equipe> elementos;
    private final Usuario  user = MainActivity.user;

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
        TableLayout linha = roview.findViewById(R.id.tabela_elementos_id);
        TextView investimento = (TextView)roview.findViewById(R.id.valor_investido_equipe_id);

            nomeEquipe.setText(elementos.get(position).getNome());
            votado_check.setImageResource(user.getEquipes(position).getImagemCheck());
            rate.setImageResource(user.getEquipes(position).getImagemRate());
            linha.setBackgroundResource(user.getEquipes(position).getRgbBackgroundRow());
            investimento.setText("R$ " + elementos.get(position).getValorInvestido());

        return roview;

    }



}
