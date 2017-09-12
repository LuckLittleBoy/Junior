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

public class AddClassifyActivity extends BaseActivity {
    private EditText etClassifyName;
    private Toolbar toolbar;
    private DB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addclassify_layout);
        db = new DB(this,"dbStudentMis.db",null,1);
        etClassifyName = (EditText)findViewById(R.id.etClassifyName);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupBackAsUp("添加书籍分类");
    }

    public void btnAddClassifyTrue_Click(View v)
    {
        String strEtName = etClassifyName.getText().toString().trim();

        if(strEtName.equals("")||strEtName==null)
        {
            Toast.makeText(AddClassifyActivity.this,"书籍类别输入为空！",Toast.LENGTH_SHORT).show();
        }
        else
        {
            ContentValues contentValues = new ContentValues();
            contentValues.put("ClassifyName",strEtName);
            db.getWritableDatabase().insert("BookClassify",null,contentValues);
            Toast.makeText(AddClassifyActivity.this,"增加成功",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(AddClassifyActivity.this,UserActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("index","2");
            intent.putExtras(bundle);
            startActivity(intent);
            finish();
        }
    }
}
