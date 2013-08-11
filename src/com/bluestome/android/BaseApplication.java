
package com.bluestome.android;

import android.app.Application;

/**
 * @ClassName: BaseApplication
 * @Description: TODO
 * @author bluestome
 * @date 2013-8-10 上午9:54:42
 */
public abstract class BaseApplication extends Application {

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        init();
    }

    /**
     * 初始化服务
     */
    public abstract void init();
}
