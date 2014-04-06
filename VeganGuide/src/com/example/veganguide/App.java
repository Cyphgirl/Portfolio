package com.example.veganguide;

import java.util.ArrayList;

import android.app.Application;

public class App extends Application {
	private ArrayList<Day> journal;
	  private String myState;
		private Foodlist master;
		private Food selected;
		public Food getSelected() {
			return selected;
		}
		public void setSelected(Food selected) {
			this.selected = selected;
		}
		public Foodlist getMaster() {
			return master;
		}
		public void setMaster(Foodlist master) {
			this.master = master;
		}
		public String getMyState() {
			return myState;
		}
		public void setMyState(String myState) {
			this.myState = myState;
		}
		public ArrayList<Day> getJournal() {
			return journal;
		}
		public void setJournal(ArrayList<Day> journal) {
			this.journal = journal;
		}
	 
	}

