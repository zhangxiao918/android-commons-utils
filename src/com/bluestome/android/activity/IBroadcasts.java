
package com.bluestome.android.activity;

/**
 * 广播注册和反注册接口
 * 
 * @author bluestome.zhang
 */
public interface IBroadcasts {

    /**
     * 注册广播组
     */
    void registerBroadcasts();

    /**
     * 反注册广播组
     */
    void unRegisterBroadcasts();
}
