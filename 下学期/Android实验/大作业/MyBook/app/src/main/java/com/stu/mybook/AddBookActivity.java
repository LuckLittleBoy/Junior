package com.stu.mybook;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 孟 on 2017/4/8.
 */

public class AddBookActivity extends BaseActivity {

    private Toolbar toolbar;
    private EditText etBookName;
    private EditText etAuthor;
    private EditText etPress;
    private EditText etISBN;
    private Spinner snClassify;
    private DB db;
    private ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addbook_layout);
        db = new DB(this,"dbStudentMis.db",null,1);
        findView();
        arrayAdapter = new ArrayAdapter<String>(AddBookActivity.this,
                R.layout.support_simple_spinner_dropdown_item,getDataSource());
        snClassify.setAdapter(arrayAdapter);
    }

    private  void findView()
    {
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupBackAsUp("添加书籍");
        etBookName = (EditText)findViewById(R.id.etBookName);
        etAuthor =(EditText)findViewById(R.id.etAuthor);
        etPress =(EditText)findViewById(R.id.etPress);
        etISBN =(EditText)findViewById(R.id.etISBN);
        snClassify =(Spinner)findViewById(R.id.snClassify);
    }

    public List<String> getDataSource()
    {
        List<String> list = new ArrayList<String>();
        list.add("请选择");
        String sql="select * from BookClassify";

        try {
            Cursor cursor = db.getReadableDatabase().rawQuery(sql,null);
            while (cursor.moveToNext())
            {
                list.add(cursor.getString(cursor.getColumnIndex("ClassifyName")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void btnAddBookSure_Click(View v)
    {
        String strEtBookName = etBookName.getText().toString().trim();
        String strEtAuthor =etAuthor.getText().toString().trim();
        String strEtPress = etPress.getText().toString().trim();
        String strEtISBN =etISBN.getText().toString().trim();
        boolean IsSelected = snClassify.isSelected();
        String strEtClassify = "";
        strEtClassify = snClassify.getSelectedItem().toString().trim();
        if(strEtClassify=="请选择")
        {
            strEtClassify="";
        }
        if(strEtBookName.equals("")||strEtBookName==null)
        {
            Toast.makeText(AddBookActivity.this,"图书名称输入为空！",Toast.LENGTH_SHORT).show();
        }
        else if(strEtAuthor.equals("")||strEtAuthor==null)
        {
            Toast.makeText(AddBookActivity.this,"作者输入为空！",Toast.LENGTH_SHORT).show();
        }
        else if(strEtPress.equals("")||strEtPress==null)
        {
            Toast.makeText(AddBookActivity.this,"出版社输入为空！",Toast.LENGTH_SHORT).show();
        }
        else if(strEtISBN.equals("")||strEtISBN==null)
        {
            Toast.makeText(AddBookActivity.this,"ISBN输入为空！",Toast.LENGTH_SHORT).show();
        }
        else
        {
            ContentValues contentValues = new ContentValues();
            contentValues.put("BookName",strEtBookName);
            contentValues.put("BookAuthor",strEtAuthor);
            contentValues.put("BookPress",strEtPress);
            contentValues.put("BookISBN",strEtISBN);
            contentValues.put("BookClassify",strEtClassify);
            db.getWritableDatabase().insert("Book",null,contentValues);
            Toast.makeText(AddBookActivity.this,"增加成功",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(AddBookActivity.this,UserActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("index","1");
            intent.putExtras(bundle);
            startActivity(intent);
            finish();
        }
    }
}
