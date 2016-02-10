package com.caatrin.discovermoldova.fragments;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.caatrin.discovermoldova.BaseFragment;
import com.caatrin.discovermoldova.R;
import com.caatrin.discovermoldova.data.Culture;
import com.caatrin.discovermoldova.data.Event;
import com.caatrin.discovermoldova.data.Place;

/**
 * Created by ecaterinagaleru on 1/26/16.
 */
public class ItemDescriptionFragment extends BaseFragment {

    public static final String ARG_TITLE = "title";
    public static final String ARG_IMAGE = "image";
    public static final String ARG_DESCRIPTION = "description";
    public static final String ARG_FAV = "fav";
    public static final String ARG_BUNDLE = "bundle";
    public static final String ARG_DATA_TYPE = "Data_type";

    public static final String ARG_PLACES = "Places";
    public static final String ARG_CULTURE = "Culture";
    public static final String ARG_EVENTS = "Events";

    public static final String ARG_NOTFAV = "notfav";
    public static final String ARG_POSITION = "position";


    private String mTitle;
    private int mImageResId;
    private String mDescription;
    private boolean mFav;
    private String mDataType;
    private boolean mIsFav = false;
    private int mPosition;

    private ImageView mimageRes;
    private TextView mTitleTxt;
    private TextView mDescriptionTxt;
    private FloatingActionButton mFab;


    public ItemDescriptionFragment() {}


    public static Fragment newInstance(Bundle args) {
        ItemDescriptionFragment fragment = new ItemDescriptionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        if (getArguments() != null) {
            mTitle = getArguments().getString(ARG_TITLE);
            mImageResId = getArguments().getInt(ARG_IMAGE);
            mDescription = getArguments().getString(ARG_DESCRIPTION);
            mFav = getArguments().getBoolean(ARG_FAV);
            mDataType = getArguments().getString(ARG_DATA_TYPE);
            mPosition = getArguments().getInt(ARG_POSITION);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_item_description, container, false);

        mimageRes = (ImageView) v.findViewById(R.id.img_item);
        mTitleTxt = (TextView) v.findViewById(R.id.txt_title);
        mDescriptionTxt = (TextView) v.findViewById(R.id.txt_description);
        mFab = (FloatingActionButton) v.findViewById(R.id.fab);
        setFabButtonColor();

        mimageRes.setImageResource(mImageResId);
        mTitleTxt.setText(mTitle);
        mDescriptionTxt.setText(mDescription);
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFavorites();
                setFabButtonColor();
            }
        });

        return v;
    }

    private void setFabButtonColor() {
        if(mFav) {
            mFab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.fav)));
            mFav = false;
            mIsFav = true;
        } else {
            mFab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.not_fav)));
            mFav = true;
            mIsFav = false;
        }
    }

    private void setFavorites() {
        switch (mDataType) {
            case ARG_PLACES:
                Place place = mRealm.where(Place.class).equalTo("title", mTitle).findFirst();
                mRealm.beginTransaction();
                if (place.isFav()) {
                    place.setFav(false);
                } else {
                    place.setFav(true);
                }
                mRealm.commitTransaction();
                break;
            case ARG_CULTURE:
                Culture culture = mRealm.where(Culture.class).equalTo("title", mTitle).findFirst();
                mRealm.beginTransaction();
                if (culture.isFav()) {
                    culture.setFav(false);
                } else {
                    culture.setFav(true);
                }
                mRealm.commitTransaction();
                break;
            case ARG_EVENTS:
                Event event = mRealm.where(Event.class).equalTo("title", mTitle).findFirst();
                mRealm.beginTransaction();
                if (event.isFav()) {
                    event.setFav(false);
                } else {
                    event.setFav(true);
                }
                mRealm.commitTransaction();
                break;
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {
                    Intent returnIntent = new Intent();
                    returnIntent.putExtra(ARG_NOTFAV, mIsFav);
                    returnIntent.putExtra(ARG_POSITION, mPosition);
                    returnIntent.putExtra(ARG_DATA_TYPE, mDataType);
                    getActivity().setResult(Activity.RESULT_OK, returnIntent);
                    getActivity().finish();
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d("onOptionsItemSelected", "yes");
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent returnIntent = new Intent();
                returnIntent.putExtra(ARG_NOTFAV, mIsFav);
                returnIntent.putExtra(ARG_POSITION,mPosition);
                returnIntent.putExtra(ARG_DATA_TYPE, mDataType);
                getActivity().setResult(Activity.RESULT_OK, returnIntent);
                getActivity().finish();
                return true;
        }
        return super.onOptionsItemSelected(item);


    }


}
