package com.example.calculadoradegorjeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editValor;
    private TextView txtPorcentagem;
    private TextView txtGorjeta;
    private TextView txtTotal;
    private SeekBar sbGorjeta;

    private double porcentagemDeGorjeta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor = findViewById(R.id.editValor);
        txtPorcentagem = findViewById(R.id.txtPorcentagem);
        txtGorjeta = findViewById(R.id.txtGorjeta);
        txtTotal = findViewById(R.id.txtTotal);
        sbGorjeta = findViewById(R.id.sbGorjeta);

        atualizarPorcentagem(sbGorjeta.getProgress());

        sbGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                atualizarPorcentagem(progress);
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void atualizarPorcentagem(int valor) {
        porcentagemDeGorjeta = valor;
        txtPorcentagem.setText(String.format("%04.2f%%", porcentagemDeGorjeta));
    }

    public void calcular() {
        try {
            Double valorDigitadoPeloUsuario = Double.parseDouble(editValor.getText().toString());

            double valorDaGorjeta = valorDigitadoPeloUsuario * (porcentagemDeGorjeta / 100);
            double valorTotal = valorDigitadoPeloUsuario + valorDaGorjeta;

            exibirResultados(valorDaGorjeta, valorTotal);

        } catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), "Digite um valor", Toast.LENGTH_SHORT).show();
        }
    }

    public void exibirResultados(double valorDaGorjeta, double valorTotal){
        txtGorjeta.setText(String.format("R$ %.2f", Math.round(valorDaGorjeta)));
        txtTotal.setText(String.format("R$ %.2f", valorTotal));
    }
}
