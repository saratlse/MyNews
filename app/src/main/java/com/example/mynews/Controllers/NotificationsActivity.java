package com.example.mynews.Controllers;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.example.mynews.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;

public class NotificationsActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.search_query_term_editText)
    EditText editTextSearchNotification;
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
    @BindView(R.id.once_per_day)
    TextView oncePerDay;
    @BindView(R.id.notification_switch)
    Switch notificationSwitch;


    public static final String NY_PREFS_NAME = "NotificationsFile";
    private List<String> categoriesBeSelected = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //setSupportActionBar(toolbar);
        this.configureToolbar();

        final SharedPreferences.Editor editor = getSharedPreferences(NY_PREFS_NAME, MODE_PRIVATE).edit();
        SharedPreferences sharedPreferences = getSharedPreferences(NY_PREFS_NAME, MODE_PRIVATE);

        final boolean isChecked = sharedPreferences.getBoolean("isChecked", false);
        boolean isArtsChecked = sharedPreferences.getBoolean("isArtsChecked", false);
        boolean isPoliticsChecked = sharedPreferences.getBoolean("isPoliticsChecked", false);
        boolean isBusinessChecked = sharedPreferences.getBoolean("isBusinessChecked", false);
        boolean isSportsChecked = sharedPreferences.getBoolean("isSportsChecked", false);
        boolean isEntrepreneursChecked = sharedPreferences.getBoolean("isEntrepreneursChecked", false);
        boolean isTravelChecked = sharedPreferences.getBoolean("isTravelChecked", false);

        // --------------------------------
        // SharedPref
        // -------------------------------
        editTextSearchNotification.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                editor.putString("editTextNotification", editTextSearchNotification.getText().toString());
                editor.apply();
            }

            @Override
            public void afterTextChanged(Editable s) {
                editor.putString("textNotifications", editTextSearchNotification.getText().toString());
                editor.apply();

            }
        });

        String editTextValue = sharedPreferences.getString("editTextNotification", "");
        editTextSearchNotification.setText(editTextValue);

       /*-------------artsCB-----------------*/
       mCheckBoxArts.setChecked(isArtsChecked);
        mCheckBoxArts.setOnCheckedChangeListener((compoundButton, b) -> {
            editor.putBoolean("isArtsChecked", b);
            editor.apply();
        });

        /*-------------politicsCB-----------------*/
        mCheckBoxPolitics.setChecked(isPoliticsChecked);
        mCheckBoxPolitics.setOnCheckedChangeListener((compoundButton, b) -> {
            editor.putBoolean("isPoliticsChecked", b);
            editor.apply();
        });

        /*-------------sportsCB-----------------*/
        mCheckboxSports.setChecked(isSportsChecked);
        mCheckboxSports.setOnCheckedChangeListener((compoundButton, b) -> {
            editor.putBoolean("isSportsChecked", b);
            editor.apply();
        });

        /*-------------businessCB-----------------*/
        mCheckBoxBusiness.setChecked(isBusinessChecked);
        mCheckBoxBusiness.setOnCheckedChangeListener((compoundButton, b) -> {
            editor.putBoolean("isBusinessChecked", b);
            editor.apply();
        });

        /*-------------entrepreneursCB-----------------*/
        mCheckBoxEntrepreneurs.setChecked(isEntrepreneursChecked);
        mCheckBoxEntrepreneurs.setOnCheckedChangeListener((compoundButton, b) -> {
            editor.putBoolean("isEntrepreneursChecked", b);
            editor.apply();
        });

        /*-------------travelCB-----------------*/
        mCheckBoxTravel.setChecked(isTravelChecked);
        mCheckBoxTravel.setOnCheckedChangeListener((compoundButton, b) -> {
            editor.putBoolean("isTravelChecked", b);
            editor.apply();
        });



        /*-------------notificationSwitch-----------------*/

        if (notificationSwitch != null) {
            notificationSwitch.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) this);
            notificationSwitch.setChecked(isChecked);
        }
        /*-------------SettingNotification-----------------*/
        if (isChecked) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            /*-------------AlarmManager-----------------*/

            Intent intent = new Intent(getApplicationContext(), NotificationsNewsReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),
                    Integer.parseInt("200"), intent, PendingIntent.FLAG_UPDATE_CURRENT);
            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            assert alarmManager != null;
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                    AlarmManager.INTERVAL_HALF_HOUR, pendingIntent);




        }

    }

    /*@Override
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
    }*/
    private void configureToolbar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


    }
    /*private boolean getFromSharedPref(String key) {
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("MyPrefsFile", Context.MODE_PRIVATE);
        return preferences.getBoolean(key, false);
    }*/

   /* private void saveInSharedPref(String key, boolean value) {
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("MyPrefsFile", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.commit();

    }*/
}