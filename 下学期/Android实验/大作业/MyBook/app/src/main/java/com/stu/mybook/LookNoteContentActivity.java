package com.stu.mybook;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.EditText;

/**
 * Created by 孟 on 2017/4/11.
 */

public class LookNoteContentActivity extends BaseActivity {

    private EditText etNoteContent;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notecontent_layout);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupBackAsUp("笔记内容");
        etNoteContent = (EditText) findViewById(R.id.etNoteContent);
        Bundle bundle = this.getIntent().getExtras();
        String content = bundle.getString("lnContent");
        Log.d("content",content);
        etNoteContent.setText("");
        etNoteContent.setText(content);
    }
}
