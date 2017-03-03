package com.abangfadli.monic.home.promo;

import android.databinding.Bindable;

import com.abangfadli.monic.BR;
import com.abangfadli.monic.framework.MonicViewState;

import org.parceler.Parcel;

/**
 * Created by ahmadfadli on 12/18/16.
 */

@Parcel
public class PromoItem extends MonicViewState {
    protected String id;
    protected String imageUrl;
    protected String text;

    @Bindable
    public String getId() {
        return id;
    }

    public PromoItem setId(String id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
        return this;
    }

    @Bindable
    public String getImageUrl() {
        return imageUrl;
    }

    public PromoItem setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        notifyPropertyChanged(BR.imageUrl);
        return this;
    }

    @Bindable
    public String getText() {
        return text;
    }

    public PromoItem setText(String text) {
        this.text = text;
        notifyPropertyChanged(BR.text);
        return this;
    }
}
