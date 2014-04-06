package com.example.veganguide;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;

public class Listfoods extends ListActivity {

private MyAdapter adapter;
Files files;	
ListView list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listfoods);
	 files = Files.getInstance();

list = (ListView) findViewById(R.id.list);

		adapter = new MyAdapter(this, R.id.textView1, files.getMaster().getList());
			setListAdapter(adapter);


	}
	

	@Override
	public void onListItemClick(ListView parent, View view, int position, long id) {  
		files.setSelected(files.getMaster().getFood(position));
		goNext();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.listfoods, menu);
		return true;
	}

	private void goNext(){
		Intent intent = new Intent();
		intent.setClass(getBaseContext(), Set.class);
		startActivity(intent);
	}
}
