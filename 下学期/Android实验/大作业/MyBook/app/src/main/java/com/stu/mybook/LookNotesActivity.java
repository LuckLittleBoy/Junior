package com.stu.mybook;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 孟 on 2017/4/11.
 */

public class LookNotesActivity extends BaseActivity {

    private ListView listView;
    private Toolbar toolbar;
    private List<Map<String,String>> data;
    private DB db;
    private LookNotesAdapter lookNotesAdapter;
    private int MID;

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
                String lnDate=data.get(MID).get("lnDate");
                String sql="delete from Notes where UserID='"+userID
                        +"' and BookID='"+bookID+"' and NoteDate='"+lnDate+"'";
                db.getWritableDatabase().execSQL(sql);
                lookNotesAdapter.remove(MID);
                break;
            case 1:
                Log.d("db",String.valueOf(MID));
                Intent intent = new Intent(LookNotesActivity.this,UpdateNotesActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("userID",data.get(MID).get("userID"));
                bundle.putString("bookID",data.get(MID).get("bookID"));
                bundle.putString("lnContent",data.get(MID).get("lnContent"));
                intent.putExtras(bundle);
                startActivity(intent);
                break;

        }
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.looknotes_layout);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupBackAsUp("查看笔记");
        listView = (ListView)findViewById(R.id.looknotesList);
        registerForContextMenu(listView);
        db = new DB(this,"dbStudentMis.db",null,1);
        fillData();
        lookNotesAdapter = new LookNotesAdapter(this,data);
        listView.setAdapter(lookNotesAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(LookNotesActivity.this,LookNoteContentActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("lnContent",data.get(position).get("lnContent"));
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
                        contextMenu.add(0, 1, 0, "修改");
                    }
                });
                return false;
            }
        });
    }
    public void fillData()
    {
        Bundle bundle = this.getIntent().getExtras();

        String userID =bundle.getString("userID");
        String bookID =bundle.getString("bookID");

        data = new ArrayList<Map<String, String>>();

        String sql="select * from Notes where UserID = "+ userID + " and BookID = "+ bookID;

        try {
            Cursor cursor = db.getReadableDatabase().rawQuery(sql,null);
            while (cursor.moveToNext())
            {
                Map<String,String> note = new HashMap<String,String>();
                note.put("userID",userID);
                note.put("bookID",bookID);
                note.put("lnDate",cursor.getString(cursor.getColumnIndex("NoteDate")));
                note.put("lnContent",cursor.getString(cursor.getColumnIndex("NoteContent")));
                data.add(note);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
