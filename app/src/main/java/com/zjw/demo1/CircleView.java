package com.zjw.demo1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CircleView extends View {
    private int height;
    private int width;

    private Paint defaultPaint;

    public CircleView(Context context) {
        super(context);
        initPaint();
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initPaint();
    }

    /**
     * 画笔
     */
    public void initPaint(){
        defaultPaint = new Paint();
        defaultPaint.setStyle(Paint.Style.FILL);
        defaultPaint.setColor(Color.RED);
    }

    /**
     * 获取高和宽
     * @param w
     * @param h
     * @param oldw
     * @param oldh
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        height = h;
        width = w;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //将坐标原点移到屏幕中央
        canvas.translate(width/3,height/3);
        //计算圆的半径
        //int radius = Math.min(width,height)/2;
        //画圆
        //canvas.drawCircle(0,0,radius/2,defaultPaint);
        canvas.drawRect(150, 75, 250, 120,defaultPaint);
    }
}
