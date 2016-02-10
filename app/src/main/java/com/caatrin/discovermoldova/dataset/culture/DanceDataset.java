package com.caatrin.discovermoldova.dataset.culture;

import com.caatrin.discovermoldova.R;
import com.caatrin.discovermoldova.data.Culture;
import com.caatrin.discovermoldova.dataset.AbstractDataset;
import com.caatrin.discovermoldova.dataset.Dataset;
import com.caatrin.discovermoldova.fragments.CultureTabsFragment;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by ecaterinagaleru on 1/26/16.
 */
public class DanceDataset extends AbstractDataset implements Dataset {

    public DanceDataset(Realm realm) {
        super(realm);
    }

    @Override
    public List getDataSet() {
        RealmResults<Culture> culture = realm.where(Culture.class).equalTo("type", CultureTabsFragment.TAB_DANCE).findAll();

        if(culture.isEmpty()) {
            realm.beginTransaction();
            Culture hora = realm.createObject(Culture.class);
            hora.setTitle("Hora");
            hora.setDescription("blah blah blah");
            hora.setImgResId(R.drawable.img_dance_hora);
            hora.setType(CultureTabsFragment.TAB_DANCE);
            realm.commitTransaction();

            culture = realm.where(Culture.class).equalTo("type", CultureTabsFragment.TAB_DANCE).findAll();
        }
        return culture;
    }
}
