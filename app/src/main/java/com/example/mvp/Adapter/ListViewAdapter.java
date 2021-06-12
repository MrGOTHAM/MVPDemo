package com.example.mvp.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvp.Bean.ItemBean;
import com.example.mvp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by 安 on 2021/6/8.
 * listView
 */
public class ListViewAdapter extends RecyclerViewBaseAdapter {

    public ListViewAdapter(ArrayList<ItemBean> data){
        super(data);
    }

    @Override
    View getSubView(ViewGroup parent, int viewType) {
        return View.inflate(parent.getContext(), R.layout.item_list_view, null);
    }

}
