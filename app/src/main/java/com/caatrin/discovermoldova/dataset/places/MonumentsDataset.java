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
public class MonumentsDataset extends AbstractDataset implements Dataset {

    public MonumentsDataset(Realm realm) {
        super(realm);
    }

    @Override
    public List<Place> getDataSet() {
        RealmResults<Place> places = realm.where(Place.class).equalTo("type", PlacesTabsFragment.TAB_MONUMENTS).findAll();

        if(places.isEmpty()) {
            realm.beginTransaction();
            Place stephan = realm.createObject(Place.class);
            stephan.setTitle("Stephen the Great Monument");
            stephan.setDescription("blah blah blah");
            stephan.setImgResId(R.drawable.img_fortress_soroca);
            stephan.setType(PlacesTabsFragment.TAB_MONUMENTS);
            realm.commitTransaction();


            places = realm.where(Place.class).equalTo("type", PlacesTabsFragment.TAB_MONUMENTS).findAll();
        }

        return places;
    }
}
