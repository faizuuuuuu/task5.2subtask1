package com.example.newsapp;

public class NewsModel {
    private String title;
    private int image;
    private String description;

    public NewsModel(String title, int image, String description) {
        this.title = title;
        this.image = image;
        this.description = description;
    }

    public String getTitle() { return title; }
    public int getImage() { return image; }
    public String getDescription() { return description; }
}
