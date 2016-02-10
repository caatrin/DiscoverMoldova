package com.caatrin.discovermoldova.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.caatrin.discovermoldova.BaseFragment;
import com.caatrin.discovermoldova.R;
import com.caatrin.discovermoldova.fragments.adapters.PlacesTabsPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlacesTabsFragment extends BaseFragment {

    public static final String TAB_MONASTERIES = "Monasteries";
    public static final String TAB_FORTRESSES = "Fortresses";
    public static final String TAB_WINERIES = "Wineries";
    public static final String TAB_LANDSCAPES = "Landscapes";
    public static final String TAB_BUILDINGS = "Buildings";
    public static final String TAB_PARKS = "Parks";
    public static final String TAB_MUSEUMS = "Museums";
    public static final String TAB_CATHEDRALS = "Cathedrals";
    public static final String TAB_MONUMENTS = "Monuments";
    public static final String TAB_MARKETS = "Markets";

    public PlacesTabsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tabs, container, false);


        final ViewPager viewPager = (ViewPager) v.findViewById(R.id.pager);
        PlacesTabsPagerAdapter adapter = new PlacesTabsPagerAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) v.findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(TAB_MONASTERIES));
        tabLayout.addTab(tabLayout.newTab().setText(TAB_FORTRESSES));
        tabLayout.addTab(tabLayout.newTab().setText(TAB_WINERIES));
        tabLayout.addTab(tabLayout.newTab().setText(TAB_LANDSCAPES));
        tabLayout.addTab(tabLayout.newTab().setText(TAB_BUILDINGS));
        tabLayout.addTab(tabLayout.newTab().setText(TAB_PARKS));
        tabLayout.addTab(tabLayout.newTab().setText(TAB_MUSEUMS));
        tabLayout.addTab(tabLayout.newTab().setText(TAB_CATHEDRALS));
        tabLayout.addTab(tabLayout.newTab().setText(TAB_MONUMENTS));
        tabLayout.addTab(tabLayout.newTab().setText(TAB_MARKETS));
        //tabLayout.setupWithViewPager(viewPager);

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

        return v;
    }


}
