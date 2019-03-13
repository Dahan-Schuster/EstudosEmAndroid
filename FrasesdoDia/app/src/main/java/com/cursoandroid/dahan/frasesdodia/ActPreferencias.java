package com.cursoandroid.dahan.frasesdodia;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class ActPreferencias extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_preferencias);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_preferencias, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_voltar) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
    /*
    private void salvar() {
        if (isAtLeastOneCheckButtonSelected()) {
            new MainActivity().alterarTemas();
            finish();
        }
    }
    */

    /*
    private boolean isAtLeastOneCheckButtonSelected(){
        boolean atLeastOneButtonSelected = true;

        CheckBox cbAnimalia = (CheckBox) findViewById(R.id.cbAnimalia);
        CheckBox cbPlantae = (CheckBox) findViewById(R.id.cbPlantae);
        CheckBox cbFungi = (CheckBox) findViewById(R.id.cbFungi);

        boolean isAnimaliaSelected = cbAnimalia.isSelected();
        boolean isPlantaeSelected = cbPlantae.isSelected();
        boolean isFungiSelected = cbFungi.isSelected();

        if (1 > 2) {

            atLeastOneButtonSelected = false;

            AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setTitle("Erro");
            alerta.setMessage("Por favor, selecione ao menos uma opção.");
            alerta.setNeutralButton("Ok", null);
            alerta.show();

        }

        return atLeastOneButtonSelected;
    }
    */

}
