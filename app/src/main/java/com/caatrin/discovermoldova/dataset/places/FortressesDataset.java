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
public class FortressesDataset extends AbstractDataset implements Dataset {

    public FortressesDataset(Realm realm) {
        super(realm);
    }

    @Override
    public List<Place> getDataSet() {
        RealmResults<Place> places = realm.where(Place.class).equalTo("type", PlacesTabsFragment.TAB_FORTRESSES).findAll();

        if(places.isEmpty()) {
            realm.beginTransaction();
            Place soroca = realm.createObject(Place.class);
            soroca.setTitle("Soroca");
            soroca.setDescription("blah blah blah");
            soroca.setImgResId(R.drawable.img_fortress_soroca);
            soroca.setType(PlacesTabsFragment.TAB_FORTRESSES);
            realm.commitTransaction();

            realm.beginTransaction();
            Place tighina = realm.createObject(Place.class);
            tighina.setTitle("Tighina");
            tighina.setDescription("blah blah blah");
            tighina.setImgResId(R.drawable.img_fortress_tighina);
            tighina.setType(PlacesTabsFragment.TAB_FORTRESSES);
            realm.commitTransaction();

            realm.beginTransaction();
            Place hotin = realm.createObject(Place.class);
            hotin.setTitle("Hotin");
            hotin.setDescription("blah blah blah");
            hotin.setImgResId(R.drawable.img_fortress_hotin);
            hotin.setType(PlacesTabsFragment.TAB_FORTRESSES);
            realm.commitTransaction();

            realm.beginTransaction();
            Place alba = realm.createObject(Place.class);
            alba.setTitle("Alba");
            alba.setDescription("blah blah blah");
            alba.setImgResId(R.drawable.img_fortress_alba);
            alba.setType(PlacesTabsFragment.TAB_FORTRESSES);
            realm.commitTransaction();

            places = realm.where(Place.class).equalTo("type", PlacesTabsFragment.TAB_FORTRESSES).findAll();
        }

        return places;
    }
}
