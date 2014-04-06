package com.example.veganguide;

import java.io.Serializable;

/*
 * Name is the name of the food
 * Groups is an array of 7 elements
 * representing corresponding food groups per serving in this order
 * [grains, legumes/soyfoods, Nuts/Seeds, Vegetables, Fruits, Fats, Calcium]
 * 
 * 
 */
public class Food implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String name;
private float groups[];
private String servingsize;

public Food(){
	groups = new float[7];
	for(int i = 0; i < 7; i++){
		groups[i] = 0;
		}
	name = "";
	setServingsize("");

}

public Food(float[]groups, String name, String size){
	this.groups = groups;
	this.name = name;
	this.setServingsize(size);
}
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}


public void setGrain (int amt){
	this.groups[0] = amt;
	
}

public void setLegume (int amt){
	this.groups[1] = amt;
}
public void setNut (int amt){
	this.groups[2] = amt;
}
public void setVeg (int amt){
	this.groups[3] = amt;
}
public void setFruit (int amt){
	this.groups[4] = amt;
}
public void setFat (int amt){
	this.groups[5] = amt;
}
public void setCalcium (float amt){
	this.groups[6] = amt;
}

public float getGrain (float servings){
	return this.groups[0] * servings;
	
}
public float getLegume (float servings){
	return this.groups[1] * servings;
}
public float getNut (float servings){
	return this.groups[2] * servings;
}
public float getVeg (float servings){
	return this.groups[3] * servings;
}
public float getFruit (float servings){
	return this.groups[4] * servings;
}
public float getFat (float servings){
	return this.groups[5] * servings;
}
public float getCalcium (float servings){
	return this.groups[6] * servings;
}

public String getServingsize() {
	return servingsize;
}

public void setServingsize(String servingsize) {
	this.servingsize = servingsize;
}

public String toString(){
	String s = "";
	s = s + name + '\n' + servingsize;
	return s;
	
}


}
