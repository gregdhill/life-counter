package io.greghill.lifecounter;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class OldText extends android.support.v7.widget.AppCompatTextView {

    public OldText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public OldText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public OldText(Context context) {
        super(context);
        init();
    }

    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Blackwood-Castle.ttf");
        setTypeface(tf ,1);
    }
}
