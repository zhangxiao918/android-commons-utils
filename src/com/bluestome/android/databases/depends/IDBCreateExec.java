
package com.bluestome.android.databases.depends;

import android.database.sqlite.SQLiteDatabase;

/**
 * @ClassName: IDBCreateExec
 * @Description: TODO
 * @author bluestome
 * @date 2013-8-10 上午10:14:01
 */
public interface IDBCreateExec {

    /**
     * 创建DB的方法
     * 
     * @param db
     */
    void createDB(SQLiteDatabase db);
}
