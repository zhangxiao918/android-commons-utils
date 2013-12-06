
package com.bluestome.android.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.bluestome.android.widget.ToastUtil;

import java.lang.ref.WeakReference;

/**
 * Activity基类
 * 
 * @author bluestome.zhang
 */
public abstract class BaseActivity extends Activity implements IBaseActivity {

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

    @Override
    public Context getContext() {
        // TODO Auto-generated method stub
        return this;
    }

    /**
     * 执行线程
     * 
     * @param r 线程接口
     */
    protected void submit(Runnable r) {
        submit(r, 0L);
    }

    /**
     * 执行线程
     * 
     * @param runnable 线程接口
     * @param delayed 延迟时间
     */
    protected void submit(Runnable runnable, long delayed) {
        if (delayed > 0L) {
            mHandler.postDelayed(runnable, delayed);
        } else {
            mHandler.post(runnable);
        }
    }

    protected int mQuitCount = 0;

    /**
     * 退出游戏逻辑方法
     * 
     * @return
     */
    protected abstract void quit();

    /**
     * 重置计数器方法
     * 
     * @return
     */
    protected abstract void resetQuit();

    @Override
    public void onBackPressed() {
        mQuitCount++;
        if (mQuitCount % 2 == 0) {
            super.onBackPressed();
            quit();
        } else {
            ToastUtil.resultNotify(getContext(), "再按一次退出游戏", Toast.LENGTH_SHORT);
            resetQuit();
        }
    }
}
