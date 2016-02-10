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
public class BuildingsDataset extends AbstractDataset implements Dataset {

    public BuildingsDataset(Realm realm) {
        super(realm);
    }

    @Override
    public List<Place> getDataSet() {
        RealmResults<Place> places = realm.where(Place.class).equalTo("type", PlacesTabsFragment.TAB_BUILDINGS).findAll();

        if(places.isEmpty()) {
            realm.beginTransaction();
            Place railway = realm.createObject(Place.class);
            railway.setTitle("Chisinau Railway Station");
            railway.setDescription("blah blah blah");
            railway.setImgResId(R.drawable.img_fortress_soroca);
            railway.setType(PlacesTabsFragment.TAB_BUILDINGS);
            realm.commitTransaction();


            places = realm.where(Place.class).equalTo("type", PlacesTabsFragment.TAB_BUILDINGS).findAll();
        }

        return places;
    }
}
