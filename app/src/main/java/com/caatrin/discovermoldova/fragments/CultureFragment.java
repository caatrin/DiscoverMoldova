package com.caatrin.discovermoldova.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.caatrin.discovermoldova.BaseFragment;
import com.caatrin.discovermoldova.ItemDescriptionActivity;
import com.caatrin.discovermoldova.R;
import com.caatrin.discovermoldova.data.Culture;
import com.caatrin.discovermoldova.dataset.Dataset;
import com.caatrin.discovermoldova.dataset.culture.FoodDataset;
import com.caatrin.discovermoldova.dataset.culture.MusicDataset;
import com.caatrin.discovermoldova.fragments.adapters.CultureRecyclerViewAdapter;

import java.util.List;

/**
 * Created by ecaterinagaleru on 1/26/16.
 */
public class CultureFragment extends BaseFragment {

    private static final String ARG_TITLE = "title";

    private String mTitle;

    private RecyclerView mRecyclerView;
    private CultureRecyclerViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public CultureFragment() {}

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param title
     * @return A new instance of fragment PlacesFragment.
     */
    public static CultureFragment newInstance(String title) {
        CultureFragment fragment = new CultureFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mTitle = getArguments().getString(ARG_TITLE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        mRecyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new CultureRecyclerViewAdapter(getDataSet(), getContext());
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new CultureRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Culture culture, int position) {
                Intent intent = new Intent(getContext(), ItemDescriptionActivity.class);
                Bundle args = new Bundle();
                args.putInt(ItemDescriptionFragment.ARG_POSITION, position);
                args.putString(ItemDescriptionFragment.ARG_TITLE, culture.getTitle());
                args.putInt(ItemDescriptionFragment.ARG_IMAGE, culture.getImgResId());
                args.putString(ItemDescriptionFragment.ARG_DESCRIPTION, culture.getDescription());
                args.putBoolean(ItemDescriptionFragment.ARG_FAV, culture.isFav());
                args.putString(ItemDescriptionFragment.ARG_DATA_TYPE, ItemDescriptionFragment.ARG_CULTURE);
                intent.putExtra(ItemDescriptionFragment.ARG_BUNDLE, args);
                startActivity(intent);
            }
        });

        return v;
    }

    public List<Culture> getDataSet() {
        Dataset dataset = null;
        switch (mTitle) {
            case CultureTabsFragment.TAB_FOOD:
                dataset = new FoodDataset(mRealm);
                break;
            case CultureTabsFragment.TAB_MUSIC:
                dataset = new MusicDataset(mRealm);
                break;

        }

        return dataset.getDataSet();
    }

}

