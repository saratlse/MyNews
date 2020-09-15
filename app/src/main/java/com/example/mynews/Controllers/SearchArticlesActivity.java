package com.example.mynews.Controllers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.mynews.R;
import com.example.mynews.View.SearchArticlesViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchArticlesActivity extends AppCompatActivity {

    //  Adding @BindView in order to indicate to ButterKnife to get & serialise it
    @BindView(R.id.menu) Menu mMenu;
    @BindView(R.id.toolbar)Toolbar mToolbar ;
    @BindView(R.id.search_query_term_editText) EditText mSearchQueryTerm;
    @BindView(R.id.search_begin_date) EditText mSearchBeginDate;
    @BindView(R.id.search_end_date) EditText mSearchEndDate;
    @BindView(R.id.checkbox_container) CheckBox mCheckBox;
    @BindView(R.id.search_articles_arts) CheckBox mCheckBoxArts;
    @BindView(R.id.search_articles_business)CheckBox mCheckBoxBusiness;
    @BindView(R.id.search_articles_entrepreneurs)CheckBox mCheckBoxEntrepreneurs;

    @BindView(R.id.search_button) Button mButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_articles);
        ButterKnife.bind(this);




        }

}