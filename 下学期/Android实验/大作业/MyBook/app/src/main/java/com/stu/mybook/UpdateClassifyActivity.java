package com.stu.mybook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by 孟 on 2017/4/9.
 */

public class UpdateClassifyActivity extends BaseActivity {
    private EditText etClassifyName;
    private Toolbar toolbar;
    private int id;
    private String classifyname;
    private DB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updateclassify_layout);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupBackAsUp("更新书籍分类");
        etClassifyName = (EditText) findViewById(R.id.updateClassifyName);

        db = new DB(this, "dbStudentMis.db", null, 1);

        Bundle bundle = this.getIntent().getExtras();

        id = Integer.valueOf(bundle.getString("id"));
        Log.d("update", String.valueOf(id));
        classifyname = bundle.getString("name");

        etClassifyName.setText(classifyname);
    }

    public void btn_updateClassify(View v) {
        String name = etClassifyName.getText().toString();
        if(name.equals("")||name==null)
        {
            Toast.makeText(UpdateClassifyActivity.this,"书籍类别输入为空！",Toast.LENGTH_SHORT).show();
        }
        else
        {
            String sql = "update BookClassify set ClassifyName='" + name + "' where ClassifyID = " + id;
            db.getWritableDatabase().execSQL(sql);
            Toast.makeText(UpdateClassifyActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(UpdateClassifyActivity.this, UserActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("index", "2");
            intent.putExtras(bundle);
            startActivity(intent);
            finish();
        }
    }
}
