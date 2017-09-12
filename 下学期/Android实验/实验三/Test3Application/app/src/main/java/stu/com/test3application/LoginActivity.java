package stu.com.test3application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void button_Click(View view)
    {
        EditText editText = (EditText) findViewById(R.id.editText);
        String student_Id = editText.getText().toString();
        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("student_Id",student_Id);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }
}
