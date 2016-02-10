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
import com.caatrin.discovermoldova.data.Event;

import java.util.List;

/**
 * Created by ecaterinagaleru on 1/28/16.
 */
public class EventsRecyclerViewAdapter extends RecyclerView.Adapter<EventsRecyclerViewAdapter.EventsViewHolder> {

    private List<Event> mDataset;

    private Context mContext;
    private OnItemClickListener mItemClickListener;

    public EventsRecyclerViewAdapter(List<Event> mDataset, Context mContext) {
        this.mDataset = mDataset;
        this.mContext = mContext;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mItemClickListener = listener;
    }

    public class EventsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView image;
        TextView title;

        public Event event;
        public int position;

        public EventsViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.img_place);
            title = (TextView) itemView.findViewById(R.id.txt_title);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(event, position);
            }
        }
    }

    @Override
    public EventsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_recycler, parent, false);

        EventsViewHolder holder = new EventsViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(EventsViewHolder holder, int position) {
        holder.position = position;
        holder.event = mDataset.get(position);
        holder.title.setText(holder.event.getTitle());
        holder.image.setImageResource(holder.event.getImgResId());
        Uri path = Uri.parse("android.resource://com.caatrin.discovermoldova/" + holder.event.getImgResId());
        Glide.with(mContext).load(path).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface OnItemClickListener {
        void onItemClick(Event event, int position);
    }

}
