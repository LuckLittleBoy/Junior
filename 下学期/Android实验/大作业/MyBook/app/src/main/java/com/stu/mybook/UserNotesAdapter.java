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
 * Created by 孟 on 2017/4/11.
 */

public class UserNotesAdapter extends BaseAdapter{
    private TextView unID;
    private TextView unName;
    private TextView unNumber;
    private List<Map<String,String>> data;
    private Context context;
    public UserNotesAdapter()
    {
        super();
    }
    public UserNotesAdapter(Context context, List<Map<String,String>> data)
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
            view1 = layoutInflater.inflate(R.layout.usernotestable_layout,viewGroup,false);
        }
        else
        {
            view1=view;
        }
        unID = (TextView) view1.findViewById(R.id.unID);
        unName = (TextView) view1.findViewById(R.id.unName);
        unNumber = (TextView) view1.findViewById(R.id.unNumber);

        unID.setText(data.get(i).get("unID"));
        unName.setText(data.get(i).get("unName"));
        unNumber.setText(data.get(i).get("unNumber"));
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
