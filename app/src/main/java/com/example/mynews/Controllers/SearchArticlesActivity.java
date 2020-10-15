package com.example.mynews.Controllers;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.mynews.Fragment.DatePickerFragment;
import com.example.mynews.R;
import com.example.mynews.View.SearchArticlesViewModel;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchArticlesActivity extends AppCompatActivity implements DatePickerFragment.OnDateSetListener, CompoundButton.OnCheckedChangeListener {

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
    //@BindView(R.id.checkbox_container)
  //  CheckBox mCheckBoxContainer;
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
    @BindView(R.id.search_button)
    Button mButton;


    //Shared preferences variables
    public static final String MyPref = "MyPrefsFile";
    SharedPreferences.Editor editor;



    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //method getSharedPreferences invoked to get an instance of sharedPreferences
       SharedPreferences mSharedPreferences = getSharedPreferences(MyPref, MODE_PRIVATE);
       SharedPreferences.Editor editor = mSharedPreferences.edit();
        mCheckBoxArts.setChecked(getFromSharedPref("arts"));
        mCheckBoxArts.setOnCheckedChangeListener(this);
        mCheckBoxBusiness.setChecked(getFromSharedPref("business"));
        mCheckBoxBusiness.setOnCheckedChangeListener(this);
        mCheckBoxEntrepreneurs.setChecked(getFromSharedPref("entrepreneurs"));
        mCheckBoxEntrepreneurs.setOnCheckedChangeListener(this);


        setContentView(R.layout.activity_search_articles);
        ButterKnife.bind(this);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.Search);

        DialogFragment datePicker = new DatePickerFragment();



        //recover the begin date with the sharedPref
       // mSearchBeginDate.setText(mSharedPreferences.getString("Begin Date","begin Date"));
        mSearchBeginDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                //This method calls show() on a new instance of the DialogFragment defined above.
                // The show() method requires an instance of FragmentManager and a unique tag name for the fragment.
                if (hasFocus) {
                    datePicker.show(getSupportFragmentManager(), "beginDatePicker");
                } else {
                    datePicker.dismiss();
                }

            }
        });

        //recover the end date with the sharedPref
       // mSearchEndDate.setText(mSharedPreferences.getString("End date","end date"));
        mSearchEndDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    datePicker.show(getSupportFragmentManager(), "endDatePicker");
                } else {
                    datePicker.dismiss();
                }
            }
        });

        mButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }




    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        // display the date chosen by the user
        Locale locale = getResources().getConfiguration().locale;
        final Calendar calendar = Calendar.getInstance(locale);
       // final DateFormat dateFormat = DateFormat.getDateFormat(DateFormat.MEDIUM, locale);
        final String myFormat = "dd/MM/yy";
        final SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        if (getCurrentFocus() != null) {
            switch (getCurrentFocus().getId()) {

                case R.id.search_begin_date:
                    calendar.set(year, month, dayOfMonth);
                    mSearchBeginDate.setText(sdf.format(calendar.getTime()));
                    //editor.putString("beginDate", sdf.format(calendar.getTime()));
                    break;
                case R.id.search_end_date:
                    calendar.set(year, month, dayOfMonth);
                    mSearchEndDate.setText(sdf.format(calendar.getTime()));
                    //editor.putString("endDate", sdf.format(calendar.getTime()));
            }
           // editor.commit();
        }
    }

    private boolean getFromSharedPref(String key){
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("MyPrefsFile", Context.MODE_PRIVATE);
        return preferences.getBoolean(key,false);
    }

    private void saveInSharedPref(String key, boolean value){
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("MyPrefsFile", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.commit();

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()){
            case R.id.search_articles_arts:
                if (isChecked){
                saveInSharedPref("arts",true);
                }
                else {
                    saveInSharedPref("arts",false);
                }
                break;
            case R.id.search_articles_business:
                if (isChecked){
                saveInSharedPref("business", true);
                }
                else {
                    saveInSharedPref("business", false);
                }
                break;
            case R.id.search_articles_entrepreneurs:
                if (isChecked){
                saveInSharedPref("entrepreneurs",true);
                } else  {
                    saveInSharedPref("entrepreneurs", false);
                }
                break;
            case R.id.search_articles_politics:
                if (isChecked){
                    saveInSharedPref("politics",true);
                } else {
                    saveInSharedPref("politics", false);
                }
                break;
            case R.id.search_articles_sports:
                if (isChecked){
                    saveInSharedPref("sports",true);
                } else {
                    saveInSharedPref("sports", false);
                }
                break;
            case R.id.search_articles_travel:
                if (isChecked){
                    saveInSharedPref("travel",true);
                } else {
                    saveInSharedPref("travel",false);
                }
                break;
        }
    }
}



