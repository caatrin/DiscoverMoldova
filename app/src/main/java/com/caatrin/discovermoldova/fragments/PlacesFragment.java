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
import com.caatrin.discovermoldova.data.Place;
import com.caatrin.discovermoldova.dataset.Dataset;
import com.caatrin.discovermoldova.dataset.places.BuildingsDataset;
import com.caatrin.discovermoldova.dataset.places.CathedralsDataset;
import com.caatrin.discovermoldova.dataset.places.FortressesDataset;
import com.caatrin.discovermoldova.dataset.places.MarketsDataset;
import com.caatrin.discovermoldova.dataset.places.MonasteriesDataset;
import com.caatrin.discovermoldova.dataset.places.LandscapesDataset;
import com.caatrin.discovermoldova.dataset.places.MonumentsDataset;
import com.caatrin.discovermoldova.dataset.places.MuseumsDataset;
import com.caatrin.discovermoldova.dataset.places.ParksDataset;
import com.caatrin.discovermoldova.dataset.places.WineriesDataset;
import com.caatrin.discovermoldova.fragments.adapters.PlacesRecyclerViewAdapter;

import java.util.List;

/**
 * A simple {@link BaseFragment} subclass.
 * Use the {@link PlacesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlacesFragment extends BaseFragment {

    private static final String ARG_TITLE = "title";

    private String mTitle;

    private RecyclerView mRecyclerView;
    private PlacesRecyclerViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    public PlacesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param title
     * @return A new instance of fragment PlacesFragment.
     */
    public static PlacesFragment newInstance(String title) {
        PlacesFragment fragment = new PlacesFragment();
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
        mAdapter = new PlacesRecyclerViewAdapter(getDataSet(), getContext());
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new PlacesRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Place place, int position) {
                Intent intent = new Intent(getContext(), ItemDescriptionActivity.class);
                Bundle args = new Bundle();
                args.putInt(ItemDescriptionFragment.ARG_POSITION, position);
                args.putString(ItemDescriptionFragment.ARG_TITLE, place.getTitle());
                args.putInt(ItemDescriptionFragment.ARG_IMAGE, place.getImgResId());
                args.putString(ItemDescriptionFragment.ARG_DESCRIPTION, place.getDescription());
                args.putBoolean(ItemDescriptionFragment.ARG_FAV, place.isFav());
                args.putString(ItemDescriptionFragment.ARG_DATA_TYPE, ItemDescriptionFragment.ARG_PLACES);
                intent.putExtra(ItemDescriptionFragment.ARG_BUNDLE, args);
                startActivity(intent);
            }
        });

        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public List<Place> getDataSet() {
        Dataset dataset = null;
        switch (mTitle) {
            case PlacesTabsFragment.TAB_MONASTERIES:
                dataset = new MonasteriesDataset(mRealm);
                break;
            case PlacesTabsFragment.TAB_FORTRESSES:
                dataset = new FortressesDataset(mRealm);
                break;
            case PlacesTabsFragment.TAB_WINERIES:
                dataset = new WineriesDataset(mRealm);
                break;
            case PlacesTabsFragment.TAB_LANDSCAPES:
                dataset = new LandscapesDataset(mRealm);
                break;
            case PlacesTabsFragment.TAB_BUILDINGS:
                dataset = new BuildingsDataset(mRealm);
                break;
            case PlacesTabsFragment.TAB_PARKS:
                dataset = new ParksDataset(mRealm);
                break;
            case PlacesTabsFragment.TAB_MUSEUMS:
                dataset = new MuseumsDataset(mRealm);
                break;
            case PlacesTabsFragment.TAB_CATHEDRALS:
                dataset = new CathedralsDataset(mRealm);
                break;
            case PlacesTabsFragment.TAB_MONUMENTS:
                dataset = new MonumentsDataset(mRealm);
                break;
            case PlacesTabsFragment.TAB_MARKETS:
                dataset = new MarketsDataset(mRealm);
                break;
        }

        return dataset.getDataSet();
    }


}
