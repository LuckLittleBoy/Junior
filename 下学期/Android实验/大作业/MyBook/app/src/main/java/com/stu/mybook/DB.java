package com.stu.mybook;

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
        Log.d("EBook","调用DB构造函数");
    }

    // 创建
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String stuSQL = "create table Student("
                + "UserID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "UserName text not null,"
                + "UserPwd text not null"
                + ")";

        db.execSQL(stuSQL);

        String bookClassifySQL = "create table BookClassify("
                + "ClassifyID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "ClassifyName text not null"
                + ")";

        db.execSQL(bookClassifySQL);

        String bookSQL = "create table Book("
                + "BookID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "BookName text not null,"
                + "BookAuthor text not null,"
                + "BookPress text not null,"
                + "BookISBN text not null,"
                + "BookClassify text"
                + ")";

        db.execSQL(bookSQL);

        String noteSQL = "create table Notes("
                + "UserID INTEGER not null,"
                + "BookID INTEGER not null,"
                + "NoteDate text not null,"
                + "NoteContent text,"
                + "constraint PK_Note primary key (UserID,BookID,NoteDate)"
                + "constraint FKUserID foreign key(UserID) references Student(UserID)"
                + "constraint FKBookID foreign key(BookID) references Book(BookID)"
                + ")";

        db.execSQL(noteSQL);

        Log.d("EBook","调用DB.onCreate()");
    }

    // 升级
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        Log.d("EBook","调用DB.onUpgrade()");
    }
}
