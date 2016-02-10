package com.caatrin.discovermoldova.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.caatrin.discovermoldova.BaseFragment;
import com.caatrin.discovermoldova.R;
import com.caatrin.discovermoldova.data.General;

import io.realm.RealmResults;

/**
 * A simple {@link Fragment} subclass.
 */
public class GeneralFragment extends BaseFragment {

    private ImageView mMoldovaImg;
    private TextView mCapitalTxt;
    private TextView mPopulationTxt;
    private TextView mLanguageTxt;
    private TextView mDescriptionTxt;


    public GeneralFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_general, container, false);

        RealmResults<General> results = mRealm.where(General.class).findAll();
        if (results.size() != 4) {
            mRealm.beginTransaction();
            mRealm.clear(General.class);
            mRealm.commitTransaction();

            mRealm.beginTransaction();
            General capital = mRealm.createObject(General.class);
            capital.setTitle("Capital");
            capital.setDescription("Chisinau");
            mRealm.commitTransaction();

            mRealm.beginTransaction();
            General population = mRealm.createObject(General.class);
            population.setTitle("Population");
            population.setDescription("3.559 million (2013)");
            mRealm.commitTransaction();

            mRealm.beginTransaction();
            General language = mRealm.createObject(General.class);
            language.setTitle("Language");
            language.setDescription("Romanian");
            mRealm.commitTransaction();

            mRealm.beginTransaction();
            General description = mRealm.createObject(General.class);
            description.setTitle("Description");
            description.setDescription("Moldova, an Eastern European country and former Soviet republic, has terrain encompassing forests, rocky hills and vineyards. It shares linguistic and cultural roots with its neighbor, Romania. Its wine regions include Nistreana, known for its reds, and Codru, home to some of the world’s largest cellars. The capital, Chișinău, has Soviet-style architecture and the National Museum of History, exhibiting ethnographic and art collections.");
            mRealm.commitTransaction();

            results = mRealm.where(General.class).findAll();
        }

        mMoldovaImg = (ImageView) v.findViewById(R.id.img_moldova);
        mCapitalTxt = (TextView) v.findViewById(R.id.txt_capital);
        mPopulationTxt = (TextView) v.findViewById(R.id.txt_population);
        mLanguageTxt = (TextView) v.findViewById(R.id.txt_language);
        mDescriptionTxt = (TextView) v.findViewById(R.id.txt_description);

        mCapitalTxt.setText(results.get(0).getDescription());
        mPopulationTxt.setText(results.get(1).getDescription());
        mLanguageTxt.setText(results.get(2).getDescription());
        mDescriptionTxt.setText(results.get(3).getDescription());


        return v;
    }


}
