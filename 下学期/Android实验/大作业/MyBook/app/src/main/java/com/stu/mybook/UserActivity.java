package com.stu.mybook;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.v4.widget.DrawerLayout;
import android.widget.Toast;

public class UserActivity extends AppCompatActivity
{
    private Toolbar toolbar;
    private ActionBarDrawerToggle mDrawerToggle;
    private String[] mPlanetTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private Fragment[] fragments={new UserManage(),new BookManage(),new BookClassifyManage(),new NotesManage()};
    private FragmentManager fragmentManager;
    private Fragment maincontent;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_layout);
        ExitApplication.getInstance().addActivity(this);
        findView();
        setDefaultFragment();
        initToolbar();
        initListView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymain, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final int id = item.getItemId();

        if (id == R.id.calendar)
        {
            Toast.makeText(UserActivity.this,"User",Toast.LENGTH_SHORT).show();
            return true;
        }
        else if(id == R.id.about)
        {
            String msg = "开发人：孟祥通\n当前版本：v1.0\n联系方式：15227196900";
            new AlertDialog.Builder(UserActivity.this).setTitle("软件信息")//设置对话框标题
                    .setMessage(msg)
                    .setPositiveButton("确定",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).show();
            return true;
        }
        else if(id == R.id.action_settings)
        {
            ExitApplication.getInstance().exit();
            return true;
        }
        else if(id == R.id.exit)
        {
            new AlertDialog.Builder(UserActivity.this).setTitle("账号切换")//设置对话框标题
                    .setMessage("确认退出该账号?")
                    .setNegativeButton("取消",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .setPositiveButton("确定",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(UserActivity.this,MainActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("exit","0");
                            intent.putExtras(bundle);
                            startActivity(intent);
                            finish();
                        }
                    }).show();
            return true;
        }
        else{}
        return super.onOptionsItemSelected(item);
    }
    public boolean onMenuItemClick(MenuItem item) {
        return true;
    }
    private  void findView()
    {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        fragmentManager = getSupportFragmentManager();
    }
    private void setDefaultFragment()
    {
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        int index;
        Bundle bundle = this.getIntent().getExtras();
        if(bundle==null)
        {
            maincontent = new Welcome();
        }
        else {
            index = Integer.valueOf(bundle.getString("index"));
            maincontent = fragments[index];
        }
        transaction.replace(R.id.content_frame,maincontent);
        transaction.commit();
    }
    private void initToolbar()
    {
        toolbar.setTitle("MyBook");//设置Toolbar标题
        toolbar.setTitleTextColor(Color.parseColor("#ffffff")); //设置标题颜色
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //创建返回键，并实现打开关/闭监听
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }
    private void initListView()
    {
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        mPlanetTitles = getResources().getStringArray(R.array.item_array);

        mDrawerList.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, mPlanetTitles));

        mDrawerList.setOnItemClickListener(new OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id)
            {
                FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_frame,fragments[position]);
                fragmentTransaction.commit();
                mDrawerLayout.closeDrawer(mDrawerList);
            }
        });
    }
}