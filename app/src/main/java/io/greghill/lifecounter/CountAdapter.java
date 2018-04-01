package io.greghill.lifecounter;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CountAdapter extends BaseAdapter {
    private final ArrayList mData;
    private int height = 0;
    private int players = 1;

    public CountAdapter(Map<String, Pair<String, Integer>> map, int size, int p) {
        mData = new ArrayList();
        mData.addAll(map.entrySet());
        height = size;
        players = p;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Map.Entry<String, Pair<String, Integer>> getItem(int position) {
        return (Map.Entry) mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO implement you own logic with ID
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View result;

        if (convertView == null) {
            result = LayoutInflater.from(parent.getContext()).inflate(R.layout.counter_item, parent, false);
        } else {
            result = convertView;
        }

        ViewGroup.LayoutParams params = result.getLayoutParams();
        params.height = height;
        result.setLayoutParams(params);

        final Map.Entry<String, Pair<String, Integer>> item = getItem(position);

        final TextView playerName = (TextView) result.findViewById(R.id.playerName);
        playerName.setText(item.getValue().getLeft());
        //playerName.setPaintFlags(playerName.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        if (players == 1) playerName.setTextSize(50);

        final TextView lifeCounter = (TextView)result.findViewById(R.id.lifeCounter);
        lifeCounter.setText(String.valueOf(item.getValue().getRight()));
        if (players == 1) lifeCounter.setTextSize(50);

        // handle buttons and add onClickListeners
        Button deleteBtn = (Button)result.findViewById(R.id.delete_btn);
        Button addBtn = (Button)result.findViewById(R.id.add_btn);
        Button rstBtn = (Button)result.findViewById(R.id.reset_btn);


        deleteBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int life = item.getValue().getRight();
                life--;
                item.getValue().setRight(life);
                lifeCounter.setText(String.valueOf(item.getValue().getRight()));
                playerName.setText(item.getValue().getLeft());
            }
        });
        addBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int life = item.getValue().getRight();
                life++;
                item.getValue().setRight(life);
                lifeCounter.setText(String.valueOf(item.getValue().getRight()));
                playerName.setText(item.getValue().getLeft());
            }
        });
        rstBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                item.getValue().setRight(20);
                lifeCounter.setText(String.valueOf(item.getValue().getRight()));
                playerName.setText(item.getValue().getLeft());
            }
        });


        playerName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    final EditText Caption = (EditText) v;
                    playerName.setText(Caption.getText().toString());
                    item.getValue().setLeft(Caption.getText().toString());
                }
            }
        });

        return result;
    }


}