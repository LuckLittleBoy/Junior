package com.stu.mybook;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 孟 on 2017/4/8.
 */

public class UpdateBookActivity extends BaseActivity {
    private EditText etBookName;
    private EditText etAuthor;
    private EditText etPress;
    private EditText etISBN;
    private  Spinner snClassify;
    private Toolbar toolbar;
    private int bookid;
    private String bookname;
    private String author;
    private String press;
    private String isbn;
    private String classify;
    private DB db;
    private ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updatebook_layout);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupBackAsUp("更新书籍");
        etBookName =(EditText)findViewById(R.id.upBookName);
        etAuthor =(EditText)findViewById(R.id.upAuthor);
        etPress =(EditText)findViewById(R.id.upPress);
        etISBN =(EditText)findViewById(R.id.upISBN);
        snClassify =(Spinner)findViewById(R.id.upClassify);

        db = new DB(this,"dbStudentMis.db",null,1);

        Bundle bundle = this.getIntent().getExtras();

        bookid=Integer.valueOf(bundle.getString("id"));
        bookname=bundle.getString("name");
        author =bundle.getString("author");
        press =bundle.getString("press");
        isbn =bundle.getString("isbn");
        classify =bundle.getString("classify");

        etBookName.setText(bookname);
        etAuthor.setText(author);
        etPress.setText(press);
        etISBN.setText(isbn);
        arrayAdapter = new ArrayAdapter<String>(UpdateBookActivity.this,
                R.layout.support_simple_spinner_dropdown_item,getDataSource());
        snClassify.setAdapter(arrayAdapter);
        setSpinnerItemSelectedByValue(snClassify,classify);

    }
    public void btnUpdateBookSure_Click(View v)
    {
        String name=etBookName.getText().toString();
        String author = etAuthor.getText().toString();
        String press=etPress.getText().toString();
        String isbn = etISBN.getText().toString();
        String classify=snClassify.getSelectedItem().toString().trim();
        if(classify=="请选择")
        {
            classify="";
        }
        if(name.equals("")||name==null)
        {
            Toast.makeText(UpdateBookActivity.this,"图书名称输入为空！",Toast.LENGTH_SHORT).show();
        }
        else if(author.equals("")||author==null)
        {
            Toast.makeText(UpdateBookActivity.this,"作者输入为空！",Toast.LENGTH_SHORT).show();
        }
        else if(press.equals("")||press==null)
        {
            Toast.makeText(UpdateBookActivity.this,"出版社输入为空！",Toast.LENGTH_SHORT).show();
        }
        else if(isbn.equals("")||isbn==null)
        {
            Toast.makeText(UpdateBookActivity.this,"ISBN输入为空！",Toast.LENGTH_SHORT).show();
        }
        else
        {
            String sql = "update Book set BookName='" + name + "',BookAuthor='" + author + "',BookPress='"
                    + press + "',BookISBN='" + isbn + "',BookClassify='" + classify + "' where BookID = " + bookid;
            db.getWritableDatabase().execSQL(sql);
            Toast.makeText(UpdateBookActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(UpdateBookActivity.this, UserActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("index", "1");
            intent.putExtras(bundle);
            startActivity(intent);
            finish();
        }
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

    /**
     * 根据值, 设置spinner默认选中:
     * @param spinner
     * @param value
     */
    public static void setSpinnerItemSelectedByValue(Spinner spinner, String value){
        SpinnerAdapter apsAdapter= spinner.getAdapter(); //得到SpinnerAdapter对象
        int k= apsAdapter.getCount();
        for(int i=0;i<k;i++){
            if(value.equals(apsAdapter.getItem(i).toString())){
                spinner.setSelection(i,true);// 默认选中项
                break;
            }
        }
    }
}
