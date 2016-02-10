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
 * Created by ecaterinagaleru on 1/26/16.
 */
public class LandscapesDataset extends AbstractDataset implements Dataset {
    public LandscapesDataset(Realm realm) {
        super(realm);
    }

    @Override
    public List<Place> getDataSet() {
        RealmResults<Place> places = realm.where(Place.class).equalTo("type", PlacesTabsFragment.TAB_LANDSCAPES).findAll();

        if(places.isEmpty()) {
            realm.beginTransaction();
            Place orheiulvechi = realm.createObject(Place.class);
            orheiulvechi.setTitle("Orheiul Vechi");
            orheiulvechi.setDescription("blah blah blah");
            orheiulvechi.setImgResId(R.drawable.img_others_orheiul_vechi);
            orheiulvechi.setType(PlacesTabsFragment.TAB_LANDSCAPES);
            realm.commitTransaction();

            realm.beginTransaction();
            Place vadul = realm.createObject(Place.class);
            vadul.setTitle("Vadul lui Voda");
            vadul.setDescription("blah blah blah");
            vadul.setImgResId(R.drawable.img_monastery_saharna);
            vadul.setType(PlacesTabsFragment.TAB_LANDSCAPES);
            realm.commitTransaction();

            places = realm.where(Place.class).equalTo("type", PlacesTabsFragment.TAB_LANDSCAPES).findAll();
        }
        return places;
    }
}
