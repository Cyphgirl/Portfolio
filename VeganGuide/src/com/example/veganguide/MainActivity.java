package com.example.veganguide;

import java.util.ArrayList;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DialogFragment;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.content.Intent;



@SuppressLint("NewApi")
public class MainActivity extends Activity {
	VeganFiles f = new VeganFiles();
	Files files;
	Button cnt;
	Button begin;
	int currentYear;
	int currentMonth;
	int currentDay ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		files = Files.getInstance();
		cnt = (Button) findViewById(R.id.cont);
		begin = (Button) findViewById(R.id.newstart);
		Foodlist list;
		ArrayList<Day> temp;
		if ((list = f.readFoodFile(this)) != null){
		files.setMaster(list);
		}else files.setMaster(new Foodlist());
		if ((temp = f.readJournalFile(this)) != null && temp.size() != 0){
			files.setJournal(temp);
			files.setCurrday(files.getJournal().size() - 1);
		}else{
		files.setJournal(new ArrayList<Day>());
		files.getJournal().add(new Day(0));
		files.setCurrday(0);
		DialogFragment newFragment = new DatePickerFragment();
	    newFragment.show(getFragmentManager(), "datePicker");
		}
cnt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(getBaseContext(), DayList.class);
				startActivity(intent);	
			}
		});
begin.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		files.setCurrday(files.getCurrday()+1);
		files.getJournal().add(new Day(files.getCurrday()));
		DialogFragment newFragment = new DatePickerFragment();
	    newFragment.show(getFragmentManager(), "datePicker");
			
	}
});
	}
	
	@Override
	protected void onStop(){
		super.onStop();
		f.makeFoodFile(files.getMaster(), getBaseContext());
		f.makeJournalFile(files.getJournal(), getBaseContext());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

