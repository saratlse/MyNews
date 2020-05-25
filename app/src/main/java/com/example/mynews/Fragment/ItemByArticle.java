package com.example.mynews.Fragment;

class ItemByArticle {

    private final String title, date, section, imageUrl;


    public ItemByArticle(String title, String date, String section, String imageUrl) {
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
