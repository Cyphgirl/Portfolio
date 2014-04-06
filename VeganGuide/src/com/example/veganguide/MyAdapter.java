package com.example.veganguide;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MyAdapter extends ArrayAdapter<Food>{
	private ArrayList<Food> objects;
	public MyAdapter(Context context, int textViewResourceId,
			ArrayList<Food> objects) {
		super(context, textViewResourceId, objects);
		this.objects = objects;
	}
	
	public View getView(int position, View convertView, ViewGroup parent){
		View v = convertView;
		if (v == null) {
			LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = inflater.inflate(R.layout.list, null);
		}
		Food i = objects.get(position);

		if (i != null) {
			TextView textview1 = (TextView) v.findViewById(R.id.textView1);
			if (textview1 != null){
				textview1.setText(i.toString());
				
			}
		}

		return v;
		
		
	}

}
