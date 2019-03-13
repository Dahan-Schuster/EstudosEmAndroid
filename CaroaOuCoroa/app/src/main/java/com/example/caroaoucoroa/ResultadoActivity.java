package com.example.caroaoucoroa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Random;

public class ResultadoActivity extends AppCompatActivity {

    private ImageView imgResultado;
    private ImageButton btnVoltar;

    private Random random;
    private boolean resultadoIsCara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        imgResultado = findViewById(R.id.imgResultado);
        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        random = new Random();

        jogar();
    }

    private void jogar(){
        resultadoIsCara = random.nextBoolean();
        setImagemResultado();
    }

    private void setImagemResultado(){
        if (resultadoIsCara)
            imgResultado.setImageResource(R.drawable.moeda_cara);
        else
            imgResultado.setImageResource(R.drawable.moeda_coroa);
    }

}
