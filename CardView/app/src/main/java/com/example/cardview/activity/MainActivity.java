package com.example.cardview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.cardview.R;
import com.example.cardview.adapter.AdapterPostagem;
import com.example.cardview.model.Post;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerPostagem;

    private ArrayList<Post> posts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerPostagem = findViewById(R.id.recyclerPostagem);
        recyclerPostagem.setHasFixedSize(true);

        popularArrayList();

        // Define Layout para o RecylerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerPostagem.setLayoutManager(layoutManager);

        // Define Adapter
        AdapterPostagem adapter = new AdapterPostagem(posts);
        recyclerPostagem.setAdapter(adapter);

    }

    private void popularArrayList() {
        posts.add(new Post("Dahan Schuster", "Agora Mesmo", R.drawable.anotherworld, "I love the Chemical Brothers"));
        posts.add(new Post("Morgana Lima", "Agora Mesmo", R.drawable.heart_and_love_brain_and_reason, "Love! Reason!"));
        posts.add(new Post("Guilhermino", "Há 1h", R.drawable.galaxy, "Será que estamos sozinhos?"));
        posts.add(new Post("Snott Pilgrim", "Há 2h", R.drawable.optimistic_nihilism, "..."));
        posts.add(new Post("Marshall Lins", "Ontem", R.drawable.while_alive, "Why am i posting this?"));
    }
}
