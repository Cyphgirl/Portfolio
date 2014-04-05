package yay;

import java.sql.*;
import java.util.ArrayList;

public class DBManager {
	private Connection connection;
	private ResultSet rs;
	private int check = 9;
	private PreparedStatement ps;
	private Statement sql;
	String url = "jdbc:mysql://localhost:3306/";

	public boolean startConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			check = -4;
			return false;
		}
		try {
			connection = DriverManager.getConnection(url, "a", "a");
			return true;
		} catch (SQLException e) {
			check = -5;
			return false;
		}

	}

	public boolean closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			return false;
		}
		return true;

	}

	public int getUid(String username, String password) {

		String sqltext = "Select uid from listing.logininfo where pswd=? and username=?";
		int ret = -1;
		if (connection != null) {
			try {
				ps = connection.prepareStatement(sqltext);
				check = -6;
				ps.setString(2, username);
				ps.setString(1, password);
				check = -8;
				rs = ps.executeQuery();
				check = -7;
				if (rs.next()) {
					ret = rs.getInt("uid");
				}

				return ret;
			} catch (SQLException e) {
				e.printStackTrace();
				return check;
			}

		} else {
			return -100;
		}
	}
	public ArrayList<Post> getPostsbyUid(int uid){
	String sqltext = "select datepost, title, body, location from listing.posting where postedby=" + uid;
	ArrayList<Post> result = new ArrayList<Post>();
	if(connection != null){
		try{
			sql = connection.createStatement();
			rs = sql.executeQuery(sqltext);
			while(rs.next()){
				result.add(new Post(rs.getDate("datepost"), rs.getString("location"), rs.getString("title"), rs.getString("body")));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	return result;
	}
	public ArrayList<Post> getPosts(){
	String sqltext = "select datepost, title, body, location from listing.posting";
	ArrayList<Post> result = new ArrayList<Post>();
	if(connection != null){
		try{
			sql = connection.createStatement();
			rs = sql.executeQuery(sqltext);
			while(rs.next()){
				result.add(new Post(rs.getDate("datepost"), rs.getString("location"), rs.getString("title"), rs.getString("body")));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	return result;
	}
	
	public boolean createPost(Post post, int uid){
		String sqltext= "insert into listing.posting values ((select max(idposting) + 1 from (select * from listing.posting) as p),"
		+ " current_date(),'" + post.getLocation() + "','"	+ post.getTitle()+"','" + post.getBody()+"',"+uid+")";
		if(connection != null){
			try{
				sql = connection.createStatement();
				sql.executeUpdate(sqltext);
			}catch(SQLException e){
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}
}
