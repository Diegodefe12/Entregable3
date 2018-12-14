package app.diego.com.entregable3.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import app.diego.com.entregable3.Model.POJO.Obra;
import app.diego.com.entregable3.Model.POJO.ObrasContainer;
import app.diego.com.entregable3.R;

public class ObrasAdapter extends RecyclerView.Adapter {

    private List<Obra> listaDeObras;

    public ObrasAdapter() {
        listaDeObras = new ArrayList<>();
    }

    public void setListaDeObras(List<Obra> listaDeObras) {
        this.listaDeObras = listaDeObras;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflador = LayoutInflater.from(parent.getContext());
        View viewCelda = inflador.inflate(R.layout.celda_obra, parent, false);
        ObrasViewHolder obrasViewHolder = new ObrasViewHolder(viewCelda);


        return obrasViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {

        Obra obra = listaDeObras.get(i);
        ObrasViewHolder recetaViewHolder = (ObrasViewHolder) holder;
        recetaViewHolder.bindObra(obra);

    }

    @Override
    public int getItemCount() {
        return listaDeObras.size();
    }

    public class ObrasViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitulo;
        private TextView textViewAutor;
        private Obra obra;


        public ObrasViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textViewTitulo = itemView.findViewById(R.id.celdaObra_textView_tituloObra);
            this.textViewAutor = itemView.findViewById(R.id.celdaObra_textView_autorObra);


        }

        public void bindObra(Obra obra) {
            this.obra = obra;
            textViewAutor.setText(obra.getArtistId());
            textViewTitulo.setText(obra.getName());

        }
    }
}
