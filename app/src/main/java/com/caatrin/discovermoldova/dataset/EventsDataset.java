package com.caatrin.discovermoldova.dataset;

import com.caatrin.discovermoldova.R;
import com.caatrin.discovermoldova.data.Event;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by ecaterinagaleru on 1/28/16.
 */
public class EventsDataset extends AbstractDataset implements Dataset {

    public EventsDataset(Realm realm) {
        super(realm);
    }

    @Override
    public List getDataSet() {
        RealmResults<Event> event = realm.where(Event.class).findAll();

        if(event.isEmpty()) {
            realm.beginTransaction();
            Event velohora = realm.createObject(Event.class);
            velohora.setTitle("Velohora");
            velohora.setDescription("blah blah blah");
            velohora.setImgResId(R.drawable.img_food_mamaliga);
            realm.commitTransaction();

            realm.beginTransaction();
            Event iamania = realm.createObject(Event.class);
            iamania.setTitle("Ia Mania");
            iamania.setDescription("blah blah blah");
            iamania.setImgResId(R.drawable.img_food_mamaliga);
            realm.commitTransaction();

            realm.beginTransaction();
            Event bostaniada = realm.createObject(Event.class);
            bostaniada.setTitle("Bostaniada");
            bostaniada.setDescription("blah blah blah");
            bostaniada.setImgResId(R.drawable.img_food_mamaliga);
            realm.commitTransaction();

            realm.beginTransaction();
            Event wineday = realm.createObject(Event.class);
            wineday.setTitle("Wine Day");
            wineday.setDescription("blah blah blah");
            wineday.setImgResId(R.drawable.img_food_mamaliga);
            realm.commitTransaction();

            realm.beginTransaction();
            Event gustar = realm.createObject(Event.class);
            gustar.setTitle("Gustar");
            gustar.setDescription("blah blah blah");
            gustar.setImgResId(R.drawable.img_food_mamaliga);
            realm.commitTransaction();

            event = realm.where(Event.class).findAll();
        }
        return event;
    }
}
