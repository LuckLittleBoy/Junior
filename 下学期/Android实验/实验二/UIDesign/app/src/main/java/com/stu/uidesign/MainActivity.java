package com.stu.uidesign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private TextView tvTest;
    private ToggleButton tb;
    private RadioButton rb;
    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                String str=parent.getItemAtPosition(position).toString();
                tvTest.setText("测试Spinner:"+str);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

        RadioGroup group = (RadioGroup)findViewById(R.id.radioGroup);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                rb = (RadioButton)findViewById(radioButtonId);
                //更新文本内容，以符合选中项
                tvTest.setText("您的性别是：" + rb.getText());
            }
        });

        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked)
            {
                tb.setChecked(isChecked);
            }
        });
    }

    public void init()
    {
        tvTest = (TextView)findViewById(R.id.tvTest);
        tb = (ToggleButton)findViewById(R.id.btnTG);
        spinner = (Spinner)findViewById(R.id.btnSP);
    }

    public void btnTV_Click(View view)
    {
        tvTest.setText("测试TextView");
    }

    public void btnBtn_Click(View view)
    {
        tvTest.setText("测试Button");
    }

    public void btnLayout_Click(View view)
    {
        Intent intent = new Intent(MainActivity.this,LayoutActivity.class);
        startActivity(intent);
    }
}
