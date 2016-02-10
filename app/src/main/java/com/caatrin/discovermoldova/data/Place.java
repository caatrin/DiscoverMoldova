package com.caatrin.discovermoldova.data;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by ecaterinagaleru on 1/25/16.
 */
public class Place extends RealmObject {

    @PrimaryKey
    private String title;
    private String description;
    private String type;
    private int imgResId;
    private boolean fav = false;

    public Place() {}

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isFav() {
        return fav;
    }

    public void setFav(boolean fav) {
        this.fav = fav;
    }
}
