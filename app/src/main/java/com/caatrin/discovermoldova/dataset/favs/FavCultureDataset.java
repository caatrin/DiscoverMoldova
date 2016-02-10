package com.caatrin.discovermoldova.dataset.favs;

import com.caatrin.discovermoldova.data.Culture;
import com.caatrin.discovermoldova.dataset.AbstractDataset;
import com.caatrin.discovermoldova.dataset.Dataset;

import java.util.List;

import io.realm.Realm;

/**
 * Created by ecaterinagaleru on 1/29/16.
 */
public class FavCultureDataset extends AbstractDataset implements Dataset {

    public FavCultureDataset(Realm realm) {
        super(realm);
    }

    @Override
    public List getDataSet() {
        return realm.where(Culture.class).equalTo("fav", true).findAll();
    }
}
