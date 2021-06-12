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
 * Created by 安 on 2021/6/12.
 * RecyclerViewBaseAdapter
 */
public abstract class RecyclerViewBaseAdapter extends RecyclerView.Adapter<RecyclerViewBaseAdapter.InnerHolder> {
    private ArrayList mData;
    public OnItemClickListener mOnItemClickListener;

    public RecyclerViewBaseAdapter(ArrayList data) {
        mData = data;
    }

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = getSubView(parent, viewType);
        return new InnerHolder(view);
    }

    abstract View getSubView(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        holder.setData((ItemBean) mData.get(position));
        holder.itemView.setOnClickListener(v -> mOnItemClickListener.onItemClick(position));
    }

    public void setOnClickListener(OnItemClickListener onClickListener){
        mOnItemClickListener = onClickListener;
    }

    @Override
    public int getItemCount() {
        return null != mData ? mData.size() : 0;
    }

    public static class InnerHolder extends RecyclerView.ViewHolder {
        private TextView mText;
        private ImageView mImageView;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            mText = itemView.findViewById(R.id.item_text);
            mImageView = itemView.findViewById(R.id.item_image);
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

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
}
