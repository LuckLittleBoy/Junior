package com.stu.mybook;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotesManage extends Fragment {
    private ListView listView;
    private List<Map<String,String>> data;
    private DB db;
    private String userID;
    private Button btnUserNotes;
    private int MID;
    private NotesAdapter notesAdapter;

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        MID = (int)info.id;
        Log.d("db","onContextItemSelected");

        switch (item.getItemId())
        {
            case 0:
                Log.d("db", String.valueOf(MID));
                String userID=data.get(MID).get("userID");
                String bookID=data.get(MID).get("bookID");
                String sql="delete from Notes where UserID='"+userID+"' and BookID='"+bookID+"'";
                db.getWritableDatabase().execSQL(sql);
                notesAdapter.remove(MID);
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("db","onCreateView");

        db = new DB(getActivity(),"dbStudentMis.db",null,1);
        db.getReadableDatabase();

        View view = inflater.inflate(R.layout.view4,null);
        listView = (ListView) view.findViewById(R.id.notesList);
        registerForContextMenu(listView);
        btnUserNotes = (Button) view.findViewById(R.id.btnUserNotes);
        btnUserNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),UserNotesActivity.class);
                startActivity(intent);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String userID = data.get(position).get("userID");
                String bookID = data.get(position).get("bookID");
                Intent intent = new Intent(getActivity().getApplicationContext(),LookNotesActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("userID",userID);
                bundle.putString("bookID",bookID);
                intent.putExtras(bundle);
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
        SharedPreferences myPreferences = getActivity().getSharedPreferences("user_info", Activity.MODE_PRIVATE);
        // 获取用户名或密码
        if (null != myPreferences) {
            userID = myPreferences.getString("userID","");
        }
        fillData();
        notesAdapter = new NotesAdapter(getActivity(),data);
        listView.setAdapter(notesAdapter);
    }

    public void fillData()
    {
        data = new ArrayList<Map<String, String>>();

        String sql="select BookID, COUNT(*) as notes from Notes where UserID = "+ userID + " group by BookID";

        try {
            Cursor cursor = db.getReadableDatabase().rawQuery(sql,null);
            while (cursor.moveToNext())
            {
                Map<String,String> note = new HashMap<String,String>();
                note.put("userID",userID);
                String bookID = cursor.getString(cursor.getColumnIndex("BookID"));
                note.put("bookID",bookID);
                String bookName = GetBookName(bookID);
                note.put("bookName",bookName);
                note.put("bookNotes",cursor.getString(cursor.getColumnIndex("notes")));
                data.add(note);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String GetBookName(String bookID)
    {
        String sql="select BookName from Book where BookID = " + bookID;
        String bookName="";
        try {
            Cursor cursor = db.getReadableDatabase().rawQuery(sql,null);
            if (cursor.moveToNext())
            {
                bookName = cursor.getString(cursor.getColumnIndex("BookName"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookName;
    }
}
