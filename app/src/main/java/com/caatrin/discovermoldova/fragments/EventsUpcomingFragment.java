package com.caatrin.discovermoldova.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.caatrin.discovermoldova.BaseFragment;
import com.caatrin.discovermoldova.Constants;
import com.caatrin.discovermoldova.R;
import com.caatrin.discovermoldova.fragments.adapters.EventsUpcomingRecyclerViewAdapter;
import com.firebase.client.Firebase;

/**
 * Created by ecaterinagaleru on 2/11/16.
 */
public class EventsUpcomingFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    private EventsUpcomingRecyclerViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public EventsUpcomingFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        //Firebase.setAndroidContext(getActivity());
        Firebase ref = new Firebase(Constants.FIREBASE_URL_EVENTS);

        mRecyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new EventsUpcomingRecyclerViewAdapter(getContext(), ref);
        mRecyclerView.setAdapter(mAdapter);

        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mAdapter.cleanup();
    }
}
