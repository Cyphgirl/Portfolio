package com.example.veganguide;

import java.util.ArrayList;

public class Foodlist {
private ArrayList<Food> list;

public Foodlist(){
	list = new ArrayList<Food>();
	}

public void CreateFood(String Name, String serving, float Grain, float Legume, float Nut, float Veg, float Fruit, float Fat, float Calcium){
	Food food;
	float set[] = {Grain, Legume, Nut, Veg, Fruit, Fat, Calcium};
	food = new Food(set, Name, serving);
	list.add(food);
	
}

public void addFood(Food f){
	list.add(f);
}
public Food getFood(int i ){
	if (i < getSize()) return list.get(i);
	else return null;

}

public int getSize(){
	return list.size();
}

public ArrayList<Food> getList(){
	return list;
}

}
