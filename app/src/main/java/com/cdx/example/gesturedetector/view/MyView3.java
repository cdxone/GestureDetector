package com.cdx.example.gesturedetector.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;


public class MyView3 extends View {

    private GestureDetector gestureDetector;//事件监听器

    public MyView3(Context context) {
        super(context);
        init(context);
    }

    public MyView3(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyView3(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        MySimpleOnGestureListener listener = new MySimpleOnGestureListener();
        gestureDetector = new GestureDetector(context,listener);
    }

    //适配器模式,将复杂的接口实现已经完全在SimpleOnGresureListener中实现
    //然后我们什么方法，我们就去实现就好了
    public class MySimpleOnGestureListener extends GestureDetector.SimpleOnGestureListener{

        //如果我只是想实现双击的监听，就实现这个方法就好
        @Override
        public boolean onDoubleTap(MotionEvent e) {
            Log.e("cdx","onDoubleTap");
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
