package com.radomar.newsfeed.data.model;

/**
 * Created by Andrew on 16.05.2017.
 */

public class NewsModel {

    private int id;

    private String source;

    private String author;

    private String description;

    private String publishedAt;

    private String title;

    private String linkUrl;

    private String urlToImage;

    public NewsModel(int id, String source, String author, String description, String publishedAt, String title, String linkUrl, String urlToImage) {
        this.id = id;
        this.source = source;
        this.author = author;
        this.description = description;
        this.publishedAt = publishedAt;
        this.title = title;
        this.linkUrl = linkUrl;
        this.urlToImage = urlToImage;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
