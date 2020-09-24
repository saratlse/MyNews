package com.example.mynews.Controllers;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.mynews.Fragment.DatePickerFragment;
import com.example.mynews.R;
import com.example.mynews.View.SearchArticlesViewModel;

import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchArticlesActivity extends AppCompatActivity implements View.OnClickListener {

    //  Adding @BindView in order to indicate to ButterKnife to get & serialise it
    //@BindView(R.id.menu) Menu mMenu;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.search_query_term_editText)
    EditText mSearchQueryTerm;
    @BindView(R.id.search_begin_date)
    EditText mSearchBeginDate;
    @BindView(R.id.search_end_date)
    EditText mSearchEndDate;
    //  @BindView(R.id.checkbox_container) CheckBox mCheckBox;
    @BindView(R.id.search_articles_arts)
    CheckBox mCheckBoxArts;
    @BindView(R.id.search_articles_business)
    CheckBox mCheckBoxBusiness;
    @BindView(R.id.search_articles_entrepreneurs)
    CheckBox mCheckBoxEntrepreneurs;
    @BindView(R.id.search_button)
    Button mButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_articles);
        ButterKnife.bind(this);

        mSearchBeginDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus){
            //This method calls show() on a new instance of the DialogFragment defined above.
            // The show() method requires an instance of FragmentManager and a unique tag name for the fragment.
                if (v == mSearchBeginDate && hasFocus){
                    DialogFragment newFragment = new DialogFragment();
                    newFragment.show(getSupportFragmentManager(),"datePicker");
                }

            }
        });
        mSearchEndDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (v == mSearchEndDate && hasFocus){
                    DialogFragment newFragment = new DialogFragment();
                    newFragment.show(getSupportFragmentManager(),"datePicker");
                }
            }
        });

    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


    }

    }
