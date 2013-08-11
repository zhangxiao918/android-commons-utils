
package com.bluestome.android.databases.dao;

/**
 * @ClassName: BaseDAO
 * @author Bluestome.zhang
 * @date 2012-5-12 上午12:11:51
 */
public interface IBaseDAO {
    /**
     * 开始事务
     */
    public void beginTransaction();

    /**
     * 结束事务
     * 
     * @param isSuccess
     */
    public void endTransaction(boolean isSuccess);
}
