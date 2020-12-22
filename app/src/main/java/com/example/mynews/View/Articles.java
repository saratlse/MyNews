package com.example.mynews.View;

public class Articles {

    private  String title, date, subsection,section, imageUrl,url;




    public Articles(String section, String subsection,String title, String date, String imageUrl, String url) {
        this.title = title;
        this.date = date;
        this.section = section;
        this.imageUrl = imageUrl;
        this.subsection = subsection;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
    public String getSubsection(){
        return subsection;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}
