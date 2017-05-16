package com.radomar.newsfeed.network.responses;

import com.google.gson.annotations.SerializedName;
import com.radomar.newsfeed.data.database.model.RNewsModel;
import com.radomar.newsfeed.data.model.NewsModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrew on 15.05.2017.
 */

public class NewsResponse {

    private String status;
    private String source;
    private String sortBy;

    @SerializedName("articles")
    private List<Article> news;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public List<Article> getNews() {
        return news;
    }

    public void setNews(List<Article> news) {
        this.news = news;
    }

    class Article {
        private String author;
        private String title;
        private String description;
        private String url;
        private String urlToImage;
        private String publishedAt;

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

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUrlToImage() {
            return urlToImage;
        }

        public void setUrlToImage(String urlToImage) {
            this.urlToImage = urlToImage;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }
    }


    public List<RNewsModel> getRModels() {

        List<RNewsModel> databaseModels = new ArrayList<>();

        for (int i = 0; i < news.size(); i++) {
            Article article = news.get(i);

            RNewsModel databaseModel = new RNewsModel(source, article.getAuthor(),
                                                      article.getDescription(), article.getPublishedAt(),
                                                      article.getTitle(), article.getUrl(), article.getUrlToImage());

            databaseModels.add(databaseModel);
        }

        return databaseModels;
    }
}
