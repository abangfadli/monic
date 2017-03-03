package com.abangfadli.monic.home.category;

import android.databinding.Bindable;
import android.support.annotation.DrawableRes;

import com.abangfadli.monic.BR;
import com.abangfadli.monic.framework.MonicViewState;

import org.parceler.Parcel;

/**
 * Created by ahmadfadli on 9/11/16.
 */

@Parcel
public class CategoryItem extends MonicViewState {
    protected String id;
    @DrawableRes
    protected int iconRes;
    protected String imageUrl;
    protected String name;

    @Bindable
    public String getId() {
        return id;
    }

    public CategoryItem setId(String id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
        return this;
    }

    @Bindable
    public int getIconRes() {
        return iconRes;
    }

    public CategoryItem setIconRes(int iconRes) {
        this.iconRes = iconRes;
        notifyPropertyChanged(BR.iconRes);
        return this;
    }

    @Bindable
    public String getImageUrl() {
        return imageUrl;
    }

    public CategoryItem setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        notifyPropertyChanged(BR.imageUrl);
        return this;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public CategoryItem setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
        return this;
    }
}
