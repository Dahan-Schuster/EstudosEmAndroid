package com.example.recyclerview.Activity.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.recyclerview.Activity.model.Filme;
import com.example.recyclerview.R;

import java.util.ArrayList;

public class AdapterFilmes extends RecyclerView.Adapter<AdapterFilmes.ViewHolderFilmes> {

    /**
     * Classe que representa os dados adicionados ao RecyclerView.
     * A classe RecyclerView.Adapter adiciona objetos ViewHolder ao RecylerView.
     * Aqui estão os dados exibidos, armazenados em componentes Widget.
     */
    public class ViewHolderFilmes extends RecyclerView.ViewHolder {

        TextView titulo;
        TextView genero;
        TextView ano;

        public ViewHolderFilmes(View itemView) {
            super(itemView);

            titulo  = itemView.findViewById(R.id.txtTitulo);
            ano     = itemView.findViewById(R.id.txtAno);
            genero  = itemView.findViewById(R.id.txtGenero);
        }

    }

    private ArrayList<Filme> filmes;

    public AdapterFilmes (ArrayList<Filme> filmes) {
        this.filmes = filmes;
    }


    /**
     * Método chamado ao criar o viewHolder, responsável por configurar as visualizações
     * Deve comunicar-se com um arquivo XML
     * @param parent
     * @param viewTipe
     * @return
     */
    @NonNull
    @Override
    public ViewHolderFilmes onCreateViewHolder(@NonNull ViewGroup parent, int viewTipe) {


        /**
         * Converte o layout XML em um objeto View a partir da classe LayoutInflater
         */
        View layout_filmes = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder_filmes, parent, false);


        return new ViewHolderFilmes(layout_filmes);
    }

    /**
     * Método chamado após a criação do view holder sempre que este se torna visível novamente.
     * Responsável por atualizar os dados do view holder sem recriá-lo
     * @param viewHolderFilmes
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolderFilmes viewHolderFilmes, int position) {

        Filme filme = filmes.get(position);

        String titulo = filme.getTitulo();
        String genero = filme.getGenero();
        String ano    = filme.getAno();

        viewHolderFilmes.titulo.setText(titulo);
        viewHolderFilmes.genero.setText(genero);
        viewHolderFilmes.ano.setText(ano);
    }

    @Override
    public int getItemCount() {
        return this.filmes.size();
    }


}
