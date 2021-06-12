package com.example.mvp.Adapter;

import android.view.View;
import android.view.ViewGroup;
import com.example.mvp.Bean.ItemBean;
import com.example.mvp.R;
import java.util.ArrayList;

/**
 * Created by 安 on 2021/6/10.
 */
public class GridViewAdapter extends RecyclerViewBaseAdapter {

    public GridViewAdapter(ArrayList<ItemBean> data){
        super(data);
    }

    @Override
    View getSubView(ViewGroup parent, int viewType) {
        return View.inflate(parent.getContext(), R.layout.item_grid_view, null);
    }
}
