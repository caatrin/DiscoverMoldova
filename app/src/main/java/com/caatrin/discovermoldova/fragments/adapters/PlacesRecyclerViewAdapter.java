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
import com.caatrin.discovermoldova.data.Place;

import java.util.List;

/**
 * Created by ecaterinagaleru on 1/25/16.
 */
public class PlacesRecyclerViewAdapter extends RecyclerView.Adapter<PlacesRecyclerViewAdapter.PlacesViewHolder> {

    private List<Place> mDataset;
    private Context mContext;
    private OnItemClickListener mItemClickListener;

    public PlacesRecyclerViewAdapter(List<Place> dataset, Context context) {
        mDataset = dataset;
        mContext = context;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mItemClickListener = listener;
    }


    public class PlacesViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        ImageView image;
        TextView title;

        public Place place;
        public int position;

        public PlacesViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.img_place);
            title = (TextView) itemView.findViewById(R.id.txt_title);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(place, position);
            }
        }
    }

    @Override
    public PlacesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_recycler, parent, false);

        PlacesViewHolder placesHolder = new PlacesViewHolder(v);
        return placesHolder;
    }

    @Override
    public void onBindViewHolder(PlacesViewHolder holder, int position) {
        holder.position = position;
        holder.place = mDataset.get(position);
        holder.title.setText(holder.place.getTitle());

        Uri path = Uri.parse("android.resource://com.caatrin.discovermoldova/" + holder.place.getImgResId());
        Glide.with(mContext).load(path).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }


    public interface OnItemClickListener {
        void onItemClick(Place place, int position);
    }

}
