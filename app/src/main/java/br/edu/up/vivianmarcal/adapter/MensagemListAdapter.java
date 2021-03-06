package br.edu.up.vivianmarcal.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projeto_ds2.R;
import br.edu.up.vivianmarcal.model.mensagem.Mensagem;
import br.edu.up.vivianmarcal.model.mensagem.OrigemEnum;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MensagemListAdapter extends RecyclerView.Adapter<MensagemListAdapter.MensagemViewHolder> {

    private ArrayList<Mensagem> mensagens;

    public MensagemListAdapter(ArrayList<Mensagem> mensagens) {
        this.mensagens = mensagens;
    }

    @NonNull
    @Override
    public MensagemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View layout;
        if (viewType == OrigemEnum.Remetente.getId()) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            layout = layoutInflater.inflate(R.layout.view_mensagem_remetente, parent, false);
        } else {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            layout = layoutInflater.inflate(R.layout.view_mensagem_destinatario, parent, false);
        }

        return new MensagemViewHolder(layout);
    }

    @Override
    public int getItemViewType(int position) {
        return mensagens.get(position).getOrigem().getId();
    }

    @Override
    public void onBindViewHolder(@NonNull MensagemViewHolder holder, int position) {
        Mensagem mensagem = mensagens.get(position);

        TextView texto = holder.itemView.findViewById(R.id.text_mensagem);

        texto.setText(mensagem.getTexto());

        TextView hora = holder.itemView.findViewById(R.id.time_msg);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM HH:mm");
        hora.setText( sdf.format(mensagem.getData().toDate().getTime()));
    }

    @Override
    public int getItemCount() {
        return mensagens.size();
    }

    public class MensagemViewHolder extends RecyclerView.ViewHolder{

        public MensagemViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
