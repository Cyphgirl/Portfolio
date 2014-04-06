package com.example.veganguide;
import java.io.Serializable;

import java.util.ArrayList;


public class Day implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private ArrayList<Food> items;
private ArrayList<Float> servings;
private String name;
private int index;
public Day(int num){
	this.items = new ArrayList<Food>();
	this.index = num;
	this.servings = new ArrayList<Float>();
}

public Day(Food items[], int index, int year, int month, int day, float servings[]){
	this.items = new ArrayList<Food>();
	this.servings = new ArrayList<Float>();
	for(int i = 0; i < items.length; i++){
		this.items.add(items[i]);
		this.servings.add(servings[i]);
		}
	this.index = index;
	String s = "";
	s = s + Integer.toString(day) + "/" +  Integer.toString(month) + "/" + Integer.toString(year);
	name = s;
}

public void setIndex(int i){
	this.index = i;
}

public int getIndex(){
	return this.index;
}
public void setDate (int year, int month, int day){
	String s = "";
	s = s + Integer.toString(day) + "/" +  Integer.toString(month) + "/" + Integer.toString(year);
	name = s;
	}
public void setDate(String name){
	this.name = name;
}

public String getDate(){
	return name;
}

public void addFood(Food item, float serving){
	this.items.add(item);
	this.servings.add(serving);
}

public float[] getTotals(){
float[] tot = new float[7];
for (int i = 0; i <7;i++) tot[i] = 0;
for(int i = 0; i<this.items.size(); i++){
	tot[0] += this.items.get(i).getGrain(this.servings.get(i));
	tot[1] += this.items.get(i).getLegume(this.servings.get(i));
	tot[2] += this.items.get(i).getNut(this.servings.get(i));
	tot[3] += this.items.get(i).getVeg(this.servings.get(i));
	tot[4] += this.items.get(i).getFruit(this.servings.get(i));
	tot[5] += this.items.get(i).getFat(this.servings.get(i));
	tot[6] += this.items.get(i).getCalcium(this.servings.get(i));
}
return tot;
}



public String getText(){
	String s = "";
	float[] totals;
	s += "Food for day: ";
	s += this.getDate();

	if (items.size() > 0){
	for(int i = 0; i < items.size(); i++){
		s+= "\n\n";
		s += items.get(i).getName();
		s += "\n";
		s += Float.toString(servings.get(i));
		s += " servings of size ";
		s += items.get(i).getServingsize();

		
	}
	totals = getTotals();
	s = s + "\nTotals\n";
	s = s + Float.toString(totals[0]) + " Grains, " + Float.toString(totals[1]) + " Legumes, " + Float.toString(totals[2]) + " Nuts, " + Float.toString(totals[3]) + " Vegetables, " + Float.toString(totals[4]) + " Fruit, " + Float.toString(totals[5]) + " Oils, " + Float.toString(totals[6]) + " Calcium";
	}else{
		s += "\nplease enter food.";
	}
	return s;
}

public int size(){
	return items.size();
}
public Food getFood(int position){
	return items.get(position);
}

public float getServings (int position){
	return servings.get(position);
}

}


