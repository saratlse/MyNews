package com.example.mynews.Controllers;

import android.content.Intent;
import android.graphics.Bitmap;
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
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.mynews.R;

import butterknife.BindView;

import static com.example.mynews.Controllers.MainActivity.KEY_URL;

public class WebViewActivity extends AppCompatActivity {
    @BindView(R.id.webView)
    WebView webView;
    String url ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        //Get WebView
        WebView webView = findViewById(R.id.webView);

        //Get the transferred data from the source activity
        Intent intent = getIntent();
        url = intent.getStringExtra(KEY_URL);



        // Open the webView in the app instead of a browser
        webView.getUrl();
        webView.loadUrl(url);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);

            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
            }

            @Override
            public void onReceivedIcon(WebView view, Bitmap icon) {
                super.onReceivedIcon(view, icon);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()){
            webView.goBack();
        }else {
            finish();
        }
    }
}