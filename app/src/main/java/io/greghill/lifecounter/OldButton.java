package io.greghill.lifecounter;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class OldButton extends android.support.v7.widget.AppCompatButton {

    public OldButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public OldButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public OldButton(Context context) {
        super(context);
        init();
    }

    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Blackwood-Castle.ttf");
        setTypeface(tf ,1);
    }
}
