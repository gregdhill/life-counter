package io.greghill.lifecounter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedHashMap;

public class Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_info);

        TextView dev = (TextView)findViewById(R.id.developer);
        dev.setText(Html.fromHtml("Developer: <a href=\"http://greghill.io/\">Greg Hill</a>"));
        dev.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());

        TextView art1 = (TextView)findViewById(R.id.lotus);
        art1.setText(Html.fromHtml("Black Lotus by <a href=\"http://www.rahnart.com/\">Chris Rahn</a>"));
        art1.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());

        TextView art2 = (TextView)findViewById(R.id.life);
        art2.setText(Html.fromHtml("Chalice of Life by <a href=\"http://ryanyee.com/\">Ryan Yee</a>"));
        art2.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());

    }
}
