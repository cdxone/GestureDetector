package com.cdx.example.gesturedetector.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MyView4 extends View {

    private Context mContext;
    private GestureDetector mGestureDetector;

    public MyView4(Context context) {
        super(context);
        init(context);
    }

    public MyView4(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyView4(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        MySimpleOnGestureListener myGestureDetectore = new MySimpleOnGestureListener();
        mGestureDetector = new GestureDetector(myGestureDetectore);
    }

    class MySimpleOnGestureListener extends GestureDetector.SimpleOnGestureListener{

        /**
         * 滑动的时候执行此方法
         * @param e1 前一个MotionEvent
         * @param e2 后一个MotionEvent
         * @param velocityX 水平方向的速度
         * @param velocityY 竖直方向的速度
         * @return 返回是否拦截这个事件
         */
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            //逻辑：
            // 如果前一个事件的x值 > 后一个事件的x值，并且X轴的速度 > Y轴的速度，那么就是向左滑动
            // 如果前一个事件的x值 < 后一个事件的x值，并且X轴的速度 > Y轴的速度，那么就是向右滑动
            if (Math.abs(velocityX) > Math.abs(velocityY)){
                if (e1.getX() > e2.getX() ){
                    Toast.makeText(mContext, "Left!", Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(mContext, "Right!", Toast.LENGTH_SHORT).show();
                }
            }
            return true;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //首先获取到event事件，然后给他传递给mMyGestureDetectore对象。
        mGestureDetector.onTouchEvent(event);
        //这个事件必须返回true。
        return true;
    }
}
