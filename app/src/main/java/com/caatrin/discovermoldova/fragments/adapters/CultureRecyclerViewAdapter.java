package com.caatrin.discovermoldova.fragments.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.caatrin.discovermoldova.R;
import com.caatrin.discovermoldova.data.Culture;
import com.caatrin.discovermoldova.data.Place;

import java.util.List;

/**
 * Created by ecaterinagaleru on 1/25/16.
 */
public class CultureRecyclerViewAdapter extends RecyclerView.Adapter<CultureRecyclerViewAdapter.CultureViewHolder> {

    private List<Culture> mDataset;

    private Context mContext;
    private OnItemClickListener mItemClickListener;

    public CultureRecyclerViewAdapter(List<Culture> dataset, Context context) {
        mDataset = dataset;
        mContext = context;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mItemClickListener = listener;
    }


    public class CultureViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        ImageView image;
        TextView title;

        public Culture culture;
        public int position;

        public CultureViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.img_place);
            title = (TextView) itemView.findViewById(R.id.txt_title);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(culture, position);
            }
        }
    }

    @Override
    public CultureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_recycler, parent, false);

        CultureViewHolder cultureHolder = new CultureViewHolder(v);
        return cultureHolder;
    }

    @Override
    public void onBindViewHolder(CultureViewHolder holder, int position) {
        holder.position = position;
        holder.culture = mDataset.get(position);
        holder.title.setText(holder.culture.getTitle());

        Uri path = Uri.parse("android.resource://com.caatrin.discovermoldova/" + holder.culture.getImgResId());
        Glide.with(mContext).load(path).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }


    public interface OnItemClickListener {
        void onItemClick(Culture culture, int position);
    }

}
