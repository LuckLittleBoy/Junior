package com.stu.mybook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by 孟 on 2017/4/9.
 */

public class ClassifyAdapter extends BaseAdapter {

    private TextView classifyIdView;
    private TextView classifyNameView;
    private List<Map<String,String>> data;
    private Context context;
    public ClassifyAdapter()
    {
        super();
    }
    public ClassifyAdapter(Context context, List<Map<String,String>> data)
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
            view1 = layoutInflater.inflate(R.layout.classifytable_layout,viewGroup,false);
        }
        else
        {
            view1=view;
        }
        classifyIdView = (TextView) view1.findViewById(R.id.classifyId);
        classifyNameView = (TextView) view1.findViewById(R.id.classifyName);

        classifyIdView.setText(data.get(i).get("id"));
        classifyNameView.setText(data.get(i).get("name"));

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
