package com.stu.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DB extends SQLiteOpenHelper
{
    // 函数 *********************************************************************
    // 构造
    public DB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }

    // 创建
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String stuSQL = "create table User("
                + "UserID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "UserName text not null,"
                + "UserHobby text not null"
                + ")";

        db.execSQL(stuSQL);
    }

    // 升级
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
    }
}
