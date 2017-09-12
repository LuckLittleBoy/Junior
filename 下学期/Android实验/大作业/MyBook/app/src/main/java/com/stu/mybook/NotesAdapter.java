package com.stu.mybook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class NotesAdapter extends BaseAdapter {

    private TextView tbBookID;
    private TextView tbBookName;
    private TextView tbBookNotes;
    private List<Map<String,String>> data;
    private Context context;
    public NotesAdapter()
    {
        super();
    }
    public NotesAdapter(Context context, List<Map<String,String>> data)
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
            view1 = layoutInflater.inflate(R.layout.notestable_layout,viewGroup,false);
        }
        else
        {
            view1=view;
        }
        tbBookName = (TextView) view1.findViewById(R.id.ntbookName);
        tbBookID = (TextView) view1.findViewById(R.id.ntbookID);
        tbBookNotes = (TextView) view1.findViewById(R.id.ntbookNotes);

        tbBookName.setText(data.get(i).get("bookName"));
        tbBookID.setText(data.get(i).get("bookID"));
        tbBookNotes.setText(data.get(i).get("bookNotes"));
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
