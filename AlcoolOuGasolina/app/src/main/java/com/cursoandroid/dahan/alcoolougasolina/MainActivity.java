package com.cursoandroid.dahan.alcoolougasolina;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText alcool, gasosa;
    private TextView txt_resultado;

    private double RENDIMENTO_ALCOOL_GASOLINA = 0.7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alcool = findViewById(R.id.etxt_alcool);
        gasosa = findViewById(R.id.etxt_gasosa);
        txt_resultado = findViewById(R.id.txt_resultado);
    }

    public void enviar (View view) {
        try {
            double PRECO_GASOSA = Double.parseDouble(gasosa.getText().toString());
            double PRECO_ALCOOl = Double.parseDouble(alcool.getText().toString());

            double PRECO_MAXIMO_ALCOOL = PRECO_GASOSA * RENDIMENTO_ALCOOL_GASOLINA;

            mostrarResultado(PRECO_ALCOOl < PRECO_MAXIMO_ALCOOL);
        } catch (NumberFormatException e) {
            txt_resultado.setText("Digite ambos os preços do álcool e da gasolina antes de enviar.");

        }
    }

    public void mostrarResultado(boolean alcoolMaisEficiente) {
        if (alcoolMaisEficiente) txt_resultado.setText("Melhor usar álcool!");
        else txt_resultado.setText("Melhor usar gasolina!");
    }
}
