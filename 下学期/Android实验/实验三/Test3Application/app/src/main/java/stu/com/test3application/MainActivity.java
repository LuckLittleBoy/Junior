package stu.com.test3application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String student_Id = bundle.getString("student_Id");
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("学号:" + student_Id);
    }
}
