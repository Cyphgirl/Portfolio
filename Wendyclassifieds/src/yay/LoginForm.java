package yay;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LoginForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private int uid;
	private String name;
	private String email;
	private String location;
	private String telno;
	private String bio;


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if (username == null || username.length() < 1) {
			errors.add("userName", new ActionMessage("error.username.required"));
		}
		if (password == null || password.length() < 1) {
			errors.add("password", new ActionMessage("error.password.required"));
		}
		return errors;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTelno() {
		return telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}
}
