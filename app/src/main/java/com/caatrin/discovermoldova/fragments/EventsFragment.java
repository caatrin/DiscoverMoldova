package com.caatrin.discovermoldova.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.caatrin.discovermoldova.BaseFragment;
import com.caatrin.discovermoldova.ItemDescriptionActivity;
import com.caatrin.discovermoldova.R;
import com.caatrin.discovermoldova.data.Event;
import com.caatrin.discovermoldova.dataset.Dataset;
import com.caatrin.discovermoldova.dataset.EventsDataset;
import com.caatrin.discovermoldova.fragments.adapters.EventsRecyclerViewAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventsFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    private EventsRecyclerViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public EventsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        mRecyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new EventsRecyclerViewAdapter(getDataset(), getContext());
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new EventsRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Event event, int position) {
                Intent intent = new Intent(getContext(), ItemDescriptionActivity.class);
                Bundle args = new Bundle();
                args.putInt(ItemDescriptionFragment.ARG_POSITION, position);
                args.putString(ItemDescriptionFragment.ARG_TITLE, event.getTitle());
                args.putInt(ItemDescriptionFragment.ARG_IMAGE, event.getImgResId());
                args.putString(ItemDescriptionFragment.ARG_DESCRIPTION, event.getDescription());
                args.putBoolean(ItemDescriptionFragment.ARG_FAV, event.isFav());
                args.putString(ItemDescriptionFragment.ARG_DATA_TYPE, ItemDescriptionFragment.ARG_EVENTS);
                intent.putExtra(ItemDescriptionFragment.ARG_BUNDLE, args);
                startActivity(intent);
            }
        });

        return v;
    }

    public List<Event> getDataset() {
        Dataset dataset = new EventsDataset(mRealm);
        return dataset.getDataSet();
    }
}
