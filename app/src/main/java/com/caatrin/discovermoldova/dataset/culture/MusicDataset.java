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
public class MusicDataset extends AbstractDataset implements Dataset {
    public MusicDataset(Realm realm) {
        super(realm);
    }

    @Override
    public List getDataSet() {
        RealmResults<Culture> culture = realm.where(Culture.class).equalTo("type", CultureTabsFragment.TAB_MUSIC).findAll();

        if(culture.isEmpty()) {
            realm.beginTransaction();
            Culture zdobsizdub = realm.createObject(Culture.class);
            zdobsizdub.setTitle("Zdob si Zdub");
            zdobsizdub.setDescription("blah blah blah");
            zdobsizdub.setImgResId(R.drawable.img_music_zdobsizdub);
            zdobsizdub.setType(CultureTabsFragment.TAB_MUSIC);
            realm.commitTransaction();

            realm.beginTransaction();
            Culture gindulmatei = realm.createObject(Culture.class);
            gindulmatei.setTitle("Gandul Matei");
            gindulmatei.setDescription("blah blah blah");
            gindulmatei.setImgResId(R.drawable.img_music_gindulmatei);
            gindulmatei.setType(CultureTabsFragment.TAB_MUSIC);
            realm.commitTransaction();

            realm.beginTransaction();
            Culture alternosfera = realm.createObject(Culture.class);
            alternosfera.setTitle("Alternosfera");
            alternosfera.setDescription("blah blah blah");
            alternosfera.setImgResId(R.drawable.img_music_alternosfera);
            alternosfera.setType(CultureTabsFragment.TAB_MUSIC);
            realm.commitTransaction();

            realm.beginTransaction();
            Culture nelyciobanu = realm.createObject(Culture.class);
            nelyciobanu.setTitle("Nelly Ciobanu");
            nelyciobanu.setDescription("blah blah blah");
            nelyciobanu.setImgResId(R.drawable.img_music_nellyciobanu);
            nelyciobanu.setType(CultureTabsFragment.TAB_MUSIC);
            realm.commitTransaction();

            culture = realm.where(Culture.class).equalTo("type", CultureTabsFragment.TAB_MUSIC).findAll();
        }
        return culture;
    }
}
