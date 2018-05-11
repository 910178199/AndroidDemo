package com.example.superman.expandabletextview;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;

import com.example.superman.expandabletextview.swipemenulistview.SwipeMenu;
import com.example.superman.expandabletextview.swipemenulistview.SwipeMenuCreator;
import com.example.superman.expandabletextview.swipemenulistview.SwipeMenuItem;
import com.example.superman.expandabletextview.swipemenulistview.SwipeMenuListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private List<String> strList;
    private MyAdapter myAdapter;


    RecyclerView main_rv;
    MainAdapter adapter;
    ArrayList<DataBean> models;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //新闻列表展开收起
        initExpandData();

        //ListView侧滑删除
        initSwipeMenu();
    }


    private void initSwipeMenu() {
        //侧滑删除
 /*       SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                SwipeMenuItem delItem = new SwipeMenuItem(getApplicationContext());
                delItem.setBackground(R.color.colorAccent);
                delItem.setWidth(dp2px(75));
//                delItem.setHeigh(dp2px(100));
                delItem.setTitle("删除");
                delItem.setTitleSize(14);
                delItem.setTitleColor(Color.WHITE);
                menu.addMenuItem(delItem);
            }
        };

        final SwipeMenuListView mListView = findViewById(R.id.listView);
        mListView.setMenuCreator(creator);
        mListView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public void onMenuItemClick(int position, SwipeMenu menu, int index) {
                Log.d(TAG, "onMenuItemClick: " + position);
                strList.remove(position);
                myAdapter.notifyDataSetChanged();
            }
        });

        strList = new ArrayList<>();
        strList.add("jsdfsdfsd");
        strList.add("jsdfsdfsd");
        strList.add("jsdfsdfsd");
        myAdapter = new MyAdapter(this, strList);
        mListView.setAdapter(myAdapter);*/

    }


    private void initExpandData() {
        models = new ArrayList<>();
        String[] arrays = getResources().getStringArray(R.array.news);
        for (String array : arrays) {
            DataBean bean = new DataBean();
            bean.setText(array);
            models.add(bean);
        }

        main_rv = (RecyclerView) findViewById(R.id.main_rv);
        main_rv.setHasFixedSize(true);
        main_rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MainAdapter(this, models);
        main_rv.setAdapter(adapter);
    }

    // 设置侧滑出来部分的宽度，否没有划出的效果
    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }
}
