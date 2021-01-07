package com.example.mynews.Controllers;

import android.os.Bundle;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.mynews.R;

import butterknife.BindView;

public class NotificationsActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.search_query_term_editText)
    EditText mSearchQueryTerm;
    @BindView(R.id.search_begin_date)
    EditText mSearchBeginDate;
    @BindView(R.id.search_end_date)
    EditText mSearchEndDate;
    @BindView(R.id.search_articles_arts)
    CheckBox mCheckBoxArts;
    @BindView(R.id.search_articles_business)
    CheckBox mCheckBoxBusiness;
    @BindView(R.id.search_articles_entrepreneurs)
    CheckBox mCheckBoxEntrepreneurs;
    @BindView(R.id.search_articles_politics)
    CheckBox mCheckBoxPolitics;
    @BindView(R.id.search_articles_sports)
    CheckBox mCheckboxSports;
    @BindView(R.id.search_articles_travel)
    CheckBox mCheckBoxTravel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //setSupportActionBar(toolbar);
        this.configureToolbar();



    }
    private void configureToolbar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


    }
}