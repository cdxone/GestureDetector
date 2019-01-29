package com.cdx.example.gesturedetector;

import android.view.View;
import com.cdx.example.gesturedetector.activity.Test1Activity;
import com.cdx.example.gesturedetector.activity.Test2Activity;

import java.util.ArrayList;
import apis.amapv2.com.listviewlibrary.activity.BaseListActivty;
import apis.amapv2.com.listviewlibrary.bean.ItemObject;

public class MainActivity extends BaseListActivty {

    @Override
    protected void initData() {
        //显示标题
        mTvTitle.setText("GestureDetector的相关用法");
        mTvTitle.setVisibility(View.VISIBLE);

        //显示数据
        ArrayList<ItemObject> data = new ArrayList<>();
        data.add(new ItemObject("GestureDetector实现监听单机效果", Test1Activity.class));
        data.add(new ItemObject("GestureDetector实现监听双击的效果", Test2Activity.class));

        mMyListView.setData(data);
    }
}
