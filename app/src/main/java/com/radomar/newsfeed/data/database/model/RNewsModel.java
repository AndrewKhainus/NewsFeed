package com.radomar.newsfeed.data.database.model;

import com.radomar.newsfeed.data.model.NewsModel;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Andrew on 16.05.2017.
 */

public class RNewsModel extends RealmObject {

    public static String FIELD_SOURCE = "source";
    public static String FIELD_ID = "id";
    public static String FIELD_IS_FAVORITE = "isFavorite";

    @PrimaryKey
    int id;

    String source;

    String author;

    String description;

    String publishedAt;

    String title;

    String linkUrl;

    String imageUrl;

    boolean isFavorite = false;

    public RNewsModel() {
    }

    public RNewsModel(String source, String author, String description, String publishedAt, String title, String linkUrl, String imageUrl) {
        this.source = source;
        this.author = author;
        this.description = description;
        this.publishedAt = publishedAt;
        this.title = title;
        this.linkUrl = linkUrl;
        this.imageUrl = imageUrl;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public NewsModel getNewsModel() {

        return new NewsModel(getId(), getSource(), getAuthor(), getDescription(), getPublishedAt(), getTitle(), getLinkUrl(), getImageUrl());
    }
}
