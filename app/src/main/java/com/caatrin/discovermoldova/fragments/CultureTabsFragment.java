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
import com.caatrin.discovermoldova.fragments.adapters.CultureTabsPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class CultureTabsFragment extends BaseFragment {

    public static final String TAB_FOOD = "Food";
    public static final String TAB_CLOTHING = "Clothing";
    public static final String TAB_MUSIC = "Music";
    public static final String TAB_DANCE = "Dance";


    public CultureTabsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tabs, container, false);

        final ViewPager viewPager = (ViewPager) v.findViewById(R.id.pager);
        CultureTabsPagerAdapter adapter = new CultureTabsPagerAdapter(getActivity().getSupportFragmentManager(), getContext(), mRealm);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) v.findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(TAB_FOOD));
        tabLayout.addTab(tabLayout.newTab().setText(TAB_CLOTHING));
        tabLayout.addTab(tabLayout.newTab().setText(TAB_MUSIC));
        tabLayout.addTab(tabLayout.newTab().setText(TAB_DANCE));

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
