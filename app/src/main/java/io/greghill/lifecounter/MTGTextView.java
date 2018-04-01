package io.greghill.lifecounter;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class MTGTextView extends android.support.v7.widget.AppCompatTextView {

    public MTGTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public MTGTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MTGTextView(Context context) {
        super(context);
        init();
    }

    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/MAGIC.TTF");
        setTypeface(tf ,1);
    }
}