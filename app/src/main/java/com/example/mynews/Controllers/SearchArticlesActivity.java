package com.example.mynews.Controllers;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
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
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
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
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.view.View.GONE;

public class SearchArticlesActivity extends AppCompatActivity implements DatePickerFragment.OnDateSetListener, CompoundButton.OnCheckedChangeListener {

    //  Adding @BindView in order to indicate to ButterKnife to get & serialise it

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
    @BindView(R.id.search_button)
    Button searchButton;


    //Shared preferences variables
    public static final String MyPref = "MyPrefsFile";
    private SharedPreferences mSharedPreferences;
    SharedPreferences.Editor editor;


    private List<String> categoriesCBSelected = new ArrayList<>();
    final String[] beginDate = new String[1];
    final String[] theEndDate = new String[1];

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_search_articles);
        ButterKnife.bind(this);



        //method getSharedPreferences invoked to get an instance of sharedPreferences
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mSharedPreferences = getSharedPreferences(MyPref, MODE_PRIVATE);
        editor = mSharedPreferences.edit();

        mCheckBoxArts.setChecked(getFromSharedPref("arts"));
        mCheckBoxArts.setOnCheckedChangeListener(this);

        mCheckBoxBusiness.setChecked(getFromSharedPref("business"));
        mCheckBoxBusiness.setOnCheckedChangeListener(this);

        mCheckBoxEntrepreneurs.setChecked(getFromSharedPref("entrepreneurs"));
        mCheckBoxEntrepreneurs.setOnCheckedChangeListener(this);

        mCheckBoxPolitics.setChecked(getFromSharedPref("politics"));
        mCheckBoxPolitics.setOnCheckedChangeListener(this);

        mCheckboxSports.setChecked(getFromSharedPref("sports"));
        mCheckboxSports.setOnCheckedChangeListener(this);

        mCheckBoxTravel.setChecked(getFromSharedPref("travel"));
        mCheckBoxTravel.setOnCheckedChangeListener(this);



        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.Search);
        //setSupportActionBar(toolbar);
        this.configureToolbar();

        DialogFragment datePicker = new DatePickerFragment();





        //Search edit text
        mSearchQueryTerm.setText(mSharedPreferences.getString("searchQuery",""));
        //mSearchQueryTerm.setOnEditorActionListener((v, actionId, event) -> {
           // boolean handled = false;
           // if (actionId == EditorInfo.IME_ACTION_SEARCH) {
              //  mSearchQueryTerm.setText(mSearchQueryTerm.getText().toString());
               // editor.putString("searchQuery",mSearchQueryTerm.getText().toString()).apply();
           //     handled = true;
          //  }hideKeyboard(v);
           // return handled;
       // });
        mSearchQueryTerm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                editor.putString("searchQuery",mSearchQueryTerm.getText().toString()).apply();
            }
        });


        //recover the begin date with the sharedPref
        mSearchBeginDate.setText(mSharedPreferences.getString("beginDate","begin Date"));
        mSearchBeginDate.setOnFocusChangeListener((v, hasFocus) -> {
            //This method calls show() on a new instance of the DialogFragment defined above.
            // The show() method requires an instance of FragmentManager and a unique tag name for the fragment.
            if (hasFocus) {
                datePicker.show(getSupportFragmentManager(), "beginDatePicker");
            } else {
                datePicker.dismiss();
            }

        });

        //recover the end date with the sharedPref
        mSearchEndDate.setText(mSharedPreferences.getString("endDate","end date"));
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


        searchButton.setOnClickListener(v -> searchButtonClicked(v));
    }


    // --------------------------------
    // DATE PICKER AND FORMAT TIME
    // -------------------------------
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
                    editor.putString("beginDate", sdf.format(calendar.getTime()));
                    break;
                case R.id.search_end_date:
                    calendar.set(year, month, dayOfMonth);
                    mSearchEndDate.setText(sdf.format(calendar.getTime()));
                    editor.putString("endDate", sdf.format(calendar.getTime()));
            }
            editor.commit();
        }
    }

    private boolean getFromSharedPref(String key) {
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("MyPrefsFile", Context.MODE_PRIVATE);
        return preferences.getBoolean(key, false);
    }

    private void saveInSharedPref(String key, boolean value) {
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("MyPrefsFile", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.commit();

    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.search_articles_arts:
                if (isChecked) {
                    saveInSharedPref("arts", true);
                } else {
                    saveInSharedPref("arts", false);
                }
                break;
            case R.id.search_articles_business:
                if (isChecked) {
                    saveInSharedPref("business", true);
                } else {
                    saveInSharedPref("business", false);
                }
                break;
            case R.id.search_articles_entrepreneurs:
                if (isChecked) {
                    saveInSharedPref("entrepreneurs", true);
                } else {
                    saveInSharedPref("entrepreneurs", false);
                }
                break;
            case R.id.search_articles_politics:
                if (isChecked) {
                    saveInSharedPref("politics", true);
                } else {
                    saveInSharedPref("politics", false);
                }
                break;
            case R.id.search_articles_sports:
                if (isChecked) {
                    saveInSharedPref("sports", true);
                } else {
                    saveInSharedPref("sports", false);
                }
                break;
            case R.id.search_articles_travel:
                if (isChecked) {
                    saveInSharedPref("travel", true);
                } else {
                    saveInSharedPref("travel", false);
                }
                break;
        }
        // --------------------------------
        // Hide Key board Methods
        // -------------------------------

    }

    private void hideKeyboard(View rootView) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        Objects.requireNonNull(inputMethodManager).hideSoftInputFromWindow(rootView.getWindowToken(), 0);
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.search_articles_arts:
                if (checked) {
                    editor.putBoolean("arts", false);
                } else
                    mCheckBoxArts = findViewById(R.id.search_articles_arts);
                mCheckBoxArts.setChecked(true);
                categoriesCBSelected.add("arts");
                break;
            case R.id.search_articles_business:
                if (checked) {
                    // Cheese me
                } else
                    // I'm lactose intolerant
                    break;

        }
    }
    @OnClick(R.id.search_button)
    public void searchButtonClicked(View view) {

        String searchQuery = mSearchQueryTerm.getText().toString();

        if (mCheckBoxArts.isChecked()) {
            categoriesCBSelected.add("arts");
        }
        if (mCheckBoxPolitics.isChecked()) {
            categoriesCBSelected.add("politics");
        }
        if (mCheckBoxBusiness.isChecked()) {
            categoriesCBSelected.add("business");
        }
        if (mCheckboxSports.isChecked()) {
            categoriesCBSelected.add("sports");
        }
        if (mCheckBoxEntrepreneurs.isChecked()) {
            categoriesCBSelected.add("entrepreneurs");
        }
        if (mCheckBoxEntrepreneurs.isChecked()) {
            categoriesCBSelected.add("travel");
        }

        Intent myIntent = new Intent();
        myIntent.putExtra("SearchTitle",true);
        setResult(Activity.RESULT_OK,myIntent);
        editor.commit();
        finish();

        categoriesCBSelected.clear();
    }



    // ---------------------------------
    // Display/Hide UI elements methods
    // ---------------------------------
        private void configureToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Search Articles");

    }




    // Hides Search elements
    private void displayNotificationsInterfaceElements() {
        hideSearchBeginDateLabel();
        hideSearchBeginDatePicker();
        hideSearchEndDateLabel();
        hideSearchEndDatePicker();
    }

    // Hides Text label: "Begin date"
    private void hideSearchBeginDateLabel() {
        mSearchBeginDate = findViewById(R.id.search_begin_date);
        mSearchBeginDate.setVisibility(GONE);
    }

    // Hides TextView: "Begin date"
    private void hideSearchBeginDatePicker() {
        mSearchBeginDate= findViewById(R.id.search_begin_date);
        mSearchBeginDate.setVisibility(GONE);
    }

    // Hides Text label: "End date"
    private void hideSearchEndDateLabel() {
        mSearchEndDate= findViewById(R.id.search_end_date);
        mSearchEndDate.setVisibility(GONE);
    }

    // Hides TextView: "End date"
    private void hideSearchEndDatePicker() {
       mSearchEndDate = findViewById(R.id.search_end_date);
        mSearchEndDate.setVisibility(GONE);
    }


}

