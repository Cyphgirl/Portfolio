package com.example.veganguide;

import java.util.ArrayList;

public class Files {
	private static Files instance;
	private Files(){}
	private ArrayList<Day> journal;
	private Foodlist master;
	private Food selected;
	private int currday;
	public static synchronized Files getInstance(){
	     if(instance==null){
	       instance=new Files();
	     }
	     return instance;
	   }
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

	public ArrayList<Day> getJournal() {
		return journal;
	}
	public void setJournal(ArrayList<Day> journal) {
		this.journal = journal;
	}
	public int getCurrday() {
		return currday;
	}
	public void setCurrday(int currday) {
		this.currday = currday;
	}
}
