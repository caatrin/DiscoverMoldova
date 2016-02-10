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
public class MonasteriesDataset extends AbstractDataset implements Dataset {

    public MonasteriesDataset(Realm realm) {
        super(realm);
    }

    @Override
    public List<Place> getDataSet() {
        RealmResults<Place> places = realm.where(Place.class).equalTo("type", PlacesTabsFragment.TAB_MONASTERIES).findAll();

        if(places.isEmpty()) {
            realm.beginTransaction();
            Place capriana = realm.createObject(Place.class);
            capriana.setTitle("Capriana");
            capriana.setDescription("blah blah blah");
            capriana.setImgResId(R.drawable.img_monastery_capriana);
            capriana.setType(PlacesTabsFragment.TAB_MONASTERIES);
            realm.commitTransaction();

            realm.beginTransaction();
            Place saharna = realm.createObject(Place.class);
            saharna.setTitle("Saharna");
            saharna.setDescription("blah blah blah");
            saharna.setImgResId(R.drawable.img_monastery_saharna);
            saharna.setType(PlacesTabsFragment.TAB_MONASTERIES);
            realm.commitTransaction();

            realm.beginTransaction();
            Place hancu = realm.createObject(Place.class);
            hancu.setTitle("Hancu");
            hancu.setDescription("blah blah blah");
            hancu.setImgResId(R.drawable.img_monestery_hancu);
            hancu.setType(PlacesTabsFragment.TAB_MONASTERIES);
            realm.commitTransaction();

            realm.beginTransaction();
            Place curchi = realm.createObject(Place.class);
            curchi.setTitle("Curchi");
            curchi.setDescription("blah blah blah");
            curchi.setImgResId(R.drawable.img_monastery_curchi);
            curchi.setType(PlacesTabsFragment.TAB_MONASTERIES);
            realm.commitTransaction();

            realm.beginTransaction();
            Place tipova = realm.createObject(Place.class);
            tipova.setTitle("Tipova");
            tipova.setDescription("blah blah blah");
            tipova.setImgResId(R.drawable.img_monastery_tipova);
            tipova.setType(PlacesTabsFragment.TAB_MONASTERIES);
            realm.commitTransaction();

            places = realm.where(Place.class).equalTo("type", PlacesTabsFragment.TAB_MONASTERIES).findAll();
        }

        return places;
    }

}
