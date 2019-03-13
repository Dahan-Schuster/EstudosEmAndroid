package com.cursoandroid.dahan.frasesdodia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> frases = new ArrayList<>();


    private void preencherFrases(){
        frases.add("Um atum pode nadar até 64 quilômetros em um só dia");
        frases.add("Alguns anfíbios saltam distâncias que correspondem a 100 vezes o seu tamanho");
        frases.add("Ratos também sentem cócegas");
        frases.add("As cabras têm sotaques diferentes");
        frases.add("Beija-flores podem voar de frente, de costas e até mesmo de ponta-cabeça");
        frases.add("As formigas são equipadas com cinco narizes diferentes");
        frases.add("Golfinhos dão nomes uns aos outros");
        frases.add(" Ursos adultos podem correr tão rápido quanto os cavalos");
        frases.add("O coice mais poderoso que existe é o da girafa (mintira, é o coice que eu vou te dar se tu me encher o saco)");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        frases = new ArrayList<>();
        preencherFrases();

    }


    public void abrirConfiguracoes(View view) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_sobre) {
           Intent it = new Intent(MainActivity.this, ActPreferencias.class);
           startActivity(it);
        }

        return super.onOptionsItemSelected(item);
    }


    public void gerarNovaFrase(View view) {
        TextView txtFrase = (TextView) findViewById(R.id.txtFrase);

        txtFrase.setText(frases.get(new Random().nextInt(frases.size())));

    }

    public void alterarTemas() {
        Toast.makeText(this, "Alterar tema.", Toast.LENGTH_SHORT).show();
    }
}
