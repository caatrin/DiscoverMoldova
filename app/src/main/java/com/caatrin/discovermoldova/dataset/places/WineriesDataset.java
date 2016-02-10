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
public class WineriesDataset extends AbstractDataset implements Dataset {

    public WineriesDataset(Realm realm) {
        super(realm);
    }

    @Override
    public List<Place> getDataSet() {
        RealmResults<Place> places = realm.where(Place.class).equalTo("type", PlacesTabsFragment.TAB_WINERIES).findAll();

        if(places.isEmpty()) {
            realm.beginTransaction();
            Place milestiimici = realm.createObject(Place.class);
            milestiimici.setTitle("Milestii Mici");
            milestiimici.setDescription("blah blah blah");
            milestiimici.setImgResId(R.drawable.img_winery_milestii_mici);
            milestiimici.setType(PlacesTabsFragment.TAB_WINERIES);
            realm.commitTransaction();

            realm.beginTransaction();
            Place cricova = realm.createObject(Place.class);
            cricova.setTitle("Cricova");
            cricova.setDescription("blah blah blah");
            cricova.setImgResId(R.drawable.img_winery_cricova);
            cricova.setType(PlacesTabsFragment.TAB_WINERIES);
            realm.commitTransaction();

            realm.beginTransaction();
            Place purcari = realm.createObject(Place.class);
            purcari.setTitle("Purcari");
            purcari.setDescription("blah blah blah");
            purcari.setImgResId(R.drawable.img_winery_purcari);
            purcari.setType(PlacesTabsFragment.TAB_WINERIES);
            realm.commitTransaction();

            realm.beginTransaction();
            Place chateau = realm.createObject(Place.class);
            chateau.setTitle("Chateau Vartely");
            chateau.setDescription("blah blah blah");
            chateau.setImgResId(R.drawable.img_monastery_curchi);
            chateau.setType(PlacesTabsFragment.TAB_WINERIES);
            realm.commitTransaction();

            places = realm.where(Place.class).equalTo("type", PlacesTabsFragment.TAB_WINERIES).findAll();
        }
        return places;
    }
}
