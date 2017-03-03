package com.abangfadli.monic.search.result.model;

import java.util.List;

/**
 * Created by ahmadfadli on 9/18/16.
 */

public class SearchResultItem {
    private String id;
    private String imageUrl;
    private String name;

    private List<String> tags;
    private int durationDays;
    private long price;
    private Float rating;

    public String getId() {
        return id;
    }

    public SearchResultItem setId(String id) {
        this.id = id;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public SearchResultItem setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getName() {
        return name;
    }

    public SearchResultItem setName(String name) {
        this.name = name;
        return this;
    }

    public List<String> getTags() {
        return tags;
    }

    public SearchResultItem setTags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public int getDurationDays() {
        return durationDays;
    }

    public SearchResultItem setDurationDays(int durationDays) {
        this.durationDays = durationDays;
        return this;
    }

    public long getPrice() {
        return price;
    }

    public SearchResultItem setPrice(long price) {
        this.price = price;
        return this;
    }

    public Float getRating() {
        return rating;
    }

    public SearchResultItem setRating(Float rating) {
        this.rating = rating;
        return this;
    }
}
