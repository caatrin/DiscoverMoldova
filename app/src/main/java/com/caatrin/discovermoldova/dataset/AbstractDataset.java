package com.caatrin.discovermoldova.dataset;

import io.realm.Realm;

/**
 * Created by ecaterinagaleru on 1/26/16.
 */
public abstract class AbstractDataset {

    protected Realm realm;

    public AbstractDataset(Realm realm) {
        this.realm = realm;
    }
}
