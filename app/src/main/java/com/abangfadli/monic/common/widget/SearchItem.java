package com.abangfadli.monic.common.widget;

import android.databinding.Bindable;

import com.abangfadli.monic.BR;
import com.abangfadli.monic.framework.MonicViewState;

import org.parceler.Parcel;

/**
 * Created by ahmadfadli on 12/28/16.
 */

@Parcel
public class SearchItem extends MonicViewState {
    String id;
    String imageUrl;
    String title;
    String description;
    String score;

    @Bindable
    public String getId() {
        return id;
    }

    public SearchItem setId(String id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
        return this;
    }

    @Bindable
    public String getImageUrl() {
        return imageUrl;
    }

    public SearchItem setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        notifyPropertyChanged(BR.imageUrl);
        return this;
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public SearchItem setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
        return this;
    }

    @Bindable
    public String getDescription() {
        return description;
    }

    public SearchItem setDescription(String description) {
        this.description = description;
        notifyPropertyChanged(BR.description);
        return this;
    }

    @Bindable
    public String getScore() {
        return score;
    }

    public SearchItem setScore(String score) {
        this.score = score;
        notifyPropertyChanged(BR.score);
        return this;
    }
}
