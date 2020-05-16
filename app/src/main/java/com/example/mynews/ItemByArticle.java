package com.example.mynews;

public class ItemByArticle {

    private final String title;
    private final String date;
    private final String section;
    private final String imageUrl;

    public ItemByArticle(final String title, final String date, final String section, final String imageUrl) {
        this.title = title;
        this.date = date;
        this.section = section;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDate() {
        return this.date;
    }

    public String getSection() {
        return this.section;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }


}
