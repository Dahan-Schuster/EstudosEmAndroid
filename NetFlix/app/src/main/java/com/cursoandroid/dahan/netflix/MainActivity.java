package com.cursoandroid.dahan.netflix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnSeekBarChangeListener {

    SeekBar tempo;

    TextView txt_minutes_passed;
    TextView txt_minutes_left;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tempo = findViewById(R.id.sbtempo);
        tempo.setOnSeekBarChangeListener(this);
        txt_minutes_passed = findViewById(R.id.txt_minutes_passed);
        txt_minutes_left = findViewById(R.id.txt_minutes_left);
    }

    boolean isVideoPaused = false;

    public void setPlay_pause(View view) {
        ImageView play_pause = findViewById(R.id.play_pause);
        if (isVideoPaused)
            play_pause.setImageDrawable(getResources().getDrawable(R.drawable.ic_play_arrow_branco_24dp));
        else
            play_pause.setImageDrawable(getResources().getDrawable(R.drawable.ic_pause_branco_24dp));

        isVideoPaused = !isVideoPaused;
    }


    public void attMinutos(int progress) {
        int min_passed = (int) progress / 60;
        int sec_passed = (int) progress % 60 * 60;


        int progress_left = tempo.getMax() - progress;

        int min_left = (int) progress_left / 60;
        int sec_left = (int) progress_left % 60 * 60;

        txt_minutes_passed.setText(String.format("%02d:%02d", min_passed, sec_passed).substring(0, 5));
        txt_minutes_left.setText(String.format("%02d:%02d", min_left, sec_left).substring(0, 5));

    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        attMinutos(progress);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        attMinutos(tempo.getProgress());
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        attMinutos(tempo.getProgress());
    }
}
