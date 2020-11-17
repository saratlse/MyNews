package com.example.mynews.Controllers;

import android.content.Intent;
import android.os.Bundle;

import com.example.mynews.Adapter.SearchArticlesAdapter;
import com.example.mynews.Adapter.TopStoriesAdapter;
import com.example.mynews.Fragment.MostPopularFragment;
import com.example.mynews.Fragment.TopStoriesFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.mynews.R;

import butterknife.BindView;

import static com.example.mynews.Controllers.MainActivity.KEY_URL;

public class WebViewActivity extends AppCompatActivity {
    @BindView(R.id.webView)
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        //Get WebView
        WebView webView = findViewById(R.id.webView);

        //Get the transferred data from the source activity
        Intent intent = getIntent();
        String url = intent.getStringExtra(KEY_URL);

       // webView.loadUrl(url);
        //this.configureWebViewMostPopular();

        // Open the webView in the app instead of a browser
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);

    }
   /* public void configureWebViewMostPopular() {
        String url = getIntent().getStringExtra(MostPopularFragment.BUNDLE_URL);
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient());
    }*/



}