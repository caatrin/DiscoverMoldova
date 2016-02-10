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
public class MuseumsDataset extends AbstractDataset implements Dataset {

    public MuseumsDataset(Realm realm) {
        super(realm);
    }

    @Override
    public List<Place> getDataSet() {
        RealmResults<Place> places = realm.where(Place.class).equalTo("type", PlacesTabsFragment.TAB_MUSEUMS).findAll();

        if(places.isEmpty()) {
            realm.beginTransaction();
            Place etnografie = realm.createObject(Place.class);
            etnografie.setTitle("Muzeul National de Etnografie si Istorie Naturala");
            etnografie.setDescription("blah blah blah");
            etnografie.setImgResId(R.drawable.img_fortress_soroca);
            etnografie.setType(PlacesTabsFragment.TAB_MUSEUMS);
            realm.commitTransaction();

            places = realm.where(Place.class).equalTo("type", PlacesTabsFragment.TAB_MUSEUMS).findAll();
        }

        return places;
    }
}
