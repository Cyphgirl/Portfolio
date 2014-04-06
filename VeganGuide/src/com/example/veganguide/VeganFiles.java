/*
 * order of files is
 * Name
 * Serving
 * Grain
 * Legume
 * Nut
 * Veg
 * Fruit
 * Fat
 * Calcium
 * 
 * 
 */


package com.example.veganguide;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.util.ArrayList;

import android.content.Context;

public class VeganFiles {



public Foodlist readFoodFile(Context context){
	Foodlist list = new Foodlist();
	Food f;
	ObjectInputStream in;
	FileInputStream read;
	BufferedInputStream bf;
	try{read = context.openFileInput("veg");
	bf = new BufferedInputStream(read);
	in = new ObjectInputStream(bf);
	while(true){
	
	if ((f = (Food) in.readObject()) != null){
		list.addFood(f);
	}else break;
	}
	in.close();
}catch(IOException e){} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	
	
	return list;
	
	
	
}

private Food readFood(ObjectInputStream in) throws OptionalDataException, ClassNotFoundException, IOException{
	Food f;
	Object test;
	String name, serve;
	float Gr, Le, Nu, Ve, Fr, Fa, Ca;
	if ((test = in.readObject()) != null){
		name = (String) test;
		serve = (String) in.readObject();
		Gr = in.readFloat();
		Le = in.readFloat();
		Nu = in.readFloat();
		Ve = in.readFloat();
		Fr = in.readFloat();
		Fa = in.readFloat();
		Ca = in.readFloat();
		float[] set = {Gr, Le, Nu, Ve, Fr, Fa, Ca};
		f = new Food(set, name, serve);
	}else{
		
		return null;
	}
	return f;
}
public boolean makeFoodFile(Foodlist list, Context context){
	FileOutputStream write;
	ObjectOutputStream out;
	BufferedOutputStream buf;
	try{write = context.openFileOutput("veg", Context.MODE_PRIVATE);
	buf = new BufferedOutputStream(write);
	out = new ObjectOutputStream(buf);
	for(int i = 0; i < list.getSize(); i++){
		out.writeObject(list.getFood(i));
		
	}
	out.close();
	return true;
}catch(IOException e){return false;}
}

private void writeFood(Food food, ObjectOutputStream out) throws IOException{
	out.writeObject(food.getName());
	out.writeObject(food.getServingsize());
	out.writeFloat(food.getGrain(1));
	out.writeFloat(food.getLegume(1));
	out.writeFloat(food.getNut(1));
	out.writeFloat(food.getVeg(1));
	out.writeFloat(food.getFruit(1));
	out.writeFloat(food.getFat(1));
	out.writeFloat(food.getCalcium(1));
	
}

public void writeDay(Day day, ObjectOutputStream out) throws IOException{
	//write date first
	out.writeInt(day.getIndex());
	out.writeObject(day.getDate());
	//write food then serving
	for(int i = 0; i < day.size(); i++){
		writeFood(day.getFood(i), out);
		out.writeFloat(day.getServings(i));
	}
	
}

public Day readDay(ObjectInputStream in) throws IOException, ClassNotFoundException{
	Day d;
	Food f;
	float s;
     d = new Day(in.readInt());
     d.setDate((String) in.readObject());
     while(true){
     if ((f = readFood(in)) != null){
    	 s = in.readFloat();
    	 d.addFood(f, s);
    	 
     }else{break;}

     }
	return d;
	
}
public boolean makeJournalFile(ArrayList<Day> journal, Context context){
	FileOutputStream write;
	ObjectOutputStream out;
	BufferedOutputStream buf;
	try{write = context.openFileOutput("journal", Context.MODE_PRIVATE);
	buf = new BufferedOutputStream(write);
	out = new ObjectOutputStream(buf);
	out.writeObject(journal);
	
	
	out.close();
	return true;
	}catch(IOException e){return false;}
}
@SuppressWarnings("unchecked")
public ArrayList<Day> readJournalFile(Context context){
	ArrayList<Day> result = null;
	ObjectInputStream in;
	FileInputStream read;
	BufferedInputStream bf;
	try{read = context.openFileInput("journal");
	bf = new BufferedInputStream(read);
	in = new ObjectInputStream(bf);
//	while(true){
//	
//	if ((day = readDay(in)) != null){
//		result.add(day);
//	}else break;
//	}
	result = (ArrayList<Day>) in.readObject();
	in.close();
}catch(IOException e){} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();

}
	return result;
	
}

}
