package com.example.cardview.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cardview.R;
import com.example.cardview.activity.MainActivity;
import com.example.cardview.model.Post;

import java.util.ArrayList;

public class AdapterPostagem extends RecyclerView.Adapter<AdapterPostagem.ViewHolderPostagem> {

    private ArrayList<Post> posts;

    public AdapterPostagem(ArrayList<Post> posts) {
        this.posts = posts;
    }


    public class ViewHolderPostagem extends RecyclerView.ViewHolder {

        //private ImageButton btnCurtir, btnComentar;

        //private boolean curtido = false;
        //private ArrayList<String> comentarios = new ArrayList<>();

        TextView usuario;
        TextView tempo;
        ImageView imagem;
        TextView legenda;

        public ViewHolderPostagem(@NonNull View itemView) {
            super(itemView);

            this.usuario = itemView.findViewById(R.id.txtUsuario);
            this.tempo = itemView.findViewById(R.id.txtTempo);
            this.imagem = itemView.findViewById(R.id.imgPost);
            this.legenda = itemView.findViewById(R.id.txtLegenda);

           // this.btnCurtir = itemView.findViewById(R.id.btnCurtir);
           // this.btnComentar = itemView.findViewById(R.id.btnComentar);
        }

        /*
        public void curtir(View view) {
            if (curtido)
                btnCurtir.setImageResource(R.drawable.ic_mood_gray_24dp);
            else
                btnCurtir.setImageResource(R.drawable.ic_mood_purple_24dp);

            curtido = !curtido;
        }
        */
    }

    @NonNull
    @Override
    public ViewHolderPostagem onCreateViewHolder(@NonNull ViewGroup parent, int viewTipe) {

        View layout_postagem = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_postagem, parent, false);

        return new ViewHolderPostagem(layout_postagem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPostagem viewHolderPostagem, int position) {
        Post post = this.posts.get(position);

        String usuario = post.getUsuario();
        String tempo = post.getTempo();
        int imagem = post.getImagem();
        String legenda = post.getLegenda();

        viewHolderPostagem.usuario.setText(usuario);
        viewHolderPostagem.tempo.setText(tempo);
        viewHolderPostagem.imagem.setImageResource(imagem);
        viewHolderPostagem.legenda.setText(legenda);

    }

    @Override
    public int getItemCount() {
        return this.posts.size();
    }
}
