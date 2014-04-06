package com.example.veganguide;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;

public class DayList extends ListActivity {
	
	Files files;	
	ListView list;
	VeganFiles f = new VeganFiles();

	
	private DayAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_day_list);
		 files = Files.getInstance();

		 list = (ListView) findViewById(R.id.list);
		 adapter = new DayAdapter(this, R.id.textView1, files.getJournal());
			setListAdapter(adapter);
	}

	public void onListItemClick(ListView parent, View view, int position, long id) {  
		files.setCurrday(files.getJournal().get(position).getIndex());
		goNext();
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.day_list, menu);
		return true;
	}
	private void goNext(){
		Intent intent = new Intent();
		intent.setClass(getBaseContext(), Dayview.class);
		startActivity(intent);
	}
	
	@Override
	protected void onStop(){
		super.onStop();
		f.makeFoodFile(files.getMaster(), getBaseContext());
		f.makeJournalFile(files.getJournal(), getBaseContext());
	}
	
	@Override
	public void onPause(){
		super.onPause();
		this.onStop();
	}
}
