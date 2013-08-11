
package com.bluestome.android.activity;

/**
 * @ClassName: IActivityInitialization
 * @Description: TODO
 * @author bluestome
 * @date 2013-8-11 下午9:11:25
 */
public interface IActivityInitialization {

    /**
     * 初始化信息
     */
    void init();

    /**
     * 初始化视图组
     */
    void initViews();

    /**
     * 初始化数据组
     */
    void initDatas();
}
