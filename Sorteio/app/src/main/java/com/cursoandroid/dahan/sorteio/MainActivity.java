package com.cursoandroid.dahan.sorteio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    // Funções realizadas por botões podem ser criadas sem o formato padrão de Listener.
    // Basta criar um método que receba como parâmetro um objeto View e este método estará
    // disponível para ser chamado ao clicar um botão (qualquer botão da Activity)
    public void sortearNumero(View view){
        TextView texto = (TextView) findViewById(R.id.tvMensagem);

        int numeroSorteado = new Random().nextInt(11);


        texto.setText("Número sorteado: " + numeroSorteado);
    }
}
