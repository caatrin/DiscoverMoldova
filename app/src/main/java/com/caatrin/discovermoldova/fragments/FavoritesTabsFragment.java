package com.caatrin.discovermoldova.fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.caatrin.discovermoldova.BaseFragment;
import com.caatrin.discovermoldova.R;
import com.caatrin.discovermoldova.fragments.adapters.FavoritesTabsPagerAdapter;

/**
 * Created by ecaterinagaleru on 1/28/16.
 */
public class FavoritesTabsFragment extends BaseFragment {

    public static final String TAB_PLACES = "Places";
    public static final String TAB_CULTURE = "Culture";
    public static final String TAB_EVENTS = "Events";

    public FavoritesTabsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tabs, container, false);

        final ViewPager viewPager = (ViewPager) v.findViewById(R.id.pager);
        FavoritesTabsPagerAdapter adapter = new FavoritesTabsPagerAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) v.findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(TAB_PLACES));
        tabLayout.addTab(tabLayout.newTab().setText(TAB_CULTURE));
        tabLayout.addTab(tabLayout.newTab().setText(TAB_EVENTS));

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return  v;
    }
}
