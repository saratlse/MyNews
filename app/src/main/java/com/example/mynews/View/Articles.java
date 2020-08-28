package com.example.mynews.View;

public class Articles {

    private  String title, date, subsection,section, imageUrl;




    public Articles(String section, String subsection,String title, String date, String imageUrl) {
        this.title = title;
        this.date = date;
        this.section = section;
        this.imageUrl = imageUrl;
        this.subsection = subsection;


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
