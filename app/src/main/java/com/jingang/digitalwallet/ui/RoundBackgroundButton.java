package com.jingang.digitalwallet.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageButton;


/**
 * @Description:
 * @Author: jingang.Li
 * @CreateTime:2021/6/30-10:43 PM
 * @changeTime:
 */
public class RoundBackgroundButton extends androidx.appcompat.widget.AppCompatImageButton {
    public RoundBackgroundButton(Context context) {
        super(context);
    }
    public RoundBackgroundButton(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public RoundBackgroundButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        int width = getWidth();
        int height = getHeight();
        int radius = Math.min(width,height)/2;
        canvas.drawCircle(width/2,height/2,radius,paint);
        super.onDraw(canvas);
    }
}
