package com.stu.mybook;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/3 0003.
 */

public class UserManage extends Fragment {
    private ListView listView;
    private List<Map<String,String>> data;
    private DB db;

    private Button btnAddUser;
    private int MID;
    private MyAdapter myadapter;

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        MID = (int)info.id;
        Log.d("db","onContextItemSelected");
        switch (item.getItemId())
        {
            case 0:
                Log.d("db", String.valueOf(MID));
                String id=data.get(MID).get("id");
                String sql="delete from Student where UserID='"+id+"'";
                db.getWritableDatabase().execSQL(sql);
                myadapter.remove(MID);
                break;
            case 1:
                Log.d("db",String.valueOf(MID));
                Intent intent = new Intent(getActivity().getApplicationContext(),UpdateUserActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("id",data.get(MID).get("id"));
                bundle.putString("name",data.get(MID).get("name"));
                bundle.putString("password",data.get(MID).get("password"));

                intent.putExtras(bundle);
                startActivity(intent);
                break;

        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        Log.d("db","onCreateView");

        db = new DB(getActivity(),"dbStudentMis.db",null,1);
        db.getReadableDatabase();

        View view = inflater.inflate(R.layout.view1,null);
        listView = (ListView) view.findViewById(R.id.userList);
        registerForContextMenu(listView);
        btnAddUser = (Button) view.findViewById(R.id.btnAddUser);
        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(),AddUserActivity.class);
                startActivity(intent);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                listView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
                    @Override
                    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                        contextMenu.add(0, 0, 0, "删除");
                        contextMenu.add(0, 1, 0, "修改");
                    }
                });
                return false;
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("db","onActivityCreated");
        fillData();
        myadapter = new MyAdapter(getActivity(),data);
        listView.setAdapter(myadapter);
    }

    public void fillData()
    {
        data = new ArrayList<Map<String, String>>();

        String sql="select * from Student";

        try {
            Cursor cursor = db.getReadableDatabase().rawQuery(sql,null);
            while (cursor.moveToNext())
            {
                Map<String,String> user = new HashMap<String,String>();
                Log.d("UserManage",cursor.getString(cursor.getColumnIndex("UserID")));
                user.put("id",cursor.getString(cursor.getColumnIndex("UserID")));
                user.put("name",cursor.getString(cursor.getColumnIndex("UserName")));
                user.put("password",cursor.getString(cursor.getColumnIndex("UserPwd")));
                data.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}