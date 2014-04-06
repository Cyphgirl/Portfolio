package com.example.veganguide;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class DayAdapter extends ArrayAdapter<Day> {
    Day[] days;
	public DayAdapter(Context context, int textViewResourceId, ArrayList<Day> objects) {
		super(context, textViewResourceId, objects);
		days = new Day[objects.size()];
		days = objects.toArray(days);
	}
	
	public View getView(int position, View convertView, ViewGroup parent){
		View v = convertView;
		if (v == null) {
			LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = inflater.inflate(R.layout.list, null);
		}
		Day i = days[position];

		if (i != null) {
			TextView textview1 = (TextView) v.findViewById(R.id.textView1);
			if (textview1 != null){
				textview1.setText(i.getDate());
				
			}
		}

		return v;
		
		
	}


}
