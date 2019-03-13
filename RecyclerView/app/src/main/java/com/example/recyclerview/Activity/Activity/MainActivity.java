package com.example.recyclerview.Activity.Activity;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.recyclerview.Activity.adapter.AdapterFilmes;
import com.example.recyclerview.Activity.events.RecyclerItemClickListener;
import com.example.recyclerview.Activity.model.Filme;
import com.example.recyclerview.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerFilmes;

    private ArrayList<Filme> filmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerFilmes = findViewById(R.id.recyclerFilmes);

        /** CONFIGURAR RECYCLER VIEW */

        /** Recomendação para melhoria de performance
         * Usando o HasFixedSize true o recycler view passa a ter um número fixo
         * de view holders que vão sendo reciclados enquanto o usuário desliza a tela
         * Definir um tamanho de 10 viewHolders, por exemplo, faz com que tenham sempre
         * 10 view holders na tela que são recarregados com os dados necessários,
         * como lâmpadas led trabalhando juntas.
         */
        recyclerFilmes.setHasFixedSize(true);

        /** Layout */
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext()); /** Objeto Gerenciador de layout configurado com Linear Layout */
        recyclerFilmes.setLayoutManager(layoutManager); /** Define o objeto LayoutManager como gerenciador de layout do objeto Recycler View */

        /** Adapter - recebe e formata os dados para criar um ViewHolder */

        preencherArrayList();

        AdapterFilmes adapterFilmes = new AdapterFilmes(filmes);
        recyclerFilmes.setAdapter(adapterFilmes);


        /** Eventos de clique */
        recyclerFilmes.addOnItemTouchListener(
            new RecyclerItemClickListener(getApplicationContext(), recyclerFilmes, new RecyclerItemClickListener.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    criarToast(position);
                }

                @Override
                public void onLongItemClick(View view, int position) {
                    criarAlertDialog(position);
                }

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                }
            })
        );



    }

    private void criarToast(int position){
        String texto = String.format("%s selecionado" ,filmes.get(position).getTitulo());

        Toast.makeText(getApplicationContext(), texto, Toast.LENGTH_SHORT).show();
    }

    private void criarAlertDialog(int position){
        // Criar mensagem

        Filme filme = filmes.get(position);

        String mensagem = String.format(
                "Título: %s\n" +
                        "Gênero: %s\n" +
                        "Ano:    %s",
                filme.getTitulo(),
                filme.getGenero(),
                filme.getAno());

        // Criar alerta

        // Instanciando um objeto Dialog
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        // Definindo um ícone ao lado do título
        dialog.setIcon(R.drawable.ic_info_green_24dp);

        dialog.setTitle("Informações do Filme");
        dialog.setMessage(mensagem);
        dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        // Criar o Dialog e exibí-lo
        dialog.create();
        dialog.show();
    }

    private void preencherArrayList(){

        filmes.add(new Filme("Kill Bill",      "Mistério", "2003"));
        filmes.add(new Filme("Clube da Luta",  "Ação",     "1999"));
        filmes.add(new Filme("trainspotting",  "Drama",    "1996" ));
        filmes.add(new Filme("Donnie Darko",   "Fantasia", "2001"));
        filmes.add(new Filme("Forrest Gump",   "Drama",    "1994"));
        filmes.add(new Filme("Pulp Fiction",   "Ação",     "1994"));
        filmes.add(new Filme("Tudo por amor",  "Romance",  "1991"));
        filmes.add(new Filme("Laranja Mecânica",   "Drama",  "1971"));
        filmes.add(new Filme("Clube dos Cinco",    "Drama",  "1985"));
        filmes.add(new Filme("O Poderoso Chefão",  "Drama",  "1972"));
        filmes.add(new Filme("Cães de aluguel",    "Mistério", "1992"));
        filmes.add(new Filme("Assassinos por natureza",  "Suspense",  "1994"));
    }


}

