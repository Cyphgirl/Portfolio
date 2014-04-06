package com.example.veganguide;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Set extends Activity {
	Button add;
	
 EditText serveselect;
	Files files;
	@Override
	@SuppressLint("NewApi")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_set);
		serveselect = (EditText) findViewById(R.id.ServingSelect);
		add = (Button) findViewById(R.id.Add);
		files = Files.getInstance();
		add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				float serve = 0;
				try{
					serve = Float.parseFloat(serveselect.getText().toString());
					files.getJournal().get(files.getCurrday()).addFood(files.getSelected(), serve);
				}catch (NumberFormatException e){				}
				goNext();
			}
		});
	}
	

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.set, menu);
		return true;
	}
	private void goNext(){
		Intent intent = new Intent();
		intent.setClass(getBaseContext(), Dayview.class);
		startActivity(intent);
	}
	
}
