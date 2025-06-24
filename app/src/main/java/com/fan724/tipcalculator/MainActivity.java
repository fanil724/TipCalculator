package com.fan724.tipcalculator;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar seekBar = findViewById(R.id.seekBar);
        EditText editSum = findViewById(R.id.inputSum);
        TextView textTip = findViewById(R.id.tip);
        TextView endZak = findViewById(R.id.endZak);
        TextView endTip = findViewById(R.id.endTip);
        TextView endSum = findViewById(R.id.endSum);

        Button btn = findViewById(R.id.btn);

        btn.setOnClickListener(v -> {
            String text = editSum.getText().toString();
            Integer s;
            if (text.equals("0")) {
                s = 0;
            } else {
                s = (Integer.parseInt(text) * seekBar.getProgress()) / 100;
            }
            endZak.setText(String.valueOf(s));
            textTip.setText(String.valueOf(s));
            endTip.setText(String.valueOf(s));
            endSum.setText(String.valueOf(Integer.parseInt(text) + s));

        });


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

                int sumZak = Integer.parseInt(editSum.getText().toString());
                int sumTip = (sumZak * progress) / 100;
                textTip.setText(String.valueOf(sumTip));
                endTip.setText(String.valueOf(sumTip));
                endSum.setText(String.valueOf(sumZak + sumTip));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d("SeekBar", "Пользователь начал перемещение");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d("SeekBar", "Пользователь закончил перемещение");
            }
        });
    }
}