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

/**
 * Created by Administrator on 2017/4/3 0003.
 */

public class BookClassifyManage extends Fragment {

    private ListView listView;
    private List<Map<String,String>> data;
    private DB db;

    private Button btnAddClassify;
    private int MID;
    private ClassifyAdapter classifyAdapter;

    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        MID = (int)info.id;
        Log.d("db","onContextItemSelected");
        switch (item.getItemId())
        {
            case 0:
                Log.d("db", String.valueOf(MID));
                String id=data.get(MID).get("id");
                String name=data.get(MID).get("name");
                String strsql = "select COUNT(*) from Book where BookClassify = '"+name+"'";
                Cursor cursor = db.getWritableDatabase().rawQuery(strsql,null);
                if(cursor.moveToNext()) {
                    String msg = "该分类下已有图书，无法删除！";
                    new AlertDialog.Builder(getActivity()).setTitle("警告")//设置对话框标题
                            .setMessage(msg)
                            .setPositiveButton("确定",new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            }).show();
                }
                else {
                    String sql = "delete from BookClassify where ClassifyID='" + id + "'";
                    db.getWritableDatabase().execSQL(sql);
                    classifyAdapter.remove(MID);
                }
                break;
            case 1:
                Log.d("db",String.valueOf(MID));
                Intent intent = new Intent(getActivity().getApplicationContext(),UpdateClassifyActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("id",data.get(MID).get("id"));
                bundle.putString("name",data.get(MID).get("name"));
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("db","onCreateView");

        db = new DB(getActivity(),"dbStudentMis.db",null,1);
        db.getReadableDatabase();

        View view = inflater.inflate(R.layout.view3,null);
        listView = (ListView) view.findViewById(R.id.classifyList);
        registerForContextMenu(listView);
        btnAddClassify = (Button) view.findViewById(R.id.btnAddBookClassify);
        btnAddClassify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(),AddClassifyActivity.class);
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
        classifyAdapter = new ClassifyAdapter(getActivity(),data);
        listView.setAdapter(classifyAdapter);
    }

    public void fillData()
    {
        data = new ArrayList<Map<String, String>>();

        String sql="select * from BookClassify";

        try {
            Cursor cursor = db.getReadableDatabase().rawQuery(sql,null);
            while (cursor.moveToNext())
            {
                Map<String,String> user = new HashMap<String,String>();
                user.put("id",cursor.getString(cursor.getColumnIndex("ClassifyID")));
                user.put("name",cursor.getString(cursor.getColumnIndex("ClassifyName")));
                data.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
