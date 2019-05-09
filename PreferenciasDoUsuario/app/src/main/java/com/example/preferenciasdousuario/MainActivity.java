package com.example.preferenciasdousuario;

import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonSalvar;
    private TextInputEditText editNome;
    private TextView textOla;


    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    private static final String ARQUIVO_PREFERENCIA = "preferenciasDoUsuario";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSalvar = findViewById(R.id.buttonSalvar);
        editNome = findViewById(R.id.inputNome);
        textOla = findViewById(R.id.textOla);

        instanciarPreferences();
        alterarTextoOla();

        configurarButtonSalvar();
    }

    private void configurarButtonSalvar() {
        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor = salvarNome();

                if (editor != null)
                    alterarTextoOla();



            }
        });
    }

    private void instanciarPreferences() {
        preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, MODE_PRIVATE);
        editor = preferences.edit();
    }

    private void alterarTextoOla() {
        textOla.setText("Olá, " + preferences.getString("nomeUsuario", "Mundo") + "!");
    }

    private SharedPreferences.Editor salvarNome() {
        if (nomeValido()) {
            String nome = editNome.getText().toString();
            editor.putString("nomeUsuario", nome);
            editor.commit();
            return editor;
        } else {
            Toast.makeText(getApplicationContext(), "Preencha o nome.", Toast.LENGTH_LONG).show();
            return null;
        }
    }

    private boolean nomeValido() {

        return !editNome.getText().toString().isEmpty();

    }
}
