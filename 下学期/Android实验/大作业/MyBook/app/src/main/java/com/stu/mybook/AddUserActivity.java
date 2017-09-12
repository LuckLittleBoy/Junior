package com.stu.mybook;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddUserActivity extends BaseActivity {
    private EditText etUsername;
    private EditText etPassword;
    private Toolbar toolbar;
    private DB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adduser_layout);
        db = new DB(this,"dbStudentMis.db",null,1);
        etUsername = (EditText)findViewById(R.id.etName);
        etPassword =(EditText)findViewById(R.id.etPassword);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupBackAsUp("添加用户");
    }

    public void btnAdd_Click(View v)
    {
        String strEtName = etUsername.getText().toString().trim();
        String strEtPassword =etPassword.getText().toString().trim();

        if(strEtName.equals("")||strEtName==null)
        {
            Toast.makeText(AddUserActivity.this,"用户姓名输入为空！",Toast.LENGTH_SHORT).show();
        }
        else if(strEtPassword.equals("")||strEtPassword==null)
        {
            Toast.makeText(AddUserActivity.this,"用户密码输入为空！",Toast.LENGTH_SHORT).show();
        }
        else
        {
            ContentValues contentValues = new ContentValues();
            contentValues.put("UserName",strEtName);
            contentValues.put("UserPwd",strEtPassword);
            db.getWritableDatabase().insert("Student",null,contentValues);
            Toast.makeText(AddUserActivity.this,"增加成功",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(AddUserActivity.this,UserActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("index","0");
            intent.putExtras(bundle);
            startActivity(intent);
            finish();
        }
    }
}
