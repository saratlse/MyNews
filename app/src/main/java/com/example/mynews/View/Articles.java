package com.example.mynews.View;

public class Articles {

    private final String title, date, section, imageUrl;


    public Articles( String section,String title,  String date,  String imageUrl) {
        this.title = title;
        this.date = date;
        this.section = section;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getSection() {
        return section;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}
