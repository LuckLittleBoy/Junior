package com.stu.mybook;

import android.app.Activity;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 孟 on 2017/4/11.
 */

public class UserNotesActivity extends BaseActivity {

    private ListView listView;
    private Toolbar toolbar;
    private List<Map<String,String>> data;
    private DB db;
    private String userID;
    private UserNotesAdapter userNotesAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usernotes_layout);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupBackAsUp("笔记详情");
        listView = (ListView)findViewById(R.id.usernotesList);
        registerForContextMenu(listView);
        db = new DB(this,"dbStudentMis.db",null,1);
        SharedPreferences myPreferences = getSharedPreferences("user_info", Activity.MODE_PRIVATE);
        // 获取用户名或密码
        if (null != myPreferences) {
            userID = myPreferences.getString("userID","");
        }
        fillData();
        userNotesAdapter = new UserNotesAdapter(this,data);
        listView.setAdapter(userNotesAdapter);
    }

    public void fillData()
    {
        data = new ArrayList<Map<String, String>>();

        String sql="select UserID,COUNT(*) as num from Notes where UserID = "+userID;

        try {
            Cursor cursor = db.getReadableDatabase().rawQuery(sql,null);
            while (cursor.moveToNext())
            {
                Map<String,String> note = new HashMap<String,String>();
                String userID = cursor.getString(cursor.getColumnIndex("UserID"));
                note.put("unID",userID);
                String userName = GetUserName(userID);
                note.put("unName",userName);
                note.put("unNumber",cursor.getString(cursor.getColumnIndex("num")));
                data.add(note);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String GetUserName(String userID)
    {
        String sql="select UserName from Student where UserID = " + userID;
        String userName="";
        try {
            Cursor cursor = db.getReadableDatabase().rawQuery(sql,null);
            if (cursor.moveToNext())
            {
                userName = cursor.getString(cursor.getColumnIndex("UserName"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userName;
    }
}
