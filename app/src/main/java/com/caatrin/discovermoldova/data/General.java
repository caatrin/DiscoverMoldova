package com.caatrin.discovermoldova.data;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by ecaterinagaleru on 1/22/16.
 */
public class General extends RealmObject {

    @PrimaryKey
    private String title;
    private String description;

    public General() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
