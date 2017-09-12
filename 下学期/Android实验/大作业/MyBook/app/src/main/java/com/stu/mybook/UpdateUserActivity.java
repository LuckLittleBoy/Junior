package com.stu.mybook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/4/5 0005.
 */

public class UpdateUserActivity extends BaseActivity {
    private  EditText etUserName;
    private EditText etUserPassword;
    private Toolbar toolbar;
    private int id;
    private String name;
    private String password;
    private DB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updateuser_layout);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupBackAsUp("更新用户");
        etUserName =(EditText)findViewById(R.id.updateUserName);
        etUserPassword =(EditText)findViewById(R.id.updateUserPassword);

        db = new DB(this,"dbStudentMis.db",null,1);

        Bundle bundle = this.getIntent().getExtras();

        id=Integer.valueOf(bundle.getString("id"));
        Log.d("update",String.valueOf(id));
        name=bundle.getString("name");
        password =bundle.getString("password");

        etUserName.setText(name);
        etUserPassword.setText(password);

    }
    public void btn_updateUser(View v)
    {
        String name1=etUserName.getText().toString();
        String password1 = etUserPassword.getText().toString();
        if(name1.equals("")||name1==null)
        {
            Toast.makeText(UpdateUserActivity.this,"用户姓名输入为空！",Toast.LENGTH_SHORT).show();
        }
        else if(password1.equals("")||password1==null)
        {
            Toast.makeText(UpdateUserActivity.this,"用户密码输入为空！",Toast.LENGTH_SHORT).show();
        }
        else
        {
            String sql = "update Student set UserName='" + name1 + "',UserPwd='" + password1 + "' where UserID = " + id;
            db.getWritableDatabase().execSQL(sql);
            Toast.makeText(UpdateUserActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(UpdateUserActivity.this, UserActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("index", "0");
            intent.putExtras(bundle);
            startActivity(intent);
            finish();
        }
    }
}
