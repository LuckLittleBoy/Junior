package com.stu.database;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by 孟 on 2017/4/7.
 */

class MyAdapter extends BaseAdapter
{
    private TextView tbIdView;
    private TextView tbNameView;
    private TextView tbHobbyView;
    private List<Map<String,String>> data;
    private Context context;
    public MyAdapter()
    {
        super();
    }
    public MyAdapter(Context context, List<Map<String,String>> data)
    {
        this.context = context;
        this.data = data;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1=null;
        if(view1==null)
        {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            view1 = layoutInflater.inflate(R.layout.usertable_layout,viewGroup,false);
        }
        else
        {
            view1=view;
        }
        tbIdView = (TextView) view1.findViewById(R.id.tbId);
        tbNameView = (TextView) view1.findViewById(R.id.tbName);
        tbHobbyView = (TextView) view1.findViewById(R.id.tbHobby);

        tbIdView.setText(data.get(i).get("id"));
        tbNameView.setText(data.get(i).get("name"));
        tbHobbyView.setText(data.get(i).get("hobby"));
        return view1;
    }
    public void remove(int position)
    {
        data.remove(position);
        this.notifyDataSetChanged();
    }
    public void UpdateAdapter()
    {
        this.notifyDataSetChanged();
    }
}
