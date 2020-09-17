package com.example.mynews.Controllers;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

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
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.mynews.R;
import com.example.mynews.View.SearchArticlesViewModel;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchArticlesActivity extends AppCompatActivity implements View.OnClickListener{

    //  Adding @BindView in order to indicate to ButterKnife to get & serialise it
    //@BindView(R.id.menu) Menu mMenu;
    @BindView(R.id.toolbar)Toolbar mToolbar ;
    @BindView(R.id.search_query_term_editText) EditText mSearchQueryTerm;
    @BindView(R.id.search_begin_date) EditText mSearchBeginDate;
    @BindView(R.id.search_end_date) EditText mSearchEndDate;
  //  @BindView(R.id.checkbox_container) CheckBox mCheckBox;
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


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        if ( v == mSearchBeginDate){

        }



    }


    public static class TimePickerFragment extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            // Do something with the time chosen by the user
        }
    }

}