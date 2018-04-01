package io.greghill.lifecounter;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.shawnlin.numberpicker.NumberPicker;

import java.util.Random;

public class Players extends AppCompatActivity {

    int numPlayers;

    public Players () {
        numPlayers = 1;
    }

    public void updatePlayers (int number) {
        Log.d(getClass().getName(), String.valueOf(number));
        numPlayers = number;
    }

    public int getPlayers () {
        return numPlayers;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start);

        final Button die = (Button)findViewById(R.id.diceBtn);
        die.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rand = new Random();
                int value = rand.nextInt(20)+1;
                die.setText(String.valueOf(value));
            }
        });

        NumberPicker numberPicker = (NumberPicker) findViewById(R.id.numPlayers);
        numberPicker.setValue(1);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/Blackwood-Castle.ttf");
        numberPicker.setTypeface(Typeface.create(custom_font, Typeface.NORMAL));
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                updatePlayers(newVal);
            }
        });

        Button add = (Button)findViewById(R.id.addPlayers);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Players.this, Counter.class)
                        .putExtra("numberOfPlayers", String.valueOf(getPlayers())));
            }
        });

        Button inf = (Button)findViewById(R.id.infoBtn);
        inf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Players.this, Info.class));
            }
        });

    }



}
