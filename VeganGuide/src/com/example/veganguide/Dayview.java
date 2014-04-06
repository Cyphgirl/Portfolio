package com.example.veganguide;



import java.util.Calendar;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

@SuppressLint("NewApi")
public class Dayview extends Activity {
TextView daylist;
final Calendar c = Calendar.getInstance();
int currentYear;
int currentMonth;
int currentDay ;
Button newfood;
Button exist;
Button newday;
Button choose;
Files files; 

VeganFiles f = new VeganFiles();
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dayview);
		files = Files.getInstance();
		exist = (Button) findViewById(R.id.exist);
		newfood = (Button) findViewById(R.id.newfood);
		newday = (Button) findViewById(R.id.newday);
		choose = (Button) findViewById(R.id.ChooseDay);
		daylist = (TextView) findViewById(R.id.daylist);
		daylist.setText(files.getJournal().get(files.getCurrday()).getText());
		daylist.setMovementMethod(new ScrollingMovementMethod());
		newfood.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				goNext(0);
				
			}
		});
exist.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				goNext(1);
				
			}
		});
	
	
	newday.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			goNext(3);
			
		}
	});

choose.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		goNext(2);
		
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
		getMenuInflater().inflate(R.menu.dayview, menu);
		return true;
	}
	private void goNext(int which){
		
		Intent intent = new Intent();
		switch(which){
		case 0: intent.setClass(getBaseContext(), AddFood.class);
		startActivity(intent);
		break;
		case 1:	intent.setClass(getBaseContext(), Listfoods.class);
		startActivity(intent);
		break;
		case 2: intent.setClass(getBaseContext(), DayList.class);
		startActivity(intent);
		break;
		case 3:
			files.setCurrday(files.getJournal().size()); 				
				files.getJournal().add(new Day(files.getCurrday()));
				
			    					
			DialogFragment newFragment = new DatePickerFragment();
		    newFragment.show(getFragmentManager(), "datePicker");
		    
		break;
	}
		
	}
	
	

	public void onPause(){
		super.onPause();
		this.onStop();
	}
}
