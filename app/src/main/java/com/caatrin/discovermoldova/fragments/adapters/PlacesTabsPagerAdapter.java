package com.caatrin.discovermoldova.fragments.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.caatrin.discovermoldova.R;
import com.caatrin.discovermoldova.fragments.PlacesFragment;
import com.caatrin.discovermoldova.fragments.PlacesTabsFragment;

/**
 * Created by ecaterinagaleru on 1/25/16.
 */
public class PlacesTabsPagerAdapter extends FragmentStatePagerAdapter {

    public PlacesTabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        PlacesFragment frag = null;
        switch (position) {
            case 0:
                frag = PlacesFragment.newInstance(PlacesTabsFragment.TAB_MONASTERIES);
                break;
            case 1:
                frag = PlacesFragment.newInstance(PlacesTabsFragment.TAB_FORTRESSES);
                break;
            case 2:
                frag = PlacesFragment.newInstance(PlacesTabsFragment.TAB_WINERIES);
                break;
            case 3:
                frag = PlacesFragment.newInstance(PlacesTabsFragment.TAB_LANDSCAPES);
                break;
            case 4:
                frag = PlacesFragment.newInstance(PlacesTabsFragment.TAB_BUILDINGS);
                break;
            case 5:
                frag = PlacesFragment.newInstance(PlacesTabsFragment.TAB_PARKS);
                break;
            case 6:
                frag = PlacesFragment.newInstance(PlacesTabsFragment.TAB_MUSEUMS);
                break;
            case 7:
                frag = PlacesFragment.newInstance(PlacesTabsFragment.TAB_CATHEDRALS);
                break;
            case 8:
                frag = PlacesFragment.newInstance(PlacesTabsFragment.TAB_MONUMENTS);
                break;
            case 9:
                frag = PlacesFragment.newInstance(PlacesTabsFragment.TAB_MARKETS);
                break;
        }

        return frag;
    }

    @Override
    public int getCount() {
        return 10;
    }
}
