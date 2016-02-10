package com.caatrin.discovermoldova.dataset.favs;

import com.caatrin.discovermoldova.data.Place;
import com.caatrin.discovermoldova.dataset.AbstractDataset;
import com.caatrin.discovermoldova.dataset.Dataset;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by ecaterinagaleru on 1/29/16.
 */
public class FavPlacesDataset extends AbstractDataset implements Dataset {

    public FavPlacesDataset(Realm realm) {
        super(realm);
    }

    @Override
    public List getDataSet() {
        return realm.where(Place.class).equalTo("fav", true).findAll();
    }
}
