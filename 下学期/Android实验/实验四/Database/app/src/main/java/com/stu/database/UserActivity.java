package com.stu.database;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserActivity extends AppCompatActivity
{
    private ListView userList;
    private MyAdapter myAdapter;
    private List<Map<String,String>> data;
    private DB db;

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        int MID = (int)info.id;
        switch (item.getItemId())
        {
            case 0:
                String id=data.get(MID).get("id");
                String sql="delete from User where UserID='"+id+"'";
                db.getWritableDatabase().execSQL(sql);
                myAdapter.remove(MID);
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userlist_layout);
        userList = (ListView)findViewById(R.id.userList);
        db = new DB(this,"dbUser.db",null,1);
        db.getReadableDatabase();
        fillData();
        myAdapter = new MyAdapter(this,data);
        userList.setAdapter(myAdapter);

        userList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                userList.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
                    @Override
                    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                        contextMenu.add(0, 0, 0, "删除");
                    }
                });
                return false;
            }
        });
    }

    public void fillData()
    {
        data = new ArrayList<Map<String, String>>();

        String sql="select * from User";

        try {
            Cursor cursor = db.getReadableDatabase().rawQuery(sql,null);
            while (cursor.moveToNext())
            {
                Map<String,String> user = new HashMap<String,String>();
                user.put("id",cursor.getString(cursor.getColumnIndex("UserID")));
                user.put("name",cursor.getString(cursor.getColumnIndex("UserName")));
                user.put("hobby",cursor.getString(cursor.getColumnIndex("UserHobby")));
                data.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnReturn_Click(View view)
    {
        finish();
    }
}