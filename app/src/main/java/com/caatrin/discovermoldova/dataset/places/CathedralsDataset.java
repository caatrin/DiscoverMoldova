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
public class CathedralsDataset extends AbstractDataset implements Dataset {

    public CathedralsDataset(Realm realm) {
        super(realm);
    }

    @Override
    public List<Place> getDataSet() {
        RealmResults<Place> places = realm.where(Place.class).equalTo("type", PlacesTabsFragment.TAB_CATHEDRALS).findAll();

        if(places.isEmpty()) {
            realm.beginTransaction();
            Place nasterea = realm.createObject(Place.class);
            nasterea.setTitle("Catedrala Nasterea Domnului ");
            nasterea.setDescription("blah blah blah");
            nasterea.setImgResId(R.drawable.img_fortress_soroca);
            nasterea.setType(PlacesTabsFragment.TAB_CATHEDRALS);
            realm.commitTransaction();


            places = realm.where(Place.class).equalTo("type", PlacesTabsFragment.TAB_CATHEDRALS).findAll();
        }

        return places;
    }
}
