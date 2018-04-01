package io.greghill.lifecounter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Counter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_counter);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;

        Intent intent = getIntent();
        String players = intent.getStringExtra("numberOfPlayers");

        int numPlayers = 1;
        try {
            numPlayers = Integer.parseInt(players);
            if (numPlayers>=2) {
                height /= 2;
            }
        } catch(NumberFormatException nfe) {
            numPlayers = 1;
        }

        LinkedHashMap<String, Pair<String, Integer>> list = new LinkedHashMap<>();

        for(int i=1; i<=numPlayers; i++) {
            Pair<String, Integer> p = new Pair<>("Player " + i, 20);
            list.put("Player " + i, p);
        }

        //instantiate custom adapter
        CountAdapter adapter = new CountAdapter(list, height, numPlayers);
        ListView lView = (ListView)findViewById(R.id.listView);
        lView.setAdapter(adapter);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if ( v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int)event.getRawX(), (int)event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent( event );
    }
}
