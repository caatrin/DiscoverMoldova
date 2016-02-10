package com.caatrin.discovermoldova.dataset.places;

import com.caatrin.discovermoldova.R;
import com.caatrin.discovermoldova.data.Place;
import com.caatrin.discovermoldova.dataset.AbstractDataset;
import com.caatrin.discovermoldova.dataset.Dataset;
import com.caatrin.discovermoldova.fragments.PlacesTabsFragment;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by ecaterinagaleru on 2/2/16.
 */
public class MarketsDataset extends AbstractDataset implements Dataset {

    public MarketsDataset(Realm realm) {
        super(realm);
    }

    @Override
    public List<Place> getDataSet() {
        RealmResults<Place> places = realm.where(Place.class).equalTo("type", PlacesTabsFragment.TAB_MARKETS).findAll();

        if(places.isEmpty()) {
            realm.beginTransaction();
            Place central = realm.createObject(Place.class);
            central.setTitle("Central Market");
            central.setDescription("blah blah blah");
            central.setImgResId(R.drawable.img_fortress_soroca);
            central.setType(PlacesTabsFragment.TAB_MARKETS);
            realm.commitTransaction();


            places = realm.where(Place.class).equalTo("type", PlacesTabsFragment.TAB_MARKETS).findAll();
        }

        return places;
    }
}
