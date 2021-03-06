package com.cdx.example.gesturedetector.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;


public class MyView2 extends View {

    private GestureDetector gestureDetector;//事件监听器

    public MyView2(Context context) {
        super(context);
        init(context);
    }

    public MyView2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        GestureListener listener = new GestureListener();
        gestureDetector = new GestureDetector(context,listener);
    }

    /**
     * ❤ ❤ ❤ ❤ ❤
     * 1、要想监听单机的效果，必须要实现GestureDetector.OnGestureListener这个接口。
     * 2、要想监听双击的效果，必须要实现GestureDetector.OnDoubleTapListener这个接口。
     */
    private class GestureListener implements GestureDetector.OnGestureListener
            ,GestureDetector.OnDoubleTapListener{

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
        public boolean onScroll(MotionEvent e1, MotionEvent e2,
                                float distanceX, float distanceY) {
            Log.e(TAG,"onScroll");
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

        //OnDoubleTapListener中的方法
        //单击事件
        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            Log.e(TAG,"onSingleTapConfirmed");
            return false;
        }

        //OnDoubleTapListener中的方法
        //双击事件
        @Override
        public boolean onDoubleTap(MotionEvent e) {
            Log.e(TAG,"onDoubleTap");
            return false;
        }

        //OnDoubleTapListener中的方法
        //双击间隔中发生的操作
        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            Log.e(TAG,"onDoubleTapEvent");
            return false;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //在onTouchEvent中拦截事件，并且将事件传递给了gestureDetector对象中。
        gestureDetector.onTouchEvent(event);

        //表示我需要这个事件，以后都将事件给我
        return true;
    }

}
