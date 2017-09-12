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
 * Created by 孟 on 2017/4/10.
 */

public class UpdateNotesActivity extends BaseActivity {
    private EditText etUpdateNotes;
    private Toolbar toolbar;
    private int userID;
    private int bookID;
    private String noteContent;
    private DB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updatenotes_layout);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupBackAsUp("更新笔记");
        etUpdateNotes = (EditText) findViewById(R.id.etUpdateNotes);

        db = new DB(this, "dbStudentMis.db", null, 1);

        Bundle bundle = this.getIntent().getExtras();

        userID = Integer.valueOf(bundle.getString("userID"));
        bookID = Integer.valueOf(bundle.getString("bookID"));
        noteContent = bundle.getString("lnContent");

        etUpdateNotes.setText(noteContent);
    }

    public void btnUpdateNotesTrue_Click(View v) {
        String content = etUpdateNotes.getText().toString();
        if(content.equals("")||content==null)
        {
            Toast.makeText(UpdateNotesActivity.this,"笔记内容输入为空！",Toast.LENGTH_SHORT).show();
        }
        else
        {
            String sql = "update Notes set NoteContent='" + content
                    + "' where UserID = " + userID + " and BookID = " + bookID;
            db.getWritableDatabase().execSQL(sql);
            Toast.makeText(UpdateNotesActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(UpdateNotesActivity.this, LookNotesActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("index", "3");
            intent.putExtras(bundle);
            startActivity(intent);
            finish();
        }
    }
}

