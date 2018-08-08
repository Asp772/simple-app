package com.example.simpleProj.model;

/**
 * Created by Kamarou_S on 07.08.2018.
 */
public class Song {
    private String name;
    private String author;
    private String url;

    public Song(String name, String author, String url) {
        this.name = name;
        this.author = author;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
