
package com.bluestome.android.databases;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.bluestome.android.databases.depends.DefaultDBCreateExec;
import com.bluestome.android.databases.depends.IDBCreateExec;
import com.bluestome.android.utils.StringUtil;

/**
 * 类说明：SQLite操作类
 * 
 * @author bluestome.zhang
 * @date 2013-4-27
 * @version 1.0
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = DatabaseHelper.class.getCanonicalName();

    private static final String name = "base.db";

    private static int version = 1;
    private static DatabaseHelper databaseHelper = null;
    private static SQLiteDatabase sqLiteDatabase = null;
    private IDBCreateExec exec;

    private DatabaseHelper(Context context, String dbName, IDBCreateExec exec) {
        super(context, dbName, null, version);
        this.exec = exec;
    }

    private DatabaseHelper(Context context) {
        super(context, name, null, version);
    }

    private synchronized static DatabaseHelper getInstance(Context context) {
        if (databaseHelper == null) {
            try {
                PackageManager pm = context.getPackageManager();
                PackageInfo pinfo = pm.getPackageInfo(context.getPackageName(),
                        PackageManager.GET_CONFIGURATIONS);
                version = pinfo.versionCode;
                if (version == 0) {
                    version = 1;
                }
            } catch (NameNotFoundException e) {
                e.printStackTrace();
            }
            databaseHelper = new DatabaseHelper(context, name, new DefaultDBCreateExec());
        }
        if (sqLiteDatabase == null) {
            sqLiteDatabase = databaseHelper.getWritableDatabase();
            Log.e(TAG, "初始化SQLiteDatabase [" + (sqLiteDatabase != null) + "], name [" + name
                    + "], version [" + version + "]");
        }

        return databaseHelper;
    }

    public synchronized static DatabaseHelper getInstance(Context context, String dbName,
            IDBCreateExec exec) {
        if (databaseHelper == null) {
            try {
                PackageManager pm = context.getPackageManager();
                PackageInfo pinfo = pm.getPackageInfo(context.getPackageName(),
                        PackageManager.GET_CONFIGURATIONS);
                version = pinfo.versionCode;
                if (version == 0) {
                    version = 1;
                }
            } catch (NameNotFoundException e) {
                e.printStackTrace();
            }
            databaseHelper = new DatabaseHelper(context,
                    StringUtil.isBlank(dbName) ? name : dbName,
                    (null == exec ? new DefaultDBCreateExec() : exec));
        }
        if (sqLiteDatabase == null) {
            sqLiteDatabase = databaseHelper.getWritableDatabase();
            Log.e(TAG, "初始化SQLiteDatabase [" + (sqLiteDatabase != null) + "], name [" + dbName
                    + "], version [" + version + "]");
        }

        return databaseHelper;
    }

    public SQLiteDatabase getSQLiteDatabase() {
        return sqLiteDatabase;
    }

    public synchronized void shutdown() {
        if (sqLiteDatabase != null) {
            try {
                sqLiteDatabase.close();
                sqLiteDatabase = null;
            } catch (Exception e) {
            }
        }
        if (databaseHelper != null) {
            try {
                databaseHelper.close();
                databaseHelper = null;
            } catch (Exception e) {
            }
        }
        Log.i(TAG, "数据库成功关闭");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO 执行SQL语句
        if (null != exec) {
            exec.createDB(db);
        } else {
            Log.e(TAG, "创建数据库失败,没有构件表");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "onUpgrade !!!! oldVersion  " + oldVersion + "  newVersion:"
                + newVersion);
        if (null != exec) {
            exec.upgradeDB(db, oldVersion, newVersion);
        } else {
            Log.e(TAG, "升级失败,没有数据库接口类");
        }
    }

}
