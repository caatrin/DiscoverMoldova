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
import com.caatrin.discovermoldova.data.Event;
import com.caatrin.discovermoldova.data.Place;
import com.caatrin.discovermoldova.dataset.Dataset;
import com.caatrin.discovermoldova.dataset.favs.FavCultureDataset;
import com.caatrin.discovermoldova.dataset.favs.FavEventsDataset;
import com.caatrin.discovermoldova.dataset.favs.FavPlacesDataset;
import com.caatrin.discovermoldova.fragments.adapters.CultureRecyclerViewAdapter;
import com.caatrin.discovermoldova.fragments.adapters.EventsRecyclerViewAdapter;
import com.caatrin.discovermoldova.fragments.adapters.PlacesRecyclerViewAdapter;


/**
 * Created by ecaterinagaleru on 1/28/16.
 */
public class FavoritesFragment extends BaseFragment {

    private static final String ARG_TITLE = "title";
    private static final int STATUS_UPDATE_FAVORITE = 1;

    private String mTitle;

    private RecyclerView mRecyclerView;
    private PlacesRecyclerViewAdapter mPlaceAdapter;
    private CultureRecyclerViewAdapter mCultureAdapter;
    private EventsRecyclerViewAdapter mEventsAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public FavoritesFragment() {}

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param title
     * @return A new instance of fragment FavoritesFragment.
     */
    public static FavoritesFragment newInstance(String title) {
        FavoritesFragment fragment = new FavoritesFragment();
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
        setupAdapter();
        return v;
    }

    private void setupAdapter() {
        Dataset dataset;
        switch (mTitle) {
            case FavoritesTabsFragment.TAB_PLACES:
                dataset = new FavPlacesDataset(mRealm);
                setupPlaceAdapter(dataset);
                break;
            case FavoritesTabsFragment.TAB_CULTURE:
                dataset = new FavCultureDataset(mRealm);
                setupCultureAdapter(dataset);
                break;
            case FavoritesTabsFragment.TAB_EVENTS:
                dataset = new FavEventsDataset(mRealm);
                setupEventsAdapter(dataset);
                break;
        }
    }

    private void setupPlaceAdapter(Dataset dataset) {
        mPlaceAdapter = new PlacesRecyclerViewAdapter(dataset.getDataSet(), getContext());
        mRecyclerView.setAdapter(mPlaceAdapter);
        mPlaceAdapter.setOnItemClickListener(new PlacesRecyclerViewAdapter.OnItemClickListener() {
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
                startActivityForResult(intent, STATUS_UPDATE_FAVORITE);
            }
        });
    }

    private void setupCultureAdapter(Dataset dataset) {
        mCultureAdapter = new CultureRecyclerViewAdapter(dataset.getDataSet(), getContext());
        mRecyclerView.setAdapter(mCultureAdapter);
        mCultureAdapter.setOnItemClickListener(new CultureRecyclerViewAdapter.OnItemClickListener() {
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
                startActivityForResult(intent, STATUS_UPDATE_FAVORITE);
            }
        });
    }

    private void setupEventsAdapter(Dataset dataset) {
        mEventsAdapter = new EventsRecyclerViewAdapter(dataset.getDataSet(), getContext());
        mRecyclerView.setAdapter(mEventsAdapter);
        mEventsAdapter.setOnItemClickListener(new EventsRecyclerViewAdapter.OnItemClickListener() {
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
                startActivityForResult(intent, STATUS_UPDATE_FAVORITE);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == STATUS_UPDATE_FAVORITE) {
            String dataType = data.getStringExtra(ItemDescriptionFragment.ARG_DATA_TYPE);
            if(dataType.equalsIgnoreCase(ItemDescriptionFragment.ARG_PLACES)) {
                if (data.getBooleanExtra(ItemDescriptionFragment.ARG_NOTFAV, true) == false) {
                    mPlaceAdapter.notifyDataSetChanged();
                    //mPlaceAdapter.notifyItemRemoved(data.getIntExtra(ItemDescriptionFragment.ARG_POSITION, 0));
                }
            } else if (dataType.equalsIgnoreCase(ItemDescriptionFragment.ARG_CULTURE)) {
                if (data.getBooleanExtra(ItemDescriptionFragment.ARG_NOTFAV, true) == false) {
                    mCultureAdapter.notifyDataSetChanged();
                    //mCultureAdapter.notifyItemRemoved(data.getIntExtra(ItemDescriptionFragment.ARG_POSITION, 0));
                }
            }else if (dataType.equalsIgnoreCase(ItemDescriptionFragment.ARG_EVENTS)) {
                if (data.getBooleanExtra(ItemDescriptionFragment.ARG_NOTFAV, true) == false) {
                    mEventsAdapter.notifyDataSetChanged();
                    //mEventsAdapter.notifyItemRemoved(data.getIntExtra(ItemDescriptionFragment.ARG_POSITION, 0));
                }
            }
        }
    }
}
