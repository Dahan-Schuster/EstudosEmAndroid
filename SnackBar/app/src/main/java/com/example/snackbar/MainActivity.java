package com.example.snackbar;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonAbrir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAbrir = findViewById(R.id.buttonAbrir);

        buttonAbrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Botão pressionado", Snackbar.LENGTH_INDEFINITE)
                        .setAction("Confirmar", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                mensagemConfirmar();
                            }

                            private void mensagemConfirmar() {
                                Toast.makeText(getApplicationContext(), "'Confirmar' pressionado.", Toast.LENGTH_SHORT)
                                     .show();
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                        .show();

            }
        });
    }
}
