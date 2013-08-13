
package com.bluestome.android.databases.depends;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * @ClassName: DefaultDBCreateExec
 * @Description: TODO
 * @author bluestome
 * @date 2013-8-13 下午2:23:53
 */
public class DefaultDBCreateExec implements IDBCreateExec {
    static final String TAG = DefaultDBCreateExec.class.getCanonicalName();

    @Override
    public void createDB(SQLiteDatabase db) {
        Log.d(TAG, "DEFAULT CREATE DB");
    }

    @Override
    public void upgradeDB(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "DEFAULT UPGRADE DB");
    }

}
