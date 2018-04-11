package com.example.jannik.hallo;

import android.content.res.ColorStateList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int progress_size = 24;/*Schriftgroeße Seekbar*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showText(View view){    /*OnClick Event*/
        final TextView hello = findViewById(R.id.textV_nachricht);
        hello.setText(R.string.begruessung);

        //graut Button aus
        Button show = findViewById(R.id.button_anzeigenNachricht);
        show.setEnabled(false);

        //Seekbar Schriftgroeße
        final TextView groesse = findViewById(R.id.textV_schriftgroesse);

        SeekBar size = findViewById(R.id.seekBar_schriftgroesse);
        size.setMax(100);

        size.setProgress(progress_size);
        hello.setTextSize(progress_size);
        groesse.setText(getString(R.string.groesse, Integer.toString(progress_size)));


        size.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                progress_size = i;
                hello.setTextSize(progress_size);
                groesse.setText(getString(R.string.groesse, Integer.toString(progress_size)));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
