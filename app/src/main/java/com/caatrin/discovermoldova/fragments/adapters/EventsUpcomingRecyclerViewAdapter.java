package com.caatrin.discovermoldova.fragments.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.caatrin.discovermoldova.EventsUpcomingDetailsActivity;
import com.caatrin.discovermoldova.fragments.EventsUpcomingDetailsFragment;
import com.caatrin.discovermoldova.R;
import com.caatrin.discovermoldova.data.firebase.Event;
import com.firebase.client.Query;
import com.firebase.ui.FirebaseRecyclerViewAdapter;

/**
 * Created by ecaterinagaleru on 2/11/16.
 */
public class EventsUpcomingRecyclerViewAdapter
        extends FirebaseRecyclerViewAdapter<Event, EventsUpcomingRecyclerViewAdapter.EventsViewHolder> {

    private Context mContext;

    public EventsUpcomingRecyclerViewAdapter(Context context, Query ref) {
        super(Event.class, R.layout.list_item_event_upcoming, EventsViewHolder.class, ref);
        this.mContext = context;
    }

    public static class EventsViewHolder extends RecyclerView.ViewHolder {

        View view;
        ImageView image;
        TextView title;

        public int position;

        public EventsViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            image = (ImageView) itemView.findViewById(R.id.img_place);
            title = (TextView) itemView.findViewById(R.id.txt_title);
        }
    }

    @Override
    protected void populateViewHolder(EventsViewHolder viewHolder, final Event model, final int position) {
        viewHolder.position = position;
        Uri path = Uri.parse(model.getImageUrl());
        Glide.with(mContext).load(path).into(viewHolder.image);
        viewHolder.title.setText(model.getName());
        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, EventsUpcomingDetailsActivity.class);
                String key = getRef(position).getKey();
                intent.putExtra(EventsUpcomingDetailsFragment.ARG_KEY, key);
                intent.putExtra(EventsUpcomingDetailsActivity.ARG_TITLE, model.getName());
                mContext.startActivity(intent);
            }
        });
    }


}
