package com.example.mynews.Controllers;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;


public class Channel extends Application {


    public static final String FAVOURITE_CONTENT = "favouriteContent";
    public static final String BREAKING_NEWS = "breaking_news";

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel favourite_content = new NotificationChannel(
                    FAVOURITE_CONTENT,
                    "Favourite Content",
                    //constant define how the notification behave
                    NotificationManager.IMPORTANCE_HIGH
            );
            favourite_content.setDescription("This is Chanel 1");

            NotificationChannel breaking_news = new NotificationChannel(
                    BREAKING_NEWS,
                    "Breaking News",
                    NotificationManager.IMPORTANCE_LOW
            );
            breaking_news.setDescription("This channel is 2");

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(favourite_content);
            notificationManager.createNotificationChannel(breaking_news);
        }
    }
}

