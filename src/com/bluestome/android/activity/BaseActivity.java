
package com.bluestome.android.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

/**
 * Activity基类
 * 
 * @author bluestome.zhang
 */
public abstract class BaseActivity extends Activity implements IBaseActivity,
        IActivityInitialization {

    protected MyHandler mHandler = new MyHandler(this);

    protected static class MyHandler extends Handler {
        private WeakReference<BaseActivity> mActivity;

        public MyHandler(BaseActivity activity) {
            mActivity = new WeakReference<BaseActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            BaseActivity activity = mActivity.get();
            if (null != activity) {
                super.handleMessage(msg);
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        init();
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
    }

    /**
     * 基本参数初始化
     */
    @Override
    public void init() {
        // TODO Auto-generated method stub

    }

    /**
     * 视图组件初始化
     */
    @Override
    public void initViews() {
        // TODO Auto-generated method stub

    }

    /**
     * 数据初始化
     */
    @Override
    public void initDatas() {
        // TODO Auto-generated method stub

    }

    @Override
    public Context getContext() {
        // TODO Auto-generated method stub
        return this;
    }

}
