package com.example.mvp.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.mvp.Adapter.GridViewAdapter;
import com.example.mvp.Adapter.ListViewAdapter;
import com.example.mvp.Bean.ItemBean;
import com.example.mvp.Presenter.GlidePresenter;
import com.example.mvp.R;
import java.util.ArrayList;

public class GlideActivity extends BaseActivity implements IView<ArrayList<ItemBean>>{

    RecyclerView mRecyclerView;
    GlidePresenter mGlidePresenter;
    ArrayList<ItemBean> mData ;
    private boolean isList = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);

        mRecyclerView = findViewById(R.id.recycler_view);
        mGlidePresenter = new GlidePresenter();
        mGlidePresenter.attachView(this);
        initData();

    }

    private void showListView(boolean isVertical) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(isVertical?RecyclerView.VERTICAL : RecyclerView.HORIZONTAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        ListViewAdapter listViewAdapter =new ListViewAdapter(mData);
        listViewAdapter.setOnClickListener(position -> Toast.makeText(getApplicationContext(),mData.get(position).getTitle(),Toast.LENGTH_LONG).show());
        mRecyclerView.setAdapter(listViewAdapter);
    }

    private void showGridView(boolean isVertical){
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        gridLayoutManager.setOrientation(isVertical?RecyclerView.VERTICAL : RecyclerView.HORIZONTAL);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        GridViewAdapter gridViewAdapter =new GridViewAdapter(mData);
        gridViewAdapter.setOnClickListener(position -> Toast.makeText(getApplicationContext(),mData.get(position).getTitle(),Toast.LENGTH_LONG).show());
        mRecyclerView.setAdapter(gridViewAdapter);
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
                showListView(true);
                break;
            case R.id.horizontal_listView:
                Toast.makeText(this, "this is " + item.getTitle(), Toast.LENGTH_LONG).show();
                showListView(false);
                break;

            //glideView
            case R.id.vertical_glideView:
                Toast.makeText(this, "this is " + item.getTitle(), Toast.LENGTH_LONG).show();
                showGridView(true);
                break;
            case R.id.horizontal_glideView:
                Toast.makeText(this, "this is " + item.getTitle(), Toast.LENGTH_LONG).show();
                showGridView(false);
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
    public void showData(ArrayList<ItemBean> data) {
        mData = data;
        showListView(true);
    }
}