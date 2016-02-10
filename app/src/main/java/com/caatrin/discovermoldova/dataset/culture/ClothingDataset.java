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
public class ClothingDataset extends AbstractDataset implements Dataset {

    public ClothingDataset(Realm realm) {
        super(realm);
    }

    @Override
    public List getDataSet() {
        RealmResults<Culture> culture = realm.where(Culture.class).equalTo("type", CultureTabsFragment.TAB_CLOTHING).findAll();

        if(culture.isEmpty()) {
            realm.beginTransaction();
            Culture costume = realm.createObject(Culture.class);
            costume.setTitle("Traditional Costume");
            costume.setDescription("blah blah blah");
            costume.setImgResId(R.drawable.img_clothing);
            costume.setType(CultureTabsFragment.TAB_CLOTHING);
            realm.commitTransaction();

            culture = realm.where(Culture.class).equalTo("type", CultureTabsFragment.TAB_CLOTHING).findAll();
        }
        return culture;
    }
}
