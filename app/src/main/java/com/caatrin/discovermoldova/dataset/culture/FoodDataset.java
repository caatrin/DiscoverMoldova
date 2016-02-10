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
public class FoodDataset extends AbstractDataset implements Dataset {

    public FoodDataset(Realm realm) {
        super(realm);
    }

    @Override
    public List<Culture> getDataSet() {
        RealmResults<Culture> culture = realm.where(Culture.class).equalTo("type", CultureTabsFragment.TAB_FOOD).findAll();

        if(culture.isEmpty()) {
            realm.beginTransaction();
            Culture mamaliga = realm.createObject(Culture.class);
            mamaliga.setTitle("Mamaliga");
            mamaliga.setDescription("blah blah blah");
            mamaliga.setImgResId(R.drawable.img_food_mamaliga);
            mamaliga.setType(CultureTabsFragment.TAB_FOOD);
            realm.commitTransaction();

            realm.beginTransaction();
            Culture placinte = realm.createObject(Culture.class);
            placinte.setTitle("Placinte");
            placinte.setDescription("blah blah blah");
            placinte.setImgResId(R.drawable.img_food_placinte);
            placinte.setType(CultureTabsFragment.TAB_FOOD);
            realm.commitTransaction();

            realm.beginTransaction();
            Culture sarmale = realm.createObject(Culture.class);
            sarmale.setTitle("Sarmale");
            sarmale.setDescription("blah blah blah");
            sarmale.setImgResId(R.drawable.img_food_sarmale);
            sarmale.setType(CultureTabsFragment.TAB_FOOD);
            realm.commitTransaction();

            realm.beginTransaction();
            Culture blinii = realm.createObject(Culture.class);
            blinii.setTitle("Blinii");
            blinii.setDescription("blah blah blah");
            blinii.setImgResId(R.drawable.img_food_blinii);
            blinii.setType(CultureTabsFragment.TAB_FOOD);
            realm.commitTransaction();

            realm.beginTransaction();
            Culture zeama = realm.createObject(Culture.class);
            zeama.setTitle("Zeama");
            zeama.setDescription("blah blah blah");
            zeama.setImgResId(R.drawable.img_food_zeama);
            zeama.setType(CultureTabsFragment.TAB_FOOD);
            realm.commitTransaction();

            realm.beginTransaction();
            Culture coltunasi = realm.createObject(Culture.class);
            coltunasi.setTitle("Coltunasi");
            coltunasi.setDescription("blah blah blah");
            coltunasi.setImgResId(R.drawable.img_food_coltunasi);
            coltunasi.setType(CultureTabsFragment.TAB_FOOD);
            realm.commitTransaction();

            realm.beginTransaction();
            Culture compot = realm.createObject(Culture.class);
            compot.setTitle("Compot");
            compot.setDescription("blah blah blah");
            compot.setImgResId(R.drawable.img_food_compot);
            compot.setType(CultureTabsFragment.TAB_FOOD);
            realm.commitTransaction();


            culture = realm.where(Culture.class).equalTo("type", CultureTabsFragment.TAB_FOOD).findAll();
        }
        return culture;
    }
}
