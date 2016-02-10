package com.caatrin.discovermoldova.fragments.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.caatrin.discovermoldova.fragments.FavoritesFragment;
import com.caatrin.discovermoldova.fragments.FavoritesTabsFragment;

/**
 * Created by ecaterinagaleru on 1/28/16.
 */
public class FavoritesTabsPagerAdapter extends FragmentStatePagerAdapter {

    public FavoritesTabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;
        switch (position) {
            case 0:
                frag = FavoritesFragment.newInstance(FavoritesTabsFragment.TAB_PLACES);
                break;
            case 1:
                frag = FavoritesFragment.newInstance(FavoritesTabsFragment.TAB_CULTURE);
                break;
            case 2:
                frag = FavoritesFragment.newInstance(FavoritesTabsFragment.TAB_EVENTS);
                break;
        }

        return frag;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
