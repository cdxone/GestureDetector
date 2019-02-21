package com.cdx.example.gesturedetector.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class MyView extends View {

    private GestureDetector gestureDetector;//事件监听器

    public MyView(Context context) {
        super(context);
        init(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        gestureDetector = new GestureDetector(context,new GestureListener());
    }


    private class GestureListener implements GestureDetector.OnGestureListener{

        private static final String TAG = "GestureListener";

        //用户按下屏幕触发
        public boolean onDown(MotionEvent e) {
            Log.e(TAG,"onDown");
            return false;
        }

        //用户按下并且没有松开或者是拖动
        public void onShowPress(MotionEvent e) {
            Log.e(TAG,"onShowPress");
        }

        //轻轻触摸屏幕后松开
        public boolean onSingleTapUp(MotionEvent e) {
            Log.e(TAG,"onSingleTapUp");
            return false;
        }

        //手指按下并且拖动
        /**
         * @param e1 第一次按下的位置
         * @param e2 移动过程中的位置
         * @param distanceX 滑动起点到滑动终点的水平距离，而不是起点和终点的直线距离,在一次滑动的过程中，e1.getX()值一直不会变。
         * @param distanceY 滑动起来到滑动终点的竖直距离，而不是起点和终点的直线距离。
         * @return
         */
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            Log.e(TAG,"onScroll");
            Log.e("onScroll","e1.getX():" + e1.getX() + " e2.getX():" + e2.getX());

            return false;
        }

        //用户长久的按着屏幕不放，即长按
        public void onLongPress(MotionEvent e) {
            Log.e(TAG,"onLongPress");
        }

        //用户按下触摸屏，快速移动后松开，由一个ACTION_DOWN,多个ACTION_MOVE,一个ACTION_UP触发。
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                               float velocityY) {
            Log.e(TAG,"onFling");
            return false;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //在onTouchEvent中拦截事件，并且将事件传递给了gestureDetector
        gestureDetector.onTouchEvent(event);

        //表示我需要这个事件，以后都将事件给我
        return true;
    }
}
