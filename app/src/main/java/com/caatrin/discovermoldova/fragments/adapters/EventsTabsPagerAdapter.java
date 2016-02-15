package com.caatrin.discovermoldova.fragments.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.caatrin.discovermoldova.fragments.EventsFragment;
import com.caatrin.discovermoldova.fragments.EventsUpcomingFragment;

/**
 * Created by ecaterinagaleru on 2/11/16.
 */
public class EventsTabsPagerAdapter extends FragmentStatePagerAdapter {


    public EventsTabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;
        switch (position) {
            case 0:
                frag = new EventsFragment();
                break;
            case 1:
                frag = new EventsUpcomingFragment();
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
