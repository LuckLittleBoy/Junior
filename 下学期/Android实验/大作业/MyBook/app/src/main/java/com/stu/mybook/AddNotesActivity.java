package com.stu.mybook;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

/**
 * Created by 孟 on 2017/4/10.
 */

public class AddNotesActivity extends BaseActivity {

    private EditText etNotes;
    private Toolbar toolbar;
    private DB db;
    private String userID=null;
    private String bookID=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addnotes_layout);
        etNotes = (EditText)findViewById(R.id.etNotes);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupBackAsUp("添加笔记");
        db = new DB(this,"dbStudentMis.db",null,1);

        SharedPreferences myPreferences = getSharedPreferences("user_info", Activity.MODE_PRIVATE);
        // 获取用户名或密码
        if (null != myPreferences) {
            userID = myPreferences.getString("userID","");
        }
        Bundle bundle = this.getIntent().getExtras();
        bookID = bundle.getString("bookID");
    }

    public void btnAddNotesTrue_Click(View v)
    {
        String strEtNotes = etNotes.getText().toString().trim();

        if(strEtNotes.equals("")||strEtNotes==null)
        {
            Toast.makeText(AddNotesActivity.this,"笔记内容输入为空！",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Log.d("note","success");

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            Date curDate = new Date(System.currentTimeMillis());
            String date = formatter.format(curDate);
            ContentValues contentValues = new ContentValues();
            contentValues.put("UserID",Integer.valueOf(userID));
            contentValues.put("BookID",Integer.valueOf(bookID));
            contentValues.put("NoteDate",date);
            contentValues.put("NoteContent",strEtNotes);
            db.getWritableDatabase().insert("Notes",null,contentValues);
            Toast.makeText(AddNotesActivity.this,"添加成功",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(AddNotesActivity.this,UserActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("index","1");
            intent.putExtras(bundle);
            startActivity(intent);
            finish();
        }
    }
}
