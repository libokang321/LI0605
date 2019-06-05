package com.bawei;

import android.app.Application;

import com.uuzuche.lib_zxing.activity.ZXingLibrary;

/*
 *@Auther:姓名
 *@Date: 时间
 *@Description:MyApplication
 * */public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ZXingLibrary.initDisplayOpinion(this);
    }
}
