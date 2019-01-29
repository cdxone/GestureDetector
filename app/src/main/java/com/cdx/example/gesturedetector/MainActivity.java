package com.cdx.example.gesturedetector;

import android.view.View;
import com.cdx.example.gesturedetector.activity.Test1Activity;
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
        data.add(new ItemObject("GestureDetector监听事件", Test1Activity.class));

        mMyListView.setData(data);
    }
}
