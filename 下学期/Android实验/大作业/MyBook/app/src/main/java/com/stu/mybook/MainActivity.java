package com.stu.mybook;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class MainActivity extends AppCompatActivity {

    // 变量 *********************************************************************
    private DB db = null;
    private EditText username = null;
    private EditText pwd = null;
    private TextView tvMainInfo = null;
    private String name = null;
    private String password = null;
    private static  Context context;
    private SQLiteDatabase dbo;
    private int userID=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText)findViewById(R.id.username);
        pwd=(EditText)findViewById(R.id.pwd);

        btnMainCreateDB_Click();

        oldUserLogin();
    }
    // 函数自定义 ******************************************************************

    // 创建数据库
    public void btnMainCreateDB_Click()
    {
        Log.d("EBook","调用MainActivity.btnMainCreateDB_Click()");
        db = new DB(this,"dbStudentMis.db",null,1);

        Log.d("EBook","调用db.getReadableDatabase");
        db.getReadableDatabase();

    }

    //  用户点击登陆按钮
    public void btnLogin_Click(View view)
    {
        dbo = db.getWritableDatabase();
        String strSql = "";
        name = username.getText().toString();
        password = pwd.getText().toString();
        strSql = "select * from Student";

        Cursor cursor;
        cursor = dbo.rawQuery(strSql,null);

        boolean isname=false;

        String strPwd = "";
        String strName = "";

        while (cursor.moveToNext())
        {
            userID = cursor.getInt(cursor.getColumnIndex("UserID"));
            strName = cursor.getString(cursor.getColumnIndex("UserName"));
            strPwd = cursor.getString(cursor.getColumnIndex("UserPwd"));

            if (strName.equals(name))
            {
                isname=true;
                if(strPwd.equals(password))
                {
                    saveProUserInfo(this,userID,name,password);
                    Toast.makeText(MainActivity.this, "登陆成功",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,UserActivity.class);
                    MainActivity.this.startActivity(intent);
                    finish();
                    break;
                }
                else
                {
                    Toast.makeText(MainActivity.this, "密码错误",Toast.LENGTH_SHORT).show();
                    break;
                }
            }
            else
            {
                isname=false;
            }
        }
        if(!isname)
        {
            btnMainInsertData_Click();
            saveProUserInfo(this,userID,name,password);
            Toast.makeText(MainActivity.this, "注册成功",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,UserActivity.class);
            MainActivity.this.startActivity(intent);
            finish();
        }

    }

    public void btnMainInsertData_Click()
    {
        ContentValues cv = new ContentValues();
        cv.put("UserName", name);
        cv.put("UserPwd",password);
        db.getWritableDatabase().insert("Student", null, cv);
        dbo = db.getWritableDatabase();
        String strSql = "select * from Student where UserName = '"+name+"' and UserPwd = '"+password+"'";
        Cursor cursor;
        cursor = dbo.rawQuery(strSql,null);
        if(cursor.moveToNext())
        {
            userID = cursor.getInt(cursor.getColumnIndex("UserID"));
        }
    }

    // 删除数据1
    public void btnMainDeleteData1_Click(View view)
    {
        SQLiteDatabase dbo = db.getWritableDatabase();
        String strSql = "";

        strSql = "delete from Student where ID='101'";
        dbo.execSQL(strSql);

    }

    // 删除数据1
    public void btnMainDeleteData2_Click(View view)
    {
        SQLiteDatabase dbo = db.getWritableDatabase();
        String strSql = "";

        strSql = "delete from Student where ID='102'";
        dbo.execSQL(strSql);

    }

    // 显示数据
    public void btnMainShowData_Click(View view)
    {
        SQLiteDatabase dbo = db.getWritableDatabase();
        String strSql = "";
        strSql = "select * from Student";
        Cursor cursor;
        cursor = dbo.rawQuery(strSql,null);

        String strTemp = "";

        while (cursor.moveToNext())
        {
            String strID = "";
            String strName = "";
            strID = cursor.getString(cursor.getColumnIndex("ID"));
            strName = cursor.getString(cursor.getColumnIndex("Name"));

            if (strTemp == "")
            {
                strTemp = "[" + strID + "," + strName + "]";
            }
            else
            {
                strTemp += ",[" + strID + "," + strName + "]";
            }
        }

        tvMainInfo.setText(strTemp);
    }

    /**
     * 使用属性文件保存用户的信息
     *
     * @param con 上下文
     * @param userID 用户编号
     * @param username 用户名
     * @param password  密码
     * @return
     */
    public static boolean saveProUserInfo(Context con, int userID, String username,
                                          String password) {
        try {
            context = con;
            SharedPreferences myPreferences = con.getSharedPreferences("user_info", Activity.MODE_PRIVATE);
            SharedPreferences.Editor editor = myPreferences.edit();
            editor.putString("userID", String.valueOf(userID));
            editor.putString("username", username);
            editor.putString("password", password);
            editor.commit();
            return true;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public void oldUserLogin()
    {
        SharedPreferences myPreferences = getSharedPreferences("user_info", Activity.MODE_PRIVATE);
        // 获取用户名或密码
        if (null != myPreferences) {
            String strname=myPreferences.getString("username","");
            String strpwd=myPreferences.getString("password","");
            // 如果获取到的用户名或密码不为空，则设置到文本框中
            if (!TextUtils.isEmpty(strname) && !TextUtils.isEmpty(strpwd)) {
                // 设置用户名
                username.setText(strname);
                // 设置密码
                pwd.setText(strpwd);
                Bundle bundle = this.getIntent().getExtras();
                if(bundle==null)
                {
                    Toast.makeText(MainActivity.this, "登陆成功",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,UserActivity.class);
                    MainActivity.this.startActivity(intent);
                    finish();
                }
            }
        }
    }
}
