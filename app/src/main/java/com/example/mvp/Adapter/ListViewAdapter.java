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
public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.InnerHolder> {
    private ArrayList mData ;

    public ListViewAdapter(ArrayList<ItemBean> data){
        mData = data;
    }

    // 这个方法用于创建条目item
    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //传进去的view为item的布局
        View view = View.inflate(parent.getContext(), R.layout.item_list_view, null);
        return new InnerHolder(view);
    }

    //一般用来绑定holder， 设置数据绑定
    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
            holder.setData((ItemBean) mData.get(position));
    }

    //返回数据条目
    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        private TextView mText;
        private ImageView mImageView;

        //绑定item布局
        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            mText = itemView.findViewById(R.id.item_listView_text);
            mImageView = itemView.findViewById(R.id.item_listView_image);
        }


        public void setData(ItemBean o) {
            mText.setText(o.getTitle());
            Picasso.get()
                    .load(o.getEnvelopePic())
                    .placeholder(R.color.white)
                    .error(R.color.black)
                    .into(mImageView);
        }
    }
}
