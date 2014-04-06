package com.example.veganguide;
import java.util.Calendar;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.widget.DatePicker;

@SuppressLint("NewApi")
public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

public Dialog onCreateDialog(Bundle savedInstanceState) {
// Use the current date as the default date in the picker
final Calendar c = Calendar.getInstance();
int year = c.get(Calendar.YEAR);
int month = c.get(Calendar.MONTH);
int day = c.get(Calendar.DAY_OF_MONTH);

// Create a new instance of DatePickerDialog and return it
return new DatePickerDialog(getActivity(), this, year, month, day);
}
@Override
public void onDateSet(DatePicker view, int year, int month, int day) {
	Pattern pattern = 
            Pattern.compile("Dayview");

            Matcher matcher = 
            pattern.matcher(getActivity().getClass().getName());
   if (matcher.find()){
	   ((Dayview) getActivity()).files.getJournal().get(((Dayview) getActivity()).files.getCurrday()).setDate(year, month+1, day);
	   ((Dayview) getActivity()).daylist.setText("Please add items.");
   }else{
	   ((MainActivity) getActivity()).files.getJournal().get(((MainActivity) getActivity()).files.getCurrday()).setDate(year, month + 1, day);
	   Intent intent = new Intent();
		intent.setClass(((MainActivity) getActivity()).getBaseContext(), Dayview.class);
		startActivity(intent);
   }
   
   
}
}