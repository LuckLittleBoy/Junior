package com.stu.mybook;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Properties;

/**
 * Created by 孟 on 2017/4/6.
 */

public class Welcome extends Fragment {

    private TextView tvHello;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content,null);
        tvHello = (TextView)view.findViewById(R.id.tvHello);
        initHello();
        return view;
    }

    public void initHello()
    {
        String strname=null;
        SharedPreferences myPreferences = getActivity().getSharedPreferences("user_info", Activity.MODE_PRIVATE);
        // 获取用户名或密码
        if (null != myPreferences) {
            strname = myPreferences.getString("username", "");
        }
        Calendar c = Calendar.getInstance();
        int apm = c.get(Calendar.AM_PM);
        if(apm==0)
        {
            tvHello.setText("上午好！"+strname);
        }
        if(apm==1)
        {
            tvHello.setText("下午好！"+strname);
        }

    }
}
