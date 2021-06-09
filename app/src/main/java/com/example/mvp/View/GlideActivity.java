package com.example.mvp.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.mvp.Adapter.ListViewAdapter;
import com.example.mvp.Bean.ItemsBean;
import com.example.mvp.Bean.NewData;
import com.example.mvp.Presenter.GlidePresenter;
import com.example.mvp.R;

import java.util.ArrayList;

public class GlideActivity extends BaseActivity implements IView<ArrayList<NewData.DataBean.DatasBean>>{

    RecyclerView mRecyclerView;
    GlidePresenter mGlidePresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);

        mRecyclerView = findViewById(R.id.recycler_view);
        mGlidePresenter = new GlidePresenter();
        mGlidePresenter.attachView(this);
        initData();
    }

    public void initData(){
        mGlidePresenter.getData("0");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            // listView
            case R.id.vertical_listView:
                Toast.makeText(this, "this is " + item.getTitle(), Toast.LENGTH_LONG).show();
                break;
            case R.id.horizontal_listView:
                Toast.makeText(this, "this is " + item.getTitle(), Toast.LENGTH_LONG).show();
                break;

            //glideView
            case R.id.vertical_glideView:
                Toast.makeText(this, "this is " + item.getTitle(), Toast.LENGTH_LONG).show();
                break;
            case R.id.horizontal_glideView:
                Toast.makeText(this, "this is " + item.getTitle(), Toast.LENGTH_LONG).show();
                break;

            //staggerView
            case R.id.vertical_staggerView:
                Toast.makeText(this, "this is " + item.getTitle(), Toast.LENGTH_LONG).show();
                break;
            case R.id.horizontal_staggerView:
                Toast.makeText(this, "this is " + item.getTitle(), Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showData(ArrayList<NewData.DataBean.DatasBean> data) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        ListViewAdapter listViewAdapter =new ListViewAdapter(data);
        mRecyclerView.setAdapter(listViewAdapter);
    }
}