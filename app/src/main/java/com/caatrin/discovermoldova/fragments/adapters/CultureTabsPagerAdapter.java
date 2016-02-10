package com.caatrin.discovermoldova.fragments.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.caatrin.discovermoldova.data.Culture;
import com.caatrin.discovermoldova.dataset.culture.ClothingDataset;
import com.caatrin.discovermoldova.dataset.culture.DanceDataset;
import com.caatrin.discovermoldova.dataset.Dataset;
import com.caatrin.discovermoldova.fragments.CultureFragment;
import com.caatrin.discovermoldova.fragments.CultureTabsFragment;
import com.caatrin.discovermoldova.fragments.ItemDescriptionFragment;

import java.util.List;

import io.realm.Realm;

/**
 * Created by ecaterinagaleru on 1/26/16.
 */
public class CultureTabsPagerAdapter extends FragmentStatePagerAdapter {

    private Context mContext;
    private Realm mRealm;

    public CultureTabsPagerAdapter(FragmentManager fm, Context context, Realm realm) {
        super(fm);
        mContext = context;
        mRealm = realm;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;
        switch (position) {
            case 0:
                frag = CultureFragment.newInstance(CultureTabsFragment.TAB_FOOD);
                break;
            case 1:
                frag = newInstance(CultureTabsFragment.TAB_CLOTHING);
                break;
            case 2:
                frag = CultureFragment.newInstance(CultureTabsFragment.TAB_MUSIC);
                break;
            case 3:
                frag = newInstance(CultureTabsFragment.TAB_DANCE);
                break;
        }
        return frag;
    }

    private Fragment newInstance(String type) {
        List<Culture> culture =  getDataSet(type);

        Bundle args = new Bundle();
        args.putString(ItemDescriptionFragment.ARG_TITLE, culture.get(0).getTitle());
        args.putInt(ItemDescriptionFragment.ARG_IMAGE, culture.get(0).getImgResId());
        args.putBoolean(ItemDescriptionFragment.ARG_FAV, culture.get(0).isFav());
        args.putString(ItemDescriptionFragment.ARG_DESCRIPTION, culture.get(0).getDescription());
        args.putString(ItemDescriptionFragment.ARG_DATA_TYPE, ItemDescriptionFragment.ARG_CULTURE);
        return ItemDescriptionFragment.newInstance(args);
    }

    public List<Culture> getDataSet(String type) {
        Dataset dataset = null;
        switch (type) {
            case CultureTabsFragment.TAB_CLOTHING:
                dataset = new ClothingDataset(mRealm);
                break;
            case CultureTabsFragment.TAB_DANCE:
                dataset = new DanceDataset(mRealm);
                break;

        }

        return dataset.getDataSet();
    }

    @Override
    public int getCount() {
        return 4;
    }
}
