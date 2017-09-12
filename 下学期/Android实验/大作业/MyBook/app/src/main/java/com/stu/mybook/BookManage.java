package com.stu.mybook;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
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


public class BookManage extends Fragment {
    private ListView listView;
    private List<Map<String,String>> data;
    private DB db;
    private Button btnAddBook;
    private int MID;
    private BookAdapter bookAdapter;

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
                String sql="delete from Book where BookID='"+id+"'";
                db.getWritableDatabase().execSQL(sql);
                bookAdapter.remove(MID);
                break;
            case 1:
                Log.d("db",String.valueOf(MID));
                Intent intent = new Intent(getActivity().getApplicationContext(),UpdateBookActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("id",data.get(MID).get("id"));
                bundle.putString("name",data.get(MID).get("name"));
                bundle.putString("author",data.get(MID).get("author"));
                bundle.putString("press",data.get(MID).get("press"));
                bundle.putString("isbn",data.get(MID).get("isbn"));
                bundle.putString("classify",data.get(MID).get("classify"));
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case 2:
                Log.d("db",String.valueOf(MID));
                String press = data.get(MID).get("press");
                String isbn = data.get(MID).get("isbn");
                String classify = data.get(MID).get("classify");
                String msg = "出版社："+press+"\n"+"ISBN："+isbn+"\n"+"图书类别："+classify;
                new AlertDialog.Builder(getActivity()).setTitle("详细信息")//设置对话框标题
                        .setMessage(msg)
                        .setPositiveButton("确定",new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).show();
                break;
            case 3:
                Intent intent1 = new Intent(getActivity().getApplicationContext(),AddNotesActivity.class);
                Bundle bundle1 = new Bundle();
                bundle1.putString("bookID",data.get(MID).get("id"));
                intent1.putExtras(bundle1);
                startActivity(intent1);
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

        View view = inflater.inflate(R.layout.view2,null);
        listView = (ListView) view.findViewById(R.id.bookList);
        registerForContextMenu(listView);
        btnAddBook = (Button) view.findViewById(R.id.btnAddBook);
        btnAddBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(),AddBookActivity.class);
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
                        contextMenu.add(0, 2, 0, "详情");
                        contextMenu.add(0, 3, 0, "添加笔记");
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
        bookAdapter = new BookAdapter(getActivity(),data);
        listView.setAdapter(bookAdapter);
    }

    public void fillData()
    {
        data = new ArrayList<Map<String, String>>();

        String sql="select * from Book";

        try {
            Cursor cursor = db.getReadableDatabase().rawQuery(sql,null);
            while (cursor.moveToNext())
            {
                Map<String,String> book = new HashMap<String,String>();
                Log.d("BookManage",cursor.getString(cursor.getColumnIndex("BookID")));
                book.put("id",cursor.getString(cursor.getColumnIndex("BookID")));
                book.put("name",cursor.getString(cursor.getColumnIndex("BookName")));
                book.put("author",cursor.getString(cursor.getColumnIndex("BookAuthor")));
                book.put("press",cursor.getString(cursor.getColumnIndex("BookPress")));
                book.put("isbn",cursor.getString(cursor.getColumnIndex("BookISBN")));
                book.put("classify",cursor.getString(cursor.getColumnIndex("BookClassify")));
                data.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
