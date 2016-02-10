package com.caatrin.discovermoldova.data;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by ecaterinagaleru on 1/28/16.
 */
public class Event extends RealmObject {

    @PrimaryKey
    private String title;
    private String description;
    private int imgResId;
    private boolean fav = false;

    public Event() {}

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

    public int getImgResId() {
        return imgResId;
    }

    public void setImgResId(int imgResId) {
        this.imgResId = imgResId;
    }

    public boolean isFav() {
        return fav;
    }

    public void setFav(boolean fav) {
        this.fav = fav;
    }
}
