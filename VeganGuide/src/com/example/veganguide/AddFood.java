package com.example.veganguide;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import android.widget.Spinner;

public class AddFood extends Activity {
	Button create;
	Spinner grain;
	Spinner legume;
	Spinner nut;
	Spinner veg;
	Spinner fruit;
	Spinner fat;
	EditText name;
	EditText serving;
	EditText calcium;
	Files files;

	@Override
	@SuppressLint("NewApi")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_food);
		files = Files.getInstance();
		calcium = (EditText) findViewById(R.id.Calcium);
		serving = (EditText) findViewById(R.id.ServingSize);
		name = (EditText) findViewById(R.id.Name);
		fat = (	Spinner) findViewById(R.id.Fat);
		fruit = (	Spinner) findViewById(R.id.Fruit);
		veg = (	Spinner) findViewById(R.id.Veg);
		nut = (	Spinner) findViewById(R.id.Nut);
		legume = (	Spinner) findViewById(R.id.Legume);
		grain = (	Spinner) findViewById(R.id.Grain);
		create  = (Button) findViewById(R.id.Create);
		create.setOnClickListener(new View.OnClickListener(){
			
			public void onClick(View v){
				float Calcium;
				String Name, Serving;
//				Grain = grain.isChecked() ? 1 : 0;
//				Legume = legume.isChecked() ? 1:0;
//				Nut = nut.isChecked() ? 1: 0;
//				Veg = veg.isChecked() ? 1 : 0;
//				Fruit = fruit.isChecked() ? 1 : 0 ;
//				Fat = fat.isChecked() ? 1 : 0;
				Calcium = Float.parseFloat(calcium.getText().toString());
				Name = name.getText().toString();
				Serving = serving.getText().toString();
				files.getMaster().CreateFood(Name, Serving, grain.getSelectedItemPosition(), legume.getSelectedItemPosition(),nut.getSelectedItemPosition(),veg.getSelectedItemPosition(), fruit.getSelectedItemPosition(), fat.getSelectedItemPosition(), Calcium);
				float set[] = {grain.getSelectedItemPosition(), legume.getSelectedItemPosition(),nut.getSelectedItemPosition(),veg.getSelectedItemPosition(), fruit.getSelectedItemPosition(), fat.getSelectedItemPosition(), Calcium};
				files.setSelected(  new Food(set, Name, Serving));
				goNext();
			}
		});

	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_food, menu);
		return true;
	}

	private void goNext(){
		Intent intent = new Intent();
		intent.setClass(getBaseContext(), Set.class);
		startActivity(intent);
	}
	}

