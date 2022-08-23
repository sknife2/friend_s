package com.example.app10.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.app10.util.UserBean;

public class Database extends SQLiteOpenHelper {
    private static final String TABLE_NAME = "UserBean.db";
    private static final int DB_VERSION = 1;
    private SQLiteDatabase RDB = null;
    private SQLiteDatabase WDB = null;
    private static Database database = null;

    private Database(Context context) {
        super(context, TABLE_NAME, null, DB_VERSION);
    }

    public static Database getInstance(Context context) {
        if (database == null) {
            database = new Database(context);
        }
        return database;
    }

    public SQLiteDatabase openReadLink() {
        if (RDB == null || !RDB.isOpen()) {
            RDB = database.getReadableDatabase();
        }
        return RDB;
    }

    public SQLiteDatabase openWriteLink() {
        if (WDB == null || !WDB.isOpen()) {
            WDB = database.getWritableDatabase();
        }
        return WDB;
    }

    public boolean closeLink() {
        if (RDB != null && RDB.isOpen()) {
            RDB.close();
            RDB = null;
        }
        if (WDB != null && WDB.isOpen()) {
            WDB.close();
            WDB = null;
        }
        return true;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "name varchar not null," +
                "age integer not null," +
                "head_icon string)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    /*public long insert(UserBean UserBean) {
        ContentValues values = new ContentValues();
        values.put("name", UserBean.getName());
        values.put("age", UserBean.getAge());
        values.put("head_icon", UserBean.getHead_icon());
        try {
            WDB.beginTransaction();
            WDB.insert(TABLE_NAME, null, values);
            WDB.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            WDB.endTransaction();
        }
        return 1;
    }*/
}
