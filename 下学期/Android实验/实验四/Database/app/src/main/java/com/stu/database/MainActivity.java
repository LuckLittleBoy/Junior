package com.stu.database;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DB db = null;
    private EditText username = null;
    private EditText userhobby = null;
    private SQLiteDatabase dbo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.etUserName);
        userhobby = (EditText)findViewById(R.id.etUserHobby);

        btnMainCreateDB_Click();
    }

    // 函数自定义 ******************************************************************

    // 创建数据库
    public void btnMainCreateDB_Click()
    {
        db = new DB(this,"dbUser.db",null,1);
        db.getReadableDatabase();
    }

    //  用户点击确定按钮
    public void btnSure_Click(View view)
    {
        dbo = db.getWritableDatabase();
        String strSql = "";
        String name = username.getText().toString();
        String hobby = userhobby.getText().toString();
        strSql = "select * from User where UserName = '" + name + "'";

        Cursor cursor;
        cursor = dbo.rawQuery(strSql,null);

        String strName = "";
        String strHobby = "";

        if (cursor.moveToNext())
        {
            strName = cursor.getString(cursor.getColumnIndex("UserName"));

            if (strName.equals(name))
            {
                Toast.makeText(MainActivity.this, "该用户已存在",Toast.LENGTH_SHORT).show();
            }
        }

        else
        {
            ContentValues contentValues = new ContentValues();
            contentValues.put("UserName",name);
            contentValues.put("UserHobby",hobby);
            db.getWritableDatabase().insert("User",null,contentValues);
            Toast.makeText(MainActivity.this, "用户创建成功",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,UserActivity.class);
            startActivity(intent);
        }
    }
}
