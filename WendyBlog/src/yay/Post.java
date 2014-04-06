package yay;

import java.sql.Date;

public class Post {
 private Date date;
 private String location;
 private String title;
 private String body;
 private String name;
	public Post(Date date, String location, String title, String body, String name){
	 this.setDate(date);
	 this.setLocation(location);
	 this.setTitle(title);
	 this.setBody(body);
	 this.setName(name);
 
 }
	public Post( String location, String title, String body){
		this.setLocation(location);
		 this.setTitle(title);
		 this.setBody(body);
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	public String toString(){
		String result = "";
		result += date.toString() + "\n";
		result += title + "\n";
		result += location + "\n";
		result += body + "\n";
		return result;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
