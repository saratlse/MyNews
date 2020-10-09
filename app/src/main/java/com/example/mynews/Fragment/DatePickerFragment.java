package com.example.mynews.Fragment;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.mynews.R;

import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;


public  class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    OnDateSetListener onDateSetListener;


    public interface OnDateSetListener {
        void onDateSet(DatePicker view, int year, int month, int dayOfMonth);

    }

   @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);

        try {
            onDateSetListener = (OnDateSetListener) activity;


        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnDateSetListener.");

        }
    }




        @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance(getResources().getConfiguration().locale);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);


       DatePickerDialog  datePickerDialog = new DatePickerDialog(getActivity(),R.style.MyDatePickerDialogTheme, this, year,month,day);

       //DatePickerDialog  datePickerDialog = new DatePickerDialog(getActivity(),AlertDialog.THEME_DEVICE_DEFAULT_DARK,this,year,month,day);

        // Create a new instance of DatePickerDialog and return it
        return datePickerDialog;

    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(year,month,dayOfMonth);

       if (onDateSetListener!= null) {
           onDateSetListener.onDateSet(view, year, month, dayOfMonth);
    }
    }
}

